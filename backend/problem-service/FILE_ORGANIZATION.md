# 📂 PROBLEM SERVICE - HƯỚNG DẪN TỔ CHỨC FILES

## Tình trạng hiện tại

Tất cả files đã được tạo trong package gốc `problem_service`. Cần di chuyển vào thư mục con đúng cấu trúc.

## Bước 1: Chạy script tạo thư mục

```cmd
cd C:\Users\TP\IdeaProjects\CodeChallenging\backend\problem-service
create-folders.bat
```

Script này sẽ tạo các thư mục:
- `exceptions/`
- `configs/`
- `securities/`
- `services/impl/`

## Bước 2: Di chuyển files

### A. Exceptions (3 files)
```
Di chuyển từ: src\main\java\com\codechallenge\problem\problem_service\
Vào: src\main\java\com\codechallenge\problem\problem_service\exceptions\

Files:
✓ ProblemNotFoundException.java
✓ TestCaseNotFoundException.java
✓ GlobalExceptionHandler.java
```

### B. Securities (1 file)
```
Di chuyển từ: src\main\java\com\codechallenge\problem\problem_service\
Vào: src\main\java\com\codechallenge\problem\problem_service\securities\

Files:
✓ GatewayHeaderFilter.java
```

### C. Configs (2 files)
```
Di chuyển từ: src\main\java\com\codechallenge\problem\problem_service\
Vào: src\main\java\com\codechallenge\problem\problem_service\configs\

Files:
✓ SecurityConfig.java
✓ WebConfig.java
```

### D. Service Implementations (2 files)
```
Di chuyển từ: src\main\java\com\codechallenge\problem\problem_service\
Vào: src\main\java\com\codechallenge\problem\problem_service\services\impl\

Files:
✓ ProblemServiceImpl.java
✓ TestCaseServiceImpl.java
```

## Bước 3: Kiểm tra cấu trúc cuối cùng

```
problem_service/
├── ProblemServiceApplication.java
├── configs/
│   ├── SecurityConfig.java
│   └── WebConfig.java
├── controllers/
│   ├── ProblemController.java
│   └── TestCaseController.java
├── dtos/
│   ├── ProblemCreateRequest.java
│   ├── ProblemResponse.java
│   ├── ProblemUpdateRequest.java
│   ├── TestCaseCreateRequest.java
│   ├── TestCaseResponse.java
│   └── TestCaseUpdateRequest.java
├── entities/
│   ├── Problem.java
│   └── TestCase.java
├── exceptions/
│   ├── GlobalExceptionHandler.java
│   ├── ProblemNotFoundException.java
│   └── TestCaseNotFoundException.java
├── repositories/
│   ├── ProblemRepository.java
│   └── TestCaseRepository.java
├── securities/
│   └── GatewayHeaderFilter.java
└── services/
    ├── ProblemService.java
    ├── TestCaseService.java
    └── impl/
        ├── ProblemServiceImpl.java
        └── TestCaseServiceImpl.java
```

## Bước 4: Build và test

```cmd
# Build project
mvn clean install

# Run service
mvn spring-boot:run
```

## Bước 5: Kiểm tra

1. Service khởi động thành công trên port 8083
2. Register với Eureka (check http://localhost:8761)
3. Database tables tự động tạo (problems, test_cases)
4. Endpoints hoạt động:
   - GET http://localhost:8083/api/problems
   - GET http://localhost:8083/api/problems/{id}

## Lưu ý quan trọng

⚠️ **Sau khi di chuyển files:**
- Không cần sửa package declarations (đã đúng)
- Không cần sửa imports (đã đúng)
- Chỉ cần di chuyển vật lý files vào thư mục

✅ **Checklist:**
- [ ] Chạy create-folders.bat
- [ ] Di chuyển 3 exception files
- [ ] Di chuyển 1 securities file
- [ ] Di chuyển 2 configs files
- [ ] Di chuyển 2 impl files
- [ ] Delete SETUP_INSTRUCTIONS.md (không cần nữa)
- [ ] Build thành công: `mvn clean install`
- [ ] Run thành công: `mvn spring-boot:run`
- [ ] Check Eureka dashboard

## Nếu gặp lỗi compile

**Lỗi import không tìm thấy:**
- Kiểm tra file đã ở đúng thư mục chưa
- Kiểm tra package declaration khớp với đường dẫn folder

**Lỗi Bean not found:**
- Kiểm tra @Component, @Service, @Configuration annotations
- Restart IDE để refresh index

**Database connection error:**
- Tạo database: `CREATE DATABASE problem_db;`
- Kiểm tra PostgreSQL đang chạy
- Username/password trong application.properties đúng
