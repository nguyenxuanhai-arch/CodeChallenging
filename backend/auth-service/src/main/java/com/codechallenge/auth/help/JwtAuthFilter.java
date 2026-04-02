package com.codechallenge.auth.help;

import com.codechallenge.auth.service.impl.CustomUserDetailsService;
import com.codechallenge.auth.resource.ApiResource;
import com.codechallenge.auth.service.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;
    private final ObjectMapper objectMapper;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthFilter.class);

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path.startsWith("/api/v1/auth/login") || path.startsWith("/api/v1/auth/refresh") || path.startsWith("/api/v1/auth/register");
    }

    @Override
    public void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userID;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            sendErrorResponse(response, request, HttpStatus.UNAUTHORIZED, "Xác thực thất bại", "Không tìm thấy token");
            return;
        }

        jwt = authHeader.substring(7);

        try {
            if (!jwtService.isTokenFormatValid(jwt)) {
                sendErrorResponse(response, request, HttpStatus.UNAUTHORIZED, "Xác thực thất bại", "Token không đúng định dạng");
                return;
            }

            if (!jwtService.isIssureToken(jwt)) {
                sendErrorResponse(response, request, HttpStatus.UNAUTHORIZED, "Xác thực thất bại", "Nguồn gốc token không hợp lệ");
                return;
            }

            if (!jwtService.isSignatureValid(jwt)) {
                sendErrorResponse(response, request, HttpStatus.UNAUTHORIZED, "Xác thực thất bại", "Chữ ký không hợp lệ");
                return;
            }

            if (jwtService.isTokenExpired(jwt)) {
                sendErrorResponse(response, request, HttpStatus.UNAUTHORIZED, "Xác thực thất bại", "Token đã hết hạn");
                return;
            }

            if (jwtService.isBlacklistedToken(jwt)) {
                sendErrorResponse(response, request, HttpStatus.UNAUTHORIZED, "Xác thực thất bại", "Token đã bị khóa");
                return;
            }

            userID = jwtService.getUserIdFromJwt(jwt);
            if (userID != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(userID);

                final String emailFromToken = jwtService.getEmailFromToken(jwt);
                if (!emailFromToken.equals(userDetails.getUsername())) {
                    sendErrorResponse(response, request, HttpStatus.UNAUTHORIZED, "Xác thực thất bại", "User token không chính xác");
                    return;
                }

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

            filterChain.doFilter(request, response);

        } catch (ExpiredJwtException e) {
            sendErrorResponse(response, request, HttpStatus.UNAUTHORIZED, "Xác thực thất bại", "Token đã hết hạn");
        } catch (RuntimeException e) {
            logger.error("JWT RuntimeException: {}", e.getMessage());
            if (e.getMessage() != null && e.getMessage().contains("Chữ ký token không hợp lệ")) {
                sendErrorResponse(response, request, HttpStatus.UNAUTHORIZED, "Xác thực thất bại", "Chữ ký không hợp lệ");
            } else if (e.getMessage() != null && e.getMessage().contains("Token không đúng định dạng")) {
                sendErrorResponse(response, request, HttpStatus.UNAUTHORIZED, "Xác thực thất bại", "Token không đúng định dạng");
            } else {
                sendErrorResponse(response, request, HttpStatus.INTERNAL_SERVER_ERROR, "Lỗi xử lý token", "Đã xảy ra lỗi không mong muốn khi xử lý token");
            }
        } catch (ServletException | IOException e) {
            logger.error("Servlet/IO Exception: {}", e.getMessage());
            sendErrorResponse(response, request, HttpStatus.INTERNAL_SERVER_ERROR, "Lỗi hệ thống", e.getMessage());
        }
    }

    private void sendErrorResponse(
            @NotNull HttpServletResponse response,
            @NotNull HttpServletRequest request,
            @NotNull HttpStatus status,
            @NotNull String error,
            @NotNull String message
    ) throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json;charset=UTF-8");

        ApiResource<Object> apiResponse = ApiResource.builder()
                .success(false)
                .status(status)
                .message(error)
                .error(new ApiResource.ErrorResource(
                        String.valueOf(status.value()),
                        error,
                        message + " - Path: " + request.getRequestURI()
                ))
                .build();

        response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
    }
}

