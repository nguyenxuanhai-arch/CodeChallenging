# User Service API Test Documentation

## 1. Lấy thông tin user

**GET /users/{id}**

- **Request:**
  - Method: GET
  - URL: /users/1

- **Response 200:**
```json
{
  "id": 1,
  "username": "alice",
  "email": "alice@example.com",
  "role": "USER",
  "avatar": "https://example.com/avatar1.png",
  "createdAt": "2024-06-01T10:00:00"
}
```

- **Response 404:**
```json
"User not found"
```

---

## 2. Cập nhật thông tin user

**PUT /users/{id}**

- **Request:**
  - Method: PUT
  - URL: /users/1
  - Body:
```json
{
  "username": "alice_new",
  "avatar": "https://example.com/avatar2.png"
}
```

- **Response 200:**
```json
{
  "id": 1,
  "username": "alice_new",
  "email": "alice@example.com",
  "role": "USER",
  "avatar": "https://example.com/avatar2.png",
  "createdAt": "2024-06-01T10:00:00"
}
```

- **Response 404:**
```json
"User not found"
```

---

## 3. Lấy lịch sử nộp bài của user

**GET /users/{id}/submissions**

- **Request:**
  - Method: GET
  - URL: /users/1/submissions

- **Response 200:**
```json
[
  {
    "id": 101,
    "problemId": 5,
    "language": "JAVA",
    "status": "Accepted",
    "score": 100,
    "submittedAt": "2024-06-01T11:00:00"
  },
  {
    "id": 102,
    "problemId": 6,
    "language": "PYTHON",
    "status": "Wrong Answer",
    "score": 0,
    "submittedAt": "2024-06-01T12:00:00"
  }
]
```

- **Response 200 (empty):**
```json
[]
```

---

## 4. Trường hợp lỗi chung

- **User không tồn tại:**
  - Status: 404
  - Body: "User not found"

---

## 5. Test case đề xuất

| API | Test case | Kết quả mong đợi |
|-----|-----------|------------------|
| GET /users/1 | User tồn tại | 200, trả về thông tin user |
| GET /users/999 | User không tồn tại | 404, "User not found" |
| PUT /users/1 | Update username/avatar | 200, trả về user đã cập nhật |
| PUT /users/999 | Update user không tồn tại | 404, "User not found" |
| GET /users/1/submissions | Có lịch sử nộp bài | 200, trả về danh sách submissions |
| GET /users/1/submissions | Không có lịch sử nộp bài | 200, trả về [] | 