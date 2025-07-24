# KẾ HOẠCH KIỂM THỬ DỰ ÁN

## 1. Các loại kiểm thử
- Unit test cho từng service
- Integration test giữa các service
- API test (Postman, Swagger)
- UI test (Frontend)
- Load test (chấm bài đồng thời)

## 2. Công cụ
- JUnit, Mockito (Backend)
- Cypress/Jest (Frontend)
- Postman, Swagger
- JMeter/Locust (Load test)

## 3. Quy trình kiểm thử
1. Viết test cho từng chức năng khi phát triển
2. Chạy test tự động qua CI/CD
3. Kiểm thử thủ công các flow chính
4. Load test trước khi release 