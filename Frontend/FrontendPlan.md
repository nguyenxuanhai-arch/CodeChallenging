# KẾ HOẠCH PHÁT TRIỂN FRONTEND

## 1. Công nghệ
- React.js (hoặc Angular/Vue.js)
- Kết nối RESTful API backend
- UI/UX hiện đại, responsive

## 2. Các bước phát triển
1. Thiết kế wireframe, xác định flow người dùng
2. Xây dựng layout, navigation, routing
3. Trang đăng ký/đăng nhập, xác thực JWT
4. Trang danh sách bài tập, lọc/tìm kiếm
5. Trang chi tiết bài tập, hiển thị test case mẫu
6. Trình soạn thảo code, chọn ngôn ngữ, nộp bài
7. Trang kết quả nộp bài, lịch sử bài nộp
8. Trang quản lý hồ sơ cá nhân
9. Trang quản trị (Admin)

## 3. Quy trình
- Sử dụng component hóa, quản lý state (Redux/Context)
- Kiểm thử giao diện, xác thực API
- Responsive cho desktop/mobile 

---

## **Cách khắc phục:**

1. **Đóng tất cả cửa sổ terminal/cmd/PowerShell đang mở.**
2. **Mở lại một cửa sổ terminal/cmd/PowerShell mới.**
3. **Kiểm tra lại bằng lệnh:**
   ```sh
   node -v
   npm -v
   ```
   Nếu ra version là OK. Nếu vẫn báo lỗi, hãy khởi động lại máy tính.

4. **Nếu vẫn lỗi, kiểm tra lại biến môi trường PATH:**
   - Vào **Control Panel > System > Advanced system settings > Environment Variables**.
   - Trong phần "System variables", tìm biến `Path` và kiểm tra đã có đường dẫn đến thư mục cài Node.js (ví dụ: `C:\Program Files\nodejs\`).
   - Nếu chưa có, thêm đường dẫn này vào, nhấn OK, rồi khởi động lại máy.

---

Sau khi chắc chắn `npm` đã nhận diện được, bạn hãy thử lại lệnh:
```sh
npm -v
```
Nếu thành công, tôi sẽ tiếp tục khởi tạo project React cho bạn! 