package com.MIAGE.jeuxmiagiques.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // Set the response status to 200 OK if the logout was successful (authentication is found and removed from the SecurityContextHolder)
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("Logout successful");
        response.getWriter().flush();
    }
}
