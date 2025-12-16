package com.stilyngnr.salon_belleza.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        // Obtener el rol
        boolean esAdmin = authentication.getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN"));

        boolean esCliente = authentication.getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_CLIENTE"));

        // Redirigir según rol
        if (esAdmin) {
            response.sendRedirect("/admin/dashboard");
        } else if (esCliente) {
            response.sendRedirect("/cliente/dashboard");
        } else {
            response.sendRedirect("/"); // fallback
        }
    }
}
