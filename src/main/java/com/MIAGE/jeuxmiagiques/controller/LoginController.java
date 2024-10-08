package com.MIAGE.jeuxmiagiques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.MIAGE.jeuxmiagiques.model.User;
import com.MIAGE.jeuxmiagiques.repository.UserRepository;
import com.MIAGE.jeuxmiagiques.service.CustomUserDetailsService;
import com.MIAGE.jeuxmiagiques.translationUnits.LoginRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private UserRepository userRepository;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> authenticate(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getEmail());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, loginRequest.getPassword(), userDetails.getAuthorities());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        // Set the authentication in the SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("Authentication: " + SecurityContextHolder.getContext().getAuthentication());
        // Check if the authentication is successful
        if (!authentication.isAuthenticated()) {
            throw new RuntimeException("Authentication failed");
        }
        System.out.println("Authentication successful");
        HttpSession session = request.getSession();
        System.out.println("authenticated: " + authentication.isAuthenticated());
        // Get the authenticated user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = null;
        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
            System.out.println("Authenticated user: " + email);
        }
        // Get user by email
        if (email == null) {
            throw new RuntimeException("Email is null");
        }
        User user = userRepository.findByEmail(email);
        // Get userId
        int userId = user.getId();
        // Get userRole
        String userRole = user.getUserRole();

        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
        String sessionId = session.getId();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("session-id", sessionId);
        responseHeaders.set("user-id", String.valueOf(userId));
        responseHeaders.set("user-role", userRole);
        System.out.println(responseHeaders.toString()); // Log response headers to console
        System.out.println("Session ID: " + sessionId); // Log sessionId to console
        return ResponseEntity.ok()
            .headers(responseHeaders)
            .body("Authentication successful");
    }
}
