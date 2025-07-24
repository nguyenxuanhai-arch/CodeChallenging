# KẾ HOẠCH CI/CD & MONITORING

## 1. CI/CD
- Sử dụng GitHub Actions (hoặc GitLab CI)
- Pipeline: build, test, tạo Docker image, push registry, deploy
- Tự động kiểm thử khi push code

## 2. Monitoring
- Thu thập log: ELK Stack hoặc Loki + Grafana
- Thu thập metrics: Prometheus + Grafana
- Alert: Prometheus Alertmanager (email, Slack)

## 3. Quy trình
1. Thiết lập pipeline cho từng service
2. Cấu hình monitoring, alert cho production
3. Định kỳ kiểm tra dashboard, log 