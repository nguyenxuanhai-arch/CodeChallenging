# KẾ HOẠCH PHÁT TRIỂN BACKEND

## 1. Kiến trúc
- Microservices: Auth, User, Problem, Submission, Judging
- API Gateway, Eureka Discovery, RabbitMQ, PostgreSQL

## 2. Các bước phát triển
1. Thiết kế CSDL (users, problems, submissions, test_cases)
2. Xây dựng Auth Service (Spring Security, JWT)
3. Xây dựng User Service (quản lý hồ sơ, lịch sử nộp bài)
4. Xây dựng Problem Service (CRUD bài tập, test case)
5. Xây dựng Submission Service (nhận bài, lưu, gửi queue)
6. Xây dựng Judging Service (worker chấm bài, Docker)
7. Tích hợp API Gateway, Eureka
8. Viết unit test, kiểm thử tích hợp

## 3. Công nghệ
- Java 17, Spring Boot 3.x, Spring Cloud, JPA/Hibernate, RabbitMQ, Docker

## 4. Quy trình
- Mỗi service có repo riêng hoặc thư mục riêng
- Đảm bảo RESTful API, bảo mật JWT, phân quyền
- Đóng gói Docker, cấu hình CI/CD 