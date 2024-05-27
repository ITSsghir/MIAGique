package com.MIAGE.jeuxmiagiques.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.MIAGE.jeuxmiagiques.service.CustomUserDetailsService;
import com.MIAGE.jeuxmiagiques.translationUnits.LoginRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> authenticate(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getEmail());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, loginRequest.getPassword(), userDetails.getAuthorities());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        // Set the authentication in the SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Check if the authentication is successful
        if (!authentication.isAuthenticated()) {
            throw new RuntimeException("Authentication failed");
        }
        System.out.println("Authentication successful");
        HttpSession session = request.getSession();
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
        String sessionId = session.getId();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("session-id", sessionId);
        System.out.println(responseHeaders.toString());
        // Copy request headers to response headers
        List<String> requestHeaderNames = Collections.list(request.getHeaderNames());
        for (String headerName : requestHeaderNames) {
            responseHeaders.set(headerName, request.getHeader(headerName));
        }
        System.out.println("Session ID: " + sessionId); // Log sessionId to console
        return ResponseEntity.ok()
            .headers(responseHeaders)
            .body("Authentication successful");
    }
}
