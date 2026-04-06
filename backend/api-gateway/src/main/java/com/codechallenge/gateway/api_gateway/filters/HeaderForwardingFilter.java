package com.codechallenge.gateway.api_gateway.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class HeaderForwardingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        // Get attributes set by JwtAuthenticationFilter
        Object userId = httpRequest.getAttribute("X-User-Id");
        Object userEmail = httpRequest.getAttribute("X-User-Email");
        Object userRole = httpRequest.getAttribute("X-User-Role");

        // Forward as headers (this will be done by gateway routing)
        if (userId != null) {
            httpRequest.setAttribute("X-User-Id", userId);
            log.debug("Forwarding X-User-Id: {}", userId);
        }
        if (userEmail != null) {
            httpRequest.setAttribute("X-User-Email", userEmail);
            log.debug("Forwarding X-User-Email: {}", userEmail);
        }
        if (userRole != null) {
            httpRequest.setAttribute("X-User-Role", userRole);
            log.debug("Forwarding X-User-Role: {}", userRole);
        }

        chain.doFilter(request, response);
    }
}
