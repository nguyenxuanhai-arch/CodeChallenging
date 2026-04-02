# Auth Service API Test Guide

Base URL: `http://localhost:8081`

## 1. Đăng ký tài khoản mới

**Endpoint:** `POST /auth/register`

**Request Body:**
```json
  {
    "email": "user@example.com",
    "username": "johndoe",
    "password": "secret123"
  }
```

**Curl Example:**
```bash
curl -X POST http://localhost:8081/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "email": "user@example.com",
    "username": "johndoe",
    "password": "secret123"
  }'
```

**Response:**
- `200 OK`: "User registered successfully"
- `400 Bad Request`: Email đã tồn tại hoặc dữ liệu không hợp lệ

---

## 2. Đăng nhập (nhận JWT)

**Endpoint:** `POST /auth/login`

**Request Body:**
```json
{
  "email": "user@example.com",
  "password": "secret123"
}
```

**Curl Example:**
```bash
curl -X POST http://localhost:8081/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "user@example.com",
    "password": "secret123"
  }'
```

**Response:**
- `200 OK`:
```json
{
  "token": "<JWT_TOKEN>"
}
```
- `400 Bad Request`: Email hoặc mật khẩu không đúng

---

## 3. Sử dụng JWT cho các API bảo vệ

Thêm header:
```
Authorization: Bearer <JWT_TOKEN>
```

---

## 4. Swagger/OpenAPI

File OpenAPI mô tả chi tiết: [`openapi-auth-service.yaml`](src/main/resources/openapi-auth-service.yaml)

Bạn có thể import file này vào [Swagger Editor](https://editor.swagger.io/) để thử nghiệm trực quan. 