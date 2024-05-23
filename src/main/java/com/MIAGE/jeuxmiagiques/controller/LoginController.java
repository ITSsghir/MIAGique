package com.MIAGE.jeuxmiagiques.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MIAGE.jeuxmiagiques.service.CustomUserDetailsService;
import com.MIAGE.jeuxmiagiques.translationUnits.LoginRequest;

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
    public void authenticate(@RequestBody LoginRequest loginRequest) {
        @SuppressWarnings("unused")
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getEmail());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("User " + loginRequest.getEmail() + " has been authenticated");
    }

    @PostMapping("/logout")
    public void logout() {
        SecurityContextHolder.clearContext();
        System.out.println("User has been logged out");
    }
}
