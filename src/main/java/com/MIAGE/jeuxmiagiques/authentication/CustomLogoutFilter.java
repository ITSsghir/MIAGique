package com.MIAGE.jeuxmiagiques.authentication;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CustomLogoutFilter extends OncePerRequestFilter {

    private final AntPathRequestMatcher logoutRequestMatcher = new AntPathRequestMatcher("/logout", "POST");
    private Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        if (response == null) {
            throw new IllegalArgumentException("Response cannot be null");
        }
        if (filterChain == null) {
            throw new IllegalArgumentException("Filter chain cannot be null");
        }
        if (logoutRequestMatcher.matches(request)) {
            if (authentication != null) {
                SecurityContextHolder.clearContext();
                SecurityContextHolder.getContext().setAuthentication(null);
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("Logout successful");
                response.getWriter().flush();
                return;
            }
            // else {
            //     response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            //     response.getWriter().write("Unauthorized");
            //     response.getWriter().flush();
            //     return;
            // }
        }
        filterChain.doFilter(request, response);
    }
}