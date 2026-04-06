# HƯỚNG DẪN KHỞI ĐỘNG VÀ TEST

## 📦 Yêu cầu trước khi chạy

1. **PostgreSQL** đang chạy
2. **Eureka Discovery Server** đã build
3. **Auth Service** đã build
4. **User Service** đã build
5. **API Gateway** đã build

## 🗄️ Tạo Database

```sql
-- Tạo databases
CREATE DATABASE auth_db;
CREATE DATABASE user_db;

-- Kiểm tra
\l
```

## 🚀 Thứ tự khởi động

### 1. Discovery Server (Port 8761)

```bash
cd backend/discovery-server
mvn spring-boot:run
```

Kiểm tra: http://localhost:8761

### 2. Auth Service (Port 8081)

```bash
cd backend/auth-service
mvn spring-boot:run
```

### 3. User Service (Port 8082)

```bash
cd backend/user-service
mvn spring-boot:run
```

### 4. API Gateway (Port 8080)

```bash
cd backend/api-gateway
mvn spring-boot:run
```

Đợi tất cả services đăng ký với Eureka (check http://localhost:8761)

## 🧪 Test Flow

### Test 1: Register User

```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "email": "test@example.com",
    "password": "Password123!",
    "username": "testuser"
  }'
```

**Expected:** 
- Auth Service tạo user trong auth_db
- Auth Service gọi User Service tạo profile trong user_db
- Return: success message

### Test 2: Login

```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "test@example.com",
    "password": "Password123!"
  }'
```

**Expected:**
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "refreshToken": "...",
  "userId": 1,
  "email": "test@example.com",
  "role": "USER"
}
```

**Lưu accessToken để test tiếp!**

### Test 3: Get User Profile (qua Gateway)

```bash
JWT="<paste-your-token-here>"

curl http://localhost:8080/api/users/1 \
  -H "Authorization: Bearer $JWT"
```

**Expected:**
```json
{
  "id": 1,
  "email": "test@example.com",
  "username": "testuser",
  "role": "USER",
  "urlAvatar": null,
  "phone": null,
  "address": null,
  "totalSubmissions": 0,
  "totalAccepted": 0,
  "createdAt": "2026-04-06T..."
}
```

### Test 4: Update Profile

```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Authorization: Bearer $JWT" \
  -H "Content-Type: application/json" \
  -d '{
    "username": "updated_testuser",
    "phone": "0123456789",
    "address": "Ha Noi, Vietnam"
  }'
```

**Expected:** Updated user object

### Test 5: Test Gateway JWT Validation

```bash
# Without token - Should fail
curl http://localhost:8080/api/users/1

# Expected: 401 Unauthorized

# With invalid token - Should fail
curl http://localhost:8080/api/users/1 \
  -H "Authorization: Bearer invalid_token"

# Expected: 401 Unauthorized
```

### Test 6: Test Gateway Header Forwarding

Check logs in User Service, should see:

```
User authenticated from Gateway: test@example.com, Role: USER
```

## ✅ Verification Checklist

- [ ] Eureka Dashboard shows all 4 services (discovery-server, auth-service, user-service, api-gateway)
- [ ] Register creates user in both auth_db and user_db
- [ ] Login returns valid JWT
- [ ] Get user profile works via Gateway
- [ ] Update profile works
- [ ] Invalid token is rejected by Gateway
- [ ] User Service logs show "User authenticated from Gateway"
- [ ] @PreAuthorize works (try accessing admin endpoint as USER - should fail)

## 🐛 Common Issues

### Issue: Service không đăng ký với Eureka

**Solution:**
- Check Eureka running on 8761
- Check `eureka.client.service-url.defaultZone` trong application.properties
- Wait 30-60 seconds for registration

### Issue: 401 Unauthorized khi có token hợp lệ

**Solution:**
- Check JWT secret giống nhau giữa auth-service và api-gateway
- Check token chưa expired
- Check Authorization header format: "Bearer <token>"

### Issue: User Service không nhận được headers

**Solution:**
- Check API Gateway JwtAuthenticationFilter đang set headers
- Check User Service GatewayHeaderFilter đang đọc headers
- Enable debug logs

### Issue: Database connection failed

**Solution:**
```bash
# Check PostgreSQL running
sudo systemctl status postgresql

# Check databases exist
psql -U postgres -c "\l"

# Check connection
psql -U postgres -d user_db -c "SELECT 1"
```

## 📊 Monitoring

### Eureka Dashboard
http://localhost:8761

### Check Service Health
```bash
# Auth Service
curl http://localhost:8081/actuator/health

# User Service  
curl http://localhost:8082/actuator/health

# API Gateway
curl http://localhost:8080/actuator/health
```

### View Logs
```bash
# Real-time logs
tail -f backend/auth-service/logs/application.log
tail -f backend/user-service/logs/application.log
tail -f backend/api-gateway/logs/application.log
```

## 🎉 Success Criteria

Khi tất cả tests pass, bạn có:

✅ API Gateway validate JWT và route requests
✅ User Service trust Gateway và đọc headers
✅ Auth Service tạo user và sync với User Service
✅ Microservices communication via Eureka
✅ Security architecture đúng chuẩn

## 🚀 Next Steps

1. Deploy Problem Service
2. Deploy Submission Service
3. Deploy Judging Service
4. Integration testing full flow
