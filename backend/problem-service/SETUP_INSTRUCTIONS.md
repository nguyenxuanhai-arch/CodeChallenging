# PROBLEM SERVICE - CÁC FILE CẦN TẠO THỦ CÔNG

Do không thể tạo thư mục tự động, bạn cần tạo các thư mục và files sau:

## 1. Tạo thư mục

```
backend/problem-service/src/main/java/com/codechallenge/problem/problem_service/
├── exceptions/
├── configs/
├── securities/
└── services/impl/
```

## 2. Files cần tạo

### A. exceptions/ProblemNotFoundException.java
```java
package com.codechallenge.problem.problem_service.exceptions;

public class ProblemNotFoundException extends RuntimeException {
    public ProblemNotFoundException(Long id) {
        super("Problem not found with id: " + id);
    }
}
```

### B. exceptions/TestCaseNotFoundException.java
```java
package com.codechallenge.problem.problem_service.exceptions;

public class TestCaseNotFoundException extends RuntimeException {
    public TestCaseNotFoundException(Long id) {
        super("Test case not found with id: " + id);
    }
}
```

### C. exceptions/GlobalExceptionHandler.java
```java
package com.codechallenge.problem.problem_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProblemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProblemNotFound(ProblemNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(TestCaseNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTestCaseNotFound(TestCaseNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An error occurred: " + ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    public record ErrorResponse(int status, String message, LocalDateTime timestamp) {}
}
```

### D. securities/GatewayHeaderFilter.java
```java
package com.codechallenge.problem.problem_service.securities;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class GatewayHeaderFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String userId = request.getHeader("X-User-Id");
        String userEmail = request.getHeader("X-User-Email");
        String userRole = request.getHeader("X-User-Role");

        if (userEmail != null && userRole != null) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userRole);
            
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userEmail,
                    null,
                    Collections.singletonList(authority)
            );
            
            SecurityContextHolder.getContext().setAuthentication(authToken);
            
            request.setAttribute("userId", userId != null ? Long.parseLong(userId) : null);
            request.setAttribute("userEmail", userEmail);
            request.setAttribute("userRole", userRole);
        }

        filterChain.doFilter(request, response);
    }
}
```

### E. configs/SecurityConfig.java
```java
package com.codechallenge.problem.problem_service.configs;

import com.codechallenge.problem.problem_service.securities.GatewayHeaderFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final GatewayHeaderFilter gatewayHeaderFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                .addFilterBefore(gatewayHeaderFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
```

### F. configs/WebConfig.java
```java
package com.codechallenge.problem.problem_service.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000", "http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
```

### G. services/impl/ProblemServiceImpl.java
(File quá dài - xem file riêng)

### H. services/impl/TestCaseServiceImpl.java
(File quá dài - xem file riêng)

## 3. Sau khi tạo xong

1. Cập nhật service implementations để sử dụng custom exceptions thay vì RuntimeException
2. Build project: `mvn clean install`
3. Kiểm tra không có lỗi compile
4. Khởi động service và test

## 4. Lệnh kiểm tra

```bash
# Build
cd backend/problem-service
mvn clean install

# Run
mvn spring-boot:run
```

## 5. Checklist

- [ ] Tạo thư mục exceptions/
- [ ] Tạo thư mục configs/
- [ ] Tạo thư mục securities/
- [ ] Tạo thư mục services/impl/
- [ ] Copy tất cả files Java vào đúng thư mục
- [ ] Build thành công
- [ ] Service khởi động OK
- [ ] Register với Eureka
