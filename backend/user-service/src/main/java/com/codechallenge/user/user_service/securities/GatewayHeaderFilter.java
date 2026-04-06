package com.codechallenge.user.user_service.securities;
 
 import jakarta.servlet.FilterChain;
 import jakarta.servlet.ServletException;
 import jakarta.servlet.http.HttpServletRequest;
 import jakarta.servlet.http.HttpServletResponse;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
 import org.springframework.security.core.authority.SimpleGrantedAuthority;
 import org.springframework.security.core.context.SecurityContextHolder;
 import org.springframework.stereotype.Component;
 import org.springframework.web.filter.OncePerRequestFilter;
 
 import java.io.IOException;
 import java.util.Collections;
 
 @Slf4j
 @Component
 public class GatewayHeaderFilter extends OncePerRequestFilter {
 
     @Override
     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
             throws ServletException, IOException {
 
         // Đọc headers từ API Gateway
         String userId = request.getHeader("X-User-Id");
         String userEmail = request.getHeader("X-User-Email");
         String userRole = request.getHeader("X-User-Role");
 
         if (userEmail != null && userRole != null) {
             // Set vào SecurityContext để dùng @PreAuthorize
             SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userRole);
             
             UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                     userEmail,
                     null,
                     Collections.singletonList(authority)
             );
             
             SecurityContextHolder.getContext().setAuthentication(authToken);
             
             // Set vào request attributes để controller dùng
             request.setAttribute("userId", userId != null ? Long.parseLong(userId) : null);
             request.setAttribute("userEmail", userEmail);
             request.setAttribute("userRole", userRole);
             
             log.debug("User authenticated from Gateway: {}, Role: {}", userEmail, userRole);
         }
 
         filterChain.doFilter(request, response);
     }
 }