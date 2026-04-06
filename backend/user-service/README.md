# USER SERVICE

## 📋 Mô tả

User Service quản lý thông tin hồ sơ người dùng trong hệ thống CodeChallenge. Service này:

- Lưu trữ và quản lý profile người dùng
- Cập nhật thông tin cá nhân (username, avatar, phone, address)
- Theo dõi thống kê (tổng số bài nộp, bài AC)
- **KHÔNG** validate JWT (trust API Gateway)
- Đọc user info từ headers (X-User-Id, X-User-Email, X-User-Role)

## 🚀 Port

- **8082**

## 🔧 Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Validation
- PostgreSQL Driver
- Lombok
- Eureka Client

## 📁 Cấu trúc

```
user-service/
├── configs/
│   ├── SecurityConfig.java       # Trust Gateway, no JWT validation
│   └── WebConfig.java            # CORS config
├── controllers/
│   └── UserController.java       # REST endpoints
├── dtos/
│   ├── UserResponse.java
│   ├── UserUpdateRequest.java
│   └── UserProfileRequest.java
├── entities/
│   └── User.java                 # JPA entity
├── exceptions/
│   ├── UserNotFoundException.java
│   └── GlobalExceptionHandler.java
├── repositories/
│   └── UserRepository.java
├── securities/
│   └── GatewayHeaderFilter.java  # Extract user from headers
├── services/
│   ├── UserService.java
│   └── impl/
│       └── UserServiceImpl.java
└── UserServiceApplication.java
```

## 🗄️ Database

**Database:** `user_db`

**Table:** `users`

| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT | Primary key (from auth-service) |
| email | VARCHAR(100) | Unique, not null |
| username | VARCHAR(50) | Not null |
| url_avatar | VARCHAR(500) | Avatar URL |
| phone | VARCHAR(20) | Phone number |
| address | VARCHAR(255) | Address |
| role | VARCHAR(20) | User role |
| total_submissions | INTEGER | Total submissions count |
| total_accepted | INTEGER | Accepted submissions count |
| created_at | TIMESTAMP | Created timestamp |
| updated_at | TIMESTAMP | Updated timestamp |

## 🔐 Security Architecture

**User Service KHÔNG validate JWT!**

```
API Gateway
    ├─ Validate JWT
    ├─ Extract user info
    ├─ Forward headers:
    │   ├─ X-User-Id
    │   ├─ X-User-Email
    │   └─ X-User-Role
    ↓
User Service
    └─ GatewayHeaderFilter
        ├─ Read headers
        ├─ Set SecurityContext (for @PreAuthorize)
        └─ Trust Gateway
```

## 🛣️ API Endpoints

Base URL: `/api/users`

### Public Endpoints (via Gateway)

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| POST | `/api/users` | Create user profile | Internal (from auth-service) |
| GET | `/api/users/{id}` | Get user by ID | Authenticated |
| GET | `/api/users/email/{email}` | Get user by email | Authenticated |
| PUT | `/api/users/{id}` | Update user profile | Authenticated |
| PUT | `/api/users/{id}/stats` | Update user stats | Internal (from submission-service) |
| GET | `/api/users` | Get all users | ADMIN only |
| DELETE | `/api/users/{id}` | Delete user | ADMIN only |

## 📝 API Examples

### Create User (Internal - called by Auth Service after register)

```bash
POST http://localhost:8082/api/users
Content-Type: application/json

{
  "id": 1,
  "email": "user@example.com",
  "username": "johndoe",
  "role": "USER",
  "urlAvatar": "https://avatar.url",
  "phone": "0123456789",
  "address": "Ha Noi"
}
```

### Get User Profile

```bash
GET http://localhost:8080/api/users/1
Authorization: Bearer <jwt-token>
```

### Update Profile

```bash
PUT http://localhost:8080/api/users/1
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
  "username": "john_updated",
  "urlAvatar": "https://new-avatar.url",
  "phone": "0987654321",
  "address": "Ho Chi Minh"
}
```

### Update Stats (Internal - called by Submission Service)

```bash
PUT http://localhost:8082/api/users/1/stats
Content-Type: application/json

{
  "totalSubmissions": 10,
  "totalAccepted": 7
}
```

## 🔄 Integration Points

### 1. Auth Service → User Service

Sau khi user đăng ký thành công, Auth Service gọi User Service để tạo profile:

```java
// In Auth Service
userServiceClient.createUser(UserProfileRequest.builder()
    .id(user.getId())
    .email(user.getEmail())
    .username(user.getUsername())
    .role(user.getRole())
    .build());
```

### 2. Submission Service → User Service

Sau khi chấm bài, Submission Service cập nhật stats:

```java
// In Submission Service
userServiceClient.updateStats(userId, totalSubmissions, totalAccepted);
```

## ⚙️ Configuration

### application.properties

```properties
server.port=8082
spring.application.name=user-service

# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/user_db
spring.datasource.username=postgres
spring.datasource.password=postgres

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Eureka
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

**Note:** KHÔNG CẦN jwt.secret vì service này không validate JWT!

## 🧪 Testing

### 1. Create User (Internal)

```bash
curl -X POST http://localhost:8082/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "email": "test@test.com",
    "username": "testuser",
    "role": "USER"
  }'
```

### 2. Get User (via Gateway with JWT)

```bash
# First, login to get JWT
JWT=$(curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"test@test.com","password":"password"}' \
  | jq -r '.accessToken')

# Then get user
curl http://localhost:8080/api/users/1 \
  -H "Authorization: Bearer $JWT"
```

### 3. Update Profile

```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Authorization: Bearer $JWT" \
  -H "Content-Type: application/json" \
  -d '{
    "username": "updatedname",
    "phone": "0123456789"
  }'
```

## 📊 Monitoring

- Eureka Dashboard: http://localhost:8761
- Service should appear as: `USER-SERVICE`

## 🐛 Debugging

Enable debug logs:

```properties
logging.level.com.codechallenge.user=DEBUG
logging.level.org.springframework.security=DEBUG
```

## ⚠️ Important Notes

1. **No JWT Validation**: This service trusts API Gateway completely
2. **Headers Required**: X-User-Id, X-User-Email, X-User-Role must be present
3. **ID from Auth**: User ID is NOT auto-generated, it comes from auth-service
4. **Stats Management**: totalSubmissions and totalAccepted updated by Submission Service
5. **Role-based Access**: Use @PreAuthorize("hasRole('ADMIN')") for admin endpoints

## 🚀 Startup Order

1. Discovery Server (8761)
2. Auth Service (8081)
3. User Service (8082) ← You are here
4. API Gateway (8080)

## 📝 TODO

- [ ] Add pagination for getAllUsers
- [ ] Add search/filter endpoints
- [ ] Add user activity logging
- [ ] Add profile picture upload
- [ ] Add email verification
