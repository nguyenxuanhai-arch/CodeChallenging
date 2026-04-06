package com.codechallenge.gateway.api_gateway.filters;

import com.codechallenge.gateway.api_gateway.securities.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        // Skip JWT validation for public endpoints
        if (isPublicEndpoint(path)) {
            log.debug("Public endpoint accessed: {}", path);
            filterChain.doFilter(request, response);
            return;
        }

        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            log.warn("Missing or invalid Authorization header for path: {}", path);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\":\"Unauthorized - Missing or invalid token\"}");
            return;
        }

        try {
            final String jwt = authHeader.substring(7);
            
            if (jwtUtil.validateToken(jwt)) {
                Claims claims = jwtUtil.extractAllClaims(jwt);
                String email = claims.getSubject();
                Long userId = claims.get("userId", Long.class);
                String role = claims.get("role", String.class);

                // Forward user information via headers to downstream services
                request.setAttribute("X-User-Id", userId != null ? userId.toString() : "");
                request.setAttribute("X-User-Email", email);
                request.setAttribute("X-User-Role", role);

                log.debug("JWT validated for user: {}, role: {}", email, role);
                
                filterChain.doFilter(request, response);
            } else {
                log.warn("Invalid JWT token");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("{\"error\":\"Unauthorized - Invalid token\"}");
            }
        } catch (Exception e) {
            log.error("JWT authentication error: {}", e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\":\"Unauthorized - " + e.getMessage() + "\"}");
        }
    }

    private boolean isPublicEndpoint(String path) {
        return path.startsWith("/auth/") || 
               path.equals("/auth/login") || 
               path.equals("/auth/register") ||
               path.startsWith("/api/v1/auth/");
    }
}
