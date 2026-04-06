# API GATEWAY SERVICE

## 📋 Mô tả

API Gateway là điểm vào duy nhất cho tất cả các request từ client đến hệ thống CodeChallenge. Service này chịu trách nhiệm:

- **JWT Validation**: Xác thực token trước khi chuyển request đến backend services
- **Request Routing**: Định tuyến request đến đúng microservice
- **Header Forwarding**: Forward thông tin user (X-User-Id, X-User-Email, X-User-Role) đến backend
- **CORS Handling**: Xử lý Cross-Origin requests
- **Load Balancing**: Phân tải request qua Eureka discovery

## 🚀 Port

- **8080**

## 🔧 Dependencies

- Spring Cloud Gateway MVC
- Spring Security
- JWT (io.jsonwebtoken)
- Eureka Client
- Lombok

## 📁 Cấu trúc

```
api-gateway/
├── configs/
│   ├── SecurityConfig.java       # Spring Security config
│   ├── CorsConfig.java           # CORS configuration
│   ├── GatewayConfig.java        # Gateway beans
│   └── RouteConfig.java          # Route definitions
├── filters/
│   ├── JwtAuthenticationFilter.java    # JWT validation
│   └── HeaderForwardingFilter.java     # Forward headers
├── securities/
│   └── JwtUtil.java              # JWT utility
└── ApiGatewayApplication.java
```

## 🔐 Security Flow

```
Client Request
    ↓
CORS Filter
    ↓
JWT Authentication Filter
    ├─ Extract JWT from Authorization header
    ├─ Validate token (signature, issuer, expiration)
    ├─ Extract user info (userId, email, role)
    ↓
Header Forwarding Filter
    ├─ Set X-User-Id
    ├─ Set X-User-Email
    ├─ Set X-User-Role
    ↓
Route to Backend Service
```

## 🛣️ Routes

| Path Pattern | Target Service | Description |
|-------------|----------------|-------------|
| `/auth/**` | auth-service | Authentication endpoints |
| `/api/users/**` | user-service | User management |
| `/api/problems/**` | problem-service | Problem CRUD |
| `/api/submissions/**` | submission-service | Submit code |

## 🔑 Public Endpoints (No JWT Required)

- `/auth/**`
- `/api/v1/auth/**`
- `/actuator/**`

## ⚙️ Configuration

### application.properties

```properties
server.port=8080
spring.application.name=api-gateway

# Eureka
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/

# JWT (must match auth-service)
jwt.secret=<same-as-auth-service>
jwt.issuer=http://api.chandanv1010.com
```

## 🧪 Testing

### Test JWT Validation

```bash
# Login to get token
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"user@example.com","password":"password"}'

# Use token to access protected endpoint
curl http://localhost:8080/api/users/1 \
  -H "Authorization: Bearer <your-jwt-token>"
```

### Test Routing

```bash
# Should route to auth-service
curl http://localhost:8080/auth/login

# Should route to user-service
curl http://localhost:8080/api/users/1 \
  -H "Authorization: Bearer <token>"
```

## 📊 Monitoring

Access Eureka Dashboard: http://localhost:8761

Gateway should appear as registered service.

## 🐛 Debugging

Enable debug logs in application.properties:

```properties
logging.level.org.springframework.cloud.gateway=DEBUG
logging.level.com.codechallenge.gateway=DEBUG
```

## ⚠️ Important Notes

1. **JWT Secret**: MUST match auth-service secret
2. **Eureka**: Must be running before starting gateway
3. **Headers**: Backend services trust headers from gateway (no JWT validation in services)
4. **CORS**: Configure allowed origins for your frontend

## 🔄 Integration with Backend Services

Backend services (user, problem, submission) should:

1. **NOT validate JWT** (gateway already did)
2. **Read headers**: X-User-Id, X-User-Email, X-User-Role
3. **Trust gateway**: Use `permitAll()` in SecurityConfig
4. **Use GatewayHeaderFilter** to extract user info

Example backend filter:

```java
@Component
public class GatewayHeaderFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, ...) {
        String userId = request.getHeader("X-User-Id");
        String email = request.getHeader("X-User-Email");
        String role = request.getHeader("X-User-Role");
        // Use these values...
    }
}
```

## 📝 TODO

- [ ] Add rate limiting
- [ ] Add request/response logging
- [ ] Add circuit breaker (Resilience4j)
- [ ] Add API documentation endpoint
- [ ] Add metrics endpoint
