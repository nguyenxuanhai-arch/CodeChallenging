# 🐳 Cài đặt PostgreSQL + pgAdmin bằng Docker

Dự án này cung cấp cách triển khai nhanh cơ sở dữ liệu **PostgreSQL** kèm theo công cụ quản lý trực quan **pgAdmin** thông qua Docker.

## 📦 Thành phần

- **PostgreSQL**: Hệ quản trị cơ sở dữ liệu quan hệ mã nguồn mở.
- **pgAdmin**: Giao diện web giúp quản lý PostgreSQL dễ dàng.

## 📁 Cấu trúc thư mục

```
postgres-gui/
├── docker-compose.yml
└── README.md
```

## 🚀 Bắt đầu

### 🔧 Yêu cầu

- Cài đặt Docker và Docker Compose

### ⚙️ Tuỳ chỉnh (nếu cần)

Bạn có thể sửa các biến môi trường trong `docker-compose.yml`:

```yaml
POSTGRES_USER: postgres
POSTGRES_PASSWORD: postgres
POSTGRES_DB: mydb

PGADMIN_DEFAULT_EMAIL: admin@localhost.com
PGADMIN_DEFAULT_PASSWORD: admin123
```

### ▶️ Chạy project

```bash
docker-compose up -d
```

### ✅ Truy cập dịch vụ

- **PostgreSQL**
  - Host: `localhost`
  - Cổng: `5432`
  - User: `postgres`
  - Password: `postgres`
  - Database: `mydb`

- **pgAdmin**
  - URL: [http://localhost:5050](http://localhost:5050)
  - Email đăng nhập: `admin@localhost.com`
  - Mật khẩu: `admin123`

> Khi vào pgAdmin lần đầu:
> - Tạo server mới
> - Host name: `postgres` (chính là tên service trong docker-compose)
> - Port: `5432`
> - Username: `postgres`
> - Password: `postgres`

## 💾 Lưu trữ dữ liệu

- Dữ liệu của PostgreSQL được lưu bằng volume Docker tên `postgres_data`.

## 🛑 Dừng container

```bash
docker-compose down
```

### 🧼 Xoá container và volume (nếu cần xoá sạch)

```bash
docker-compose down -v
```

## 🔐 Ghi chú bảo mật

- **Không nên mở cổng 5432 và 5050 ra ngoài internet** trong môi trường production.
- Luôn đặt mật khẩu mạnh và sử dụng reverse proxy + SSL nếu public hệ thống.

## 📄 Giấy phép

MIT License
