# 🐇 Cài đặt RabbitMQ bằng Docker

Dự án này giúp triển khai nhanh RabbitMQ với giao diện quản lý thông qua Docker.

---

## 📦 Thành phần

- **RabbitMQ**: Message broker hỗ trợ giao tiếp giữa các service.
- **RabbitMQ Management UI**: Giao diện web để theo dõi và cấu hình RabbitMQ.

---

## 📁 Cấu trúc thư mục

```
rabbitmq-docker/
├── docker-compose.rabbitmq.yml
└── README.md
```

---

## 🚀 Bắt đầu

### 🔧 Yêu cầu

- Cài đặt [Docker](https://www.docker.com/products/docker-desktop/) và [Docker Compose](https://docs.docker.com/compose/install/).

---

## ▶️ Khởi động RabbitMQ

Chạy lệnh sau trong thư mục `rabbitmq-docker` của bạn:

```bash
docker-compose -f docker-compose.rabbitmq.yml up -d
```

### ✅ Truy cập dịch vụ

- **Giao diện quản lý**: [http://localhost:15672](http://localhost:15672)
- **AMQP port cho ứng dụng**: `5672`

**Tài khoản mặc định:**

- **Username**: `guest`
- **Password**: `guest`

---

### ⚙️ Cấu hình Spring Boot (nếu dùng)

Thêm cấu hình sau vào tệp `application.yml` của bạn:

```yaml
spring:
  rabbitmq:
    host: rabbitmq
    port: 5672
    username: guest
    password: guest
```

⚠️ **Lưu ý**: `host: rabbitmq` là tên service được định nghĩa trong tệp `docker-compose.rabbitmq.yml`. Hãy đảm bảo ứng dụng backend của bạn đang chạy trong cùng một network Docker để có thể kết nối.

---

### 🛑 Dừng container

Để dừng và xóa các container đã tạo, chạy lệnh:

```bash
docker-compose -f docker-compose.rabbitmq.yml down
```

---

### 🔐 Ghi chú bảo mật

- **Không sử dụng tài khoản `guest` trong môi trường production.** Hãy tạo một người dùng mới với quyền hạn cụ thể.
- Cân nhắc sử dụng volume để lưu trữ dữ liệu RabbitMQ một cách bền bỉ (persistent data).
- Để tăng cường bảo mật, hãy xem xét việc thiết lập SSL/TLS, sử dụng reverse proxy hoặc giới hạn địa chỉ IP được phép truy cập.

---

## 📄 Giấy phép

Dự án này được cấp phép theo [Giấy phép MIT](https://opensource.org/licenses/MIT).
```