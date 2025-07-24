# KẾ HOẠCH TRIỂN KHAI DỰ ÁN

## 1. Môi trường triển khai
- Dev: Local Docker Compose
- Staging: Cloud VM hoặc server riêng
- Production: AWS EC2, RDS, RabbitMQ, Docker

## 2. Các bước triển khai
1. Build Docker image cho từng service
2. Đẩy image lên Docker Registry
3. Cấu hình môi trường (env, secrets)
4. Triển khai bằng Docker Compose hoặc Kubernetes
5. Thiết lập domain, HTTPS, API Gateway
6. Thiết lập giám sát (Prometheus, Grafana)

## 3. Quy trình rollback, backup
- Backup DB định kỳ
- Rollback bằng image cũ nếu có lỗi 