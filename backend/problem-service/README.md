# Problem Service

Port: **8083**

## Tổng quan
Problem Service quản lý bài tập (problems) và test cases cho hệ thống code judging.

## Kiến trúc
- **KHÔNG validate JWT** - Trust API Gateway
- Đọc user info từ headers: `X-User-Id`, `X-User-Email`, `X-User-Role`
- Security: GatewayHeaderFilter + SecurityConfig
- Database: PostgreSQL (problem_db)

## Entities

### Problem
- **id**: Long (PK, auto-increment)
- **title**: String (max 200 chars)
- **description**: Text
- **difficulty**: Enum (EASY, MEDIUM, HARD)
- **timeLimit**: Integer (milliseconds)
- **memoryLimit**: Integer (MB)
- **tags**: String (comma-separated)
- **category**: String
- **createdBy**: Long (User ID)
- **createdAt**: LocalDateTime
- **updatedAt**: LocalDateTime
- **testCases**: OneToMany

### TestCase
- **id**: Long (PK, auto-increment)
- **problemId**: Long (FK to Problem)
- **input**: Text
- **expectedOutput**: Text
- **isPublic**: Boolean (visible to users)
- **orderIndex**: Integer

## API Endpoints

### Problem Management

#### GET /api/problems
List all problems với pagination
- **Access**: Public
- **Query params**:
  - `page` (default: 0)
  - `size` (default: 20)
- **Response**: Page<ProblemResponse>

#### GET /api/problems/search?keyword={keyword}
Search problems by title/description
- **Access**: Public
- **Query params**:
  - `keyword`: String
  - `page`, `size`
- **Response**: Page<ProblemResponse>

#### GET /api/problems/filter
Filter problems by difficulty and category
- **Access**: Public
- **Query params**:
  - `difficulty`: EASY | MEDIUM | HARD (optional)
  - `category`: String (optional)
  - `page`, `size`
- **Response**: Page<ProblemResponse>

#### GET /api/problems/{id}
Get problem by ID
- **Access**: Public
- **Response**: ProblemResponse

#### POST /api/problems
Create new problem
- **Access**: ADMIN only
- **Headers**: X-User-Id (required)
- **Body**: ProblemCreateRequest
```json
{
  "title": "Two Sum",
  "description": "Given an array of integers...",
  "difficulty": "EASY",
  "timeLimit": 1000,
  "memoryLimit": 256,
  "tags": ["array", "hash-table"],
  "category": "Algorithm"
}
```
- **Response**: ProblemResponse (201 Created)

#### PUT /api/problems/{id}
Update problem
- **Access**: ADMIN only
- **Body**: ProblemUpdateRequest
- **Response**: ProblemResponse

#### DELETE /api/problems/{id}
Delete problem
- **Access**: ADMIN only
- **Response**: 204 No Content

### Test Case Management

#### GET /api/problems/{problemId}/test-cases
Get test cases for a problem
- **Access**: Public (only public test cases), ADMIN (all test cases)
- **Response**: List<TestCaseResponse>

#### POST /api/problems/{problemId}/test-cases
Create test case
- **Access**: ADMIN only
- **Body**: TestCaseCreateRequest
```json
{
  "input": "1 2 3\n",
  "expectedOutput": "6\n",
  "isPublic": true,
  "orderIndex": 1
}
```
- **Response**: TestCaseResponse (201 Created)

#### PUT /api/problems/test-cases/{id}
Update test case
- **Access**: ADMIN only
- **Body**: TestCaseUpdateRequest
- **Response**: TestCaseResponse

#### DELETE /api/problems/test-cases/{id}
Delete test case
- **Access**: ADMIN only
- **Response**: 204 No Content

## Security

### Role-Based Access Control
- **Public endpoints**: GET problems, search, filter, view details
- **ADMIN only**: Create, update, delete problems and test cases

### Header Authentication
Service reads these headers từ API Gateway:
- `X-User-Id`: User ID
- `X-User-Email`: Email
- `X-User-Role`: USER | ADMIN

GatewayHeaderFilter automatically sets SecurityContext for `@PreAuthorize`.

## Configuration

### Database (PostgreSQL)
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/problem_db
spring.datasource.username=postgres
spring.datasource.password=postgres
```

### Eureka Client
```properties
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

## Dependencies
- Spring Boot 3.5.3
- Spring Data JPA
- Spring Security
- Spring Validation
- PostgreSQL Driver
- Lombok
- Eureka Client

## Startup Order
1. Discovery Server (8761)
2. Problem Service (8083)
3. API Gateway (8080)

## Test Examples

### Create Problem (ADMIN)
```bash
curl -X POST http://localhost:8080/api/problems \
  -H "Authorization: Bearer <JWT>" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Two Sum",
    "description": "Find two numbers that add up to target",
    "difficulty": "EASY",
    "timeLimit": 1000,
    "memoryLimit": 256,
    "tags": ["array", "hash-table"],
    "category": "Algorithm"
  }'
```

### Get All Problems
```bash
curl http://localhost:8080/api/problems?page=0&size=10
```

### Search Problems
```bash
curl "http://localhost:8080/api/problems/search?keyword=sum&page=0&size=10"
```

### Create Test Case (ADMIN)
```bash
curl -X POST http://localhost:8080/api/problems/1/test-cases \
  -H "Authorization: Bearer <JWT>" \
  -H "Content-Type: application/json" \
  -d '{
    "input": "[2,7,11,15]\n9",
    "expectedOutput": "[0,1]",
    "isPublic": true,
    "orderIndex": 1
  }'
```

## Error Handling
- **404**: ProblemNotFoundException, TestCaseNotFoundException
- **400**: Validation errors
- **500**: Server errors

All errors return standardized JSON:
```json
{
  "status": 404,
  "message": "Problem not found with id: 123",
  "timestamp": "2026-04-06T15:00:00"
}
```

## Notes
- Problem deletion cascades to test cases
- Test cases ordered by `orderIndex`
- Users only see public test cases
- ADMIN sees all test cases
- Tags stored as comma-separated string
- Created by user ID tracked for audit
