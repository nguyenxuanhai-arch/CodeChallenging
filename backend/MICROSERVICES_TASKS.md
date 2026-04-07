# BACKEND MICROSERVICES - TASK TRACKER

## 🎯 KIẾN TRÚC TỔNG QUAN

```
Client 
  ↓
API Gateway (Port 8080)
  ├─ Validate JWT
  ├─ Forward Headers: X-User-Id, X-User-Email, X-User-Role
  ↓
Backend Services (Trust Gateway - Đọc Headers)
  ├─ Auth Service (8081) - Tạo & Validate JWT
  ├─ User Service (8082) - Quản lý hồ sơ
  ├─ Problem Service (8083) - Quản lý bài tập
  ├─ Submission Service (8084) - Nhận & lưu bài nộp
  └─ Judging Service (8085) - Chấm bài tự động
```

---

## 📋 DANH SÁCH TASK

### 1️⃣ API GATEWAY (Port 8080) - CORE SERVICE

#### Setup & Dependencies
- [ ] Thêm JWT dependencies vào pom.xml
  - [ ] io.jsonwebtoken:jjwt-api:0.11.5
  - [ ] io.jsonwebtoken:jjwt-impl:0.11.5
  - [ ] io.jsonwebtoken:jjwt-jackson:0.11.5

#### Configuration Files
- [ ] Tạo application.yml với:
  - [ ] Server port: 8080
  - [ ] Eureka client config
  - [ ] JWT secret (giống auth-service)
  - [ ] Routes configuration

#### Security Layer
- [ ] Tạo JwtUtil.java
  - [ ] extractAllClaims()
  - [ ] extractEmail()
  - [ ] extractUserId()
  - [ ] extractRole()
  - [ ] validateToken()

- [ ] Tạo JwtAuthenticationFilter.java
  - [ ] Validate JWT từ Authorization header
  - [ ] Extract user info từ JWT
  - [ ] Forward headers: X-User-Id, X-User-Email, X-User-Role

- [ ] Tạo SecurityConfig.java
  - [ ] Disable CSRF
  - [ ] Public endpoints: /auth/**
  - [ ] Add JwtAuthenticationFilter

#### Routing Configuration
- [ ] Tạo GatewayConfig.java hoặc routes trong application.yml
  - [ ] Route /auth/** → auth-service
  - [ ] Route /api/users/** → user-service
  - [ ] Route /api/problems/** → problem-service
  - [ ] Route /api/submissions/** → submission-service
  - [ ] Route /api/judging/** → judging-service

#### Testing
- [ ] Test JWT validation
- [ ] Test routes
- [ ] Test header forwarding

---

### 2️⃣ AUTH SERVICE (Port 8081) - ✅ HOÀN THÀNH

- [x] Entity: User, Role, Permission
- [x] JWT generation & validation
- [x] Login, Register, Refresh endpoints
- [x] SecurityConfig với public endpoints
- [x] BCrypt password encoding
- [x] Refresh token mechanism
- [x] Blacklist token

**Lưu ý:** Auth Service GIỮ NGUYÊN JWT validation vì đây là nơi tạo token!

---

### 3️⃣ USER SERVICE (Port 8082) - ✅ HOÀN THÀNH

#### Architecture Fix
- [x] Xóa JWT validation (trust Gateway)
- [x] Tạo GatewayHeaderFilter để đọc headers

#### Security (Trust Gateway)
- [x] GatewayHeaderFilter.java - Đọc X-User-* headers
- [x] SecurityConfig.java - permitAll(), trust Gateway
- [x] WebConfig.java - CORS config

#### Configuration
- [x] application.properties
  - [x] Server port: 8082
  - [x] Database: user_db
  - [x] Eureka config
  - [x] NO JWT config (không cần)

#### Entities & DTOs
- [x] User entity (id, email, username, urlAvatar, phone, address, role, totalSubmissions, totalAccepted)
- [x] UserResponse DTO
- [x] UserUpdateRequest DTO
- [x] UserProfileRequest DTO (nhận từ Auth Service)

#### Business Logic
- [x] UserRepository
- [x] UserService interface
- [x] UserServiceImpl
  - [x] createUser() - Được gọi từ Auth Service sau khi register
  - [x] getById()
  - [x] getByEmail()
  - [x] getAll()
  - [x] update()
  - [x] delete()
  - [x] updateStats() - Được gọi từ Submission Service

#### Controllers
- [x] UserController
  - [x] POST /api/users - Create user
  - [x] GET /api/users/{id} - Get user by ID
  - [x] GET /api/users/email/{email} - Get user by email
  - [x] GET /api/users - Get all (ADMIN only)
  - [x] PUT /api/users/{id} - Update profile
  - [x] DELETE /api/users/{id} - Delete user (ADMIN only)
  - [x] PUT /api/users/{id}/stats - Update stats

#### Exception Handling
- [x] UserNotFoundException
- [x] GlobalExceptionHandler

#### Documentation
- [x] README.md

#### Testing
- [ ] Test Gateway header reading
- [ ] Test @PreAuthorize với role từ header
- [ ] Test CRUD operations
- [ ] Test integration với Auth Service
- [ ] Test stats update từ Submission Service

---

### 4️⃣ PROBLEM SERVICE (Port 8083) - ✅ HOÀN THÀNH

#### Setup Base
- [x] Tạo cấu trúc thư mục chuẩn
  - [x] configs/
  - [x] controllers/
  - [x] dtos/
  - [x] entities/
  - [x] exceptions/
  - [x] repositories/
  - [x] securities/
  - [x] services/impl/

#### Dependencies
- [x] Spring Boot Starter Web
- [x] Spring Boot Starter Data JPA
- [x] Spring Boot Starter Security
- [x] Spring Boot Starter Validation
- [x] PostgreSQL Driver
- [x] Lombok
- [x] Eureka Client

#### Configuration
- [x] application.properties
  - [x] Server port: 8083
  - [x] Database: problem_db
  - [x] Eureka config

#### Security (Trust Gateway)
- [x] GatewayHeaderFilter.java
- [x] SecurityConfig.java
- [x] WebConfig.java

#### Entities
- [x] Problem.java
  - [x] id, title, description, difficulty
  - [x] timeLimit, memoryLimit
  - [x] tags, category
  - [x] createdBy, createdAt, updatedAt
  
- [x] TestCase.java
  - [x] id, problemId
  - [x] input, expectedOutput
  - [x] isPublic (sample test case)
  - [x] orderIndex

#### DTOs
- [x] ProblemResponse
- [x] ProblemCreateRequest
- [x] ProblemUpdateRequest
- [x] TestCaseResponse
- [x] TestCaseCreateRequest
- [x] TestCaseUpdateRequest

#### Repositories
- [x] ProblemRepository (with search, filter)
- [x] TestCaseRepository

#### Services
- [x] ProblemService interface
- [x] ProblemServiceImpl
  - [x] getAllProblems() - Pagination
  - [x] searchProblems() - Search by keyword
  - [x] filterProblems() - Filter by difficulty, category
  - [x] getProblemById()
  - [x] createProblem() - ADMIN only
  - [x] updateProblem() - ADMIN only
  - [x] deleteProblem() - ADMIN only
  
- [x] TestCaseService interface
- [x] TestCaseServiceImpl
  - [x] getTestCasesByProblemId() - Public/All
  - [x] createTestCase() - ADMIN only
  - [x] updateTestCase() - ADMIN only
  - [x] deleteTestCase() - ADMIN only

#### Controllers
- [x] ProblemController
  - [x] GET /api/problems - List với pagination
  - [x] GET /api/problems/search - Search với keyword
  - [x] GET /api/problems/filter - Filter by difficulty, category
  - [x] GET /api/problems/{id} - Detail
  - [x] POST /api/problems - Create (ADMIN)
  - [x] PUT /api/problems/{id} - Update (ADMIN)
  - [x] DELETE /api/problems/{id} - Delete (ADMIN)
  
- [x] TestCaseController
  - [x] GET /api/problems/{problemId}/test-cases - Get test cases
  - [x] POST /api/problems/{problemId}/test-cases - Create (ADMIN)
  - [x] PUT /api/problems/test-cases/{id} - Update (ADMIN)
  - [x] DELETE /api/problems/test-cases/{id} - Delete (ADMIN)

#### Exceptions
- [x] ProblemNotFoundException
- [x] TestCaseNotFoundException
- [x] GlobalExceptionHandler

#### Documentation
- [x] README.md

#### Testing
- [ ] Unit tests
- [ ] Integration tests

**Lưu ý:** Files đã được tạo trong problem_service package. Cần chạy `create-folders.bat` và di chuyển files vào thư mục con tương ứng (exceptions/, configs/, securities/, services/impl/).

---

### 5️⃣ SUBMISSION SERVICE (Port 8084) - CHƯA TRIỂN KHAI

#### Setup Base
- [ ] Tạo cấu trúc thư mục chuẩn

#### Dependencies
- [ ] Spring Boot Starter Web
- [ ] Spring Boot Starter Data JPA
- [ ] Spring Boot Starter Security
- [ ] Spring Boot Starter AMQP (RabbitMQ)
- [ ] PostgreSQL Driver
- [ ] Lombok
- [ ] Eureka Client
- [ ] OpenFeign (gọi Problem Service)

#### Configuration
- [ ] application.properties
  - [ ] Server port: 8084
  - [ ] Database: submission_db
  - [ ] RabbitMQ config
  - [ ] Eureka config

#### Security (Trust Gateway)
- [ ] GatewayHeaderFilter.java
- [ ] SecurityConfig.java
- [ ] WebConfig.java

#### Entities
- [ ] Submission.java
  - [ ] id, userId, problemId
  - [ ] language, code
  - [ ] status (PENDING, JUDGING, ACCEPTED, WRONG_ANSWER, TLE, MLE, COMPILE_ERROR, RUNTIME_ERROR)
  - [ ] score, executionTime, memoryUsed
  - [ ] errorMessage
  - [ ] submittedAt

#### DTOs
- [ ] SubmissionRequest
- [ ] SubmissionResponse
- [ ] SubmissionResultUpdate (từ Judging Service)

#### RabbitMQ Configuration
- [ ] RabbitMQConfig.java
  - [ ] Declare queue: judging-queue
  - [ ] Declare exchange
  - [ ] Binding

#### Repositories
- [ ] SubmissionRepository

#### Services
- [ ] SubmissionService interface
- [ ] SubmissionServiceImpl
  - [ ] submitCode()
    - [ ] Lưu submission với status PENDING
    - [ ] Gửi message tới RabbitMQ
  - [ ] getSubmissionById()
  - [ ] getUserSubmissions()
  - [ ] updateSubmissionResult() - Nhận từ Judging Service
  - [ ] Gọi User Service để updateStats()

#### Feign Clients
- [ ] ProblemServiceClient
  - [ ] Get problem details
  - [ ] Get test cases
  
- [ ] UserServiceClient
  - [ ] Update user stats

#### Controllers
- [ ] SubmissionController
  - [ ] POST /api/submissions - Submit code
  - [ ] GET /api/submissions/{id} - Get submission detail
  - [ ] GET /api/users/{userId}/submissions - Get user submissions
  - [ ] PUT /api/submissions/{id}/result - Update result (Internal)

#### Message Producer
- [ ] SubmissionMessageProducer.java
  - [ ] sendToJudgingQueue()

#### Exceptions
- [ ] SubmissionNotFoundException
- [ ] InvalidSubmissionException
- [ ] GlobalExceptionHandler

#### Testing
- [ ] Test RabbitMQ integration
- [ ] Test Feign clients

---

### 6️⃣ JUDGING SERVICE (Port 8085) - CHƯA TRIỂN KHAI

#### Setup Base
- [ ] Tạo cấu trúc thư mục chuẩn

#### Dependencies
- [ ] Spring Boot Starter Web
- [ ] Spring Boot Starter Data JPA
- [ ] Spring Boot Starter AMQP (RabbitMQ)
- [ ] docker-java (Docker integration)
- [ ] PostgreSQL Driver (read-only access)
- [ ] Lombok
- [ ] Eureka Client

#### Configuration
- [ ] application.properties
  - [ ] Server port: 8085
  - [ ] Database: submission_db (read), problem_db (read)
  - [ ] RabbitMQ config
  - [ ] Docker config
  - [ ] Eureka config

#### RabbitMQ Configuration
- [ ] RabbitMQConfig.java
  - [ ] Listen to: judging-queue

#### Message Listener
- [ ] JudgingMessageListener.java
  - [ ] @RabbitListener
  - [ ] Receive submission message
  - [ ] Trigger judging process

#### Docker Service
- [ ] DockerService.java
  - [ ] createContainer()
  - [ ] startContainer()
  - [ ] copyFileToContainer()
  - [ ] executeCommandInContainer()
  - [ ] getContainerLogs()
  - [ ] stopContainer()
  - [ ] removeContainer()
  - [ ] Set resource limits (CPU, RAM, time)

#### Judging Logic
- [ ] JudgingService.java
  - [ ] judgeSubmission()
    - [ ] Get problem & test cases
    - [ ] Create Docker container
    - [ ] Copy code vào container
    - [ ] Compile (nếu cần)
    - [ ] Run với từng test case
    - [ ] Compare output
    - [ ] Aggregate results
    - [ ] Cleanup container
  
- [ ] LanguageCompiler.java
  - [ ] Compile C++
  - [ ] Compile Java
  - [ ] Run Python (no compile)

- [ ] OutputComparator.java
  - [ ] compareOutputs() - Trim whitespace, compare

#### Result Update
- [ ] ResultPublisher.java
  - [ ] Gọi API Submission Service để update result

#### Repositories (Read-only)
- [ ] ProblemRepository
- [ ] TestCaseRepository
- [ ] SubmissionRepository

#### Exceptions
- [ ] JudgingException
- [ ] DockerException
- [ ] CompilationException
- [ ] GlobalExceptionHandler

#### Testing
- [ ] Test Docker integration
- [ ] Test với sample code
- [ ] Test resource limits

---

### 7️⃣ DISCOVERY SERVER (Port 8761) - KIỂM TRA

#### Verification
- [ ] Kiểm tra @EnableEurekaServer
- [ ] Kiểm tra application.properties
- [ ] Test khởi động
- [ ] Test dashboard: http://localhost:8761

---

### 8️⃣ DATABASE SETUP

#### PostgreSQL Databases
- [x] auth_db (Auth Service)
- [ ] user_db (User Service)
- [ ] problem_db (Problem Service)
- [ ] submission_db (Submission Service, Judging Service)

#### Schema
- [ ] Chạy schema.sql
- [ ] Verify tables
- [ ] Insert initial data (roles, permissions, sample problems)

---

### 9️⃣ RABBITMQ SETUP

- [ ] Khởi động RabbitMQ container
- [ ] Verify management UI: http://localhost:15672
- [ ] Tạo queue: judging-queue
- [ ] Test connection từ services

---

### 🔟 INTEGRATION TESTING

#### Service Communication
- [ ] Auth Service → User Service (create user sau register)
- [ ] API Gateway → All Services (routing)
- [ ] Submission Service → Problem Service (get test cases)
- [ ] Submission Service → RabbitMQ → Judging Service
- [ ] Judging Service → Submission Service (update result)
- [ ] Submission Service → User Service (update stats)

#### End-to-End Flow
- [ ] User Register → Login → Get JWT
- [ ] Get Problems → Submit Code
- [ ] Code được chấm → Nhận kết quả
- [ ] Update user stats

---

## 📝 NOTES

### Service Dependencies Order
1. Discovery Server (8761) - Khởi động đầu tiên
2. Auth Service (8081) - Tạo user
3. User Service (8082) - Lưu profile
4. Problem Service (8083) - Độc lập
5. RabbitMQ
6. Submission Service (8084) - Cần Problem Service
7. Judging Service (8085) - Cần RabbitMQ, Problem Service
8. API Gateway (8080) - Khởi động cuối cùng

### Current Priority
1. ✅ **API Gateway** - HOÀN THÀNH
2. ✅ **User Service** - HOÀN THÀNH
3. ✅ **Problem Service** - HOÀN THÀNH (cần organize files)
4. **Submission Service** - Main feature
5. **Judging Service** - Main feature

---

## ✅ COMPLETION CHECKLIST

- [ ] Tất cả services khởi động thành công
- [ ] Eureka Dashboard hiển thị tất cả services
- [ ] API Gateway routes hoạt động
- [ ] JWT validation đúng
- [ ] End-to-end submission flow hoạt động
- [ ] Database schema hoàn chỉnh
- [ ] RabbitMQ integration hoạt động
- [ ] Docker judging hoạt động
- [ ] Error handling đầy đủ
- [ ] Logging đầy đủ

---

**Ngày bắt đầu:** 06/04/2026
**Services hoàn thành:** API Gateway, User Service, Problem Service
**Tiến độ:** 3/7 services (43%)
