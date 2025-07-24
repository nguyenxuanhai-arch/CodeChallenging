# Backend Microservices Structure

## Các service chính:
- auth-service: Xác thực, đăng ký, đăng nhập, JWT
- user-service: Quản lý hồ sơ, lịch sử nộp bài
- problem-service: Quản lý bài tập, test case
- submission-service: Nhận bài, lưu, gửi queue
- judging-service: Worker chấm bài, Docker
- api-gateway: Gateway cho toàn bộ hệ thống
- discovery-server: Eureka Service Discovery

## Khởi tạo project Spring Boot (Maven)

Ví dụ tạo auth-service:
```bash
cd Backend
mvn archetype:generate -DgroupId=com.codechallenge.auth -DartifactId=auth-service -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

Lặp lại với các service khác, thay đổi groupId/artifactId cho phù hợp.

## Cấu trúc thư mục mỗi service
```
<service-name>/
├── src/main/java/com/codechallenge/<service-name>/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── dto/
│   ├── entity/
│   ├── config/
│   ├── security/
│   ├── exception/
│   └── util/
├── src/main/resources/
│   ├── application.yml
│   └── data.sql
├── pom.xml
└── Dockerfile
```

## Lưu ý
- Mỗi service là một project Spring Boot độc lập.
- Sử dụng PostgreSQL, RabbitMQ, Eureka, Spring Cloud Gateway.
- Đóng gói Docker cho từng service. 