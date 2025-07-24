# KẾ HOẠCH TỔNG QUAN DỰ ÁN CodeChallenge

## 1. Mục tiêu dự án
- Xây dựng nền tảng luyện tập và chấm bài lập trình tự động, hỗ trợ nhiều ngôn ngữ, trải nghiệm liền mạch.

## 2. Phạm vi MVP
- Đăng ký/đăng nhập, phân quyền User/Admin
- Quản lý bài tập, test case
- Nộp bài, chấm điểm tự động, lưu lịch sử
- Quản lý hồ sơ cá nhân, lưu code nháp

## 3. Kiến trúc tổng thể
- Microservices: Auth, User, Problem, Submission, Judging
- API Gateway, Service Discovery (Eureka), RabbitMQ, PostgreSQL, Docker

## 4. Công nghệ sử dụng
- Backend: Java 17, Spring Boot 3.x, Spring Cloud
- Frontend: React.js (hoặc Angular/Vue)
- Database: PostgreSQL
- Message Queue: RabbitMQ
- CI/CD: GitHub Actions
- Monitoring: Prometheus, Grafana

## 5. Lộ trình phát triển
1. Phân tích yêu cầu, thiết kế hệ thống
2. Xây dựng từng microservice (Auth → User → Problem → Submission → Judging)
3. Xây dựng API Gateway, tích hợp các service
4. Phát triển frontend kết nối backend
5. Thiết lập CI/CD, kiểm thử, triển khai

## 6. Phân chia nhiệm vụ
- Backend: Thiết kế DB, xây dựng API, tích hợp chấm bài
- Frontend: Giao diện người dùng, kết nối API
- DevOps: Docker, CI/CD, Monitoring

## 7. Mốc thời gian dự kiến
- Tuần 1: Phân tích, thiết kế, chuẩn bị môi trường
- Tuần 2-4: Phát triển backend
- Tuần 5-6: Phát triển frontend
- Tuần 7: Tích hợp, kiểm thử, triển khai 