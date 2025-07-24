# **Tài liệu MVP & Phân tích Thiết kế Hệ thống**

**Dự án:** Nền tảng Lập trình Online CodeChallenge **Phiên bản:** 1.0 (Backend Spring Boot) **Ngày:** 21 tháng 7 năm 2025

## **PHẦN 1: MVP (Sản phẩm Khả thi Tối thiểu)**

### **1\. Giới thiệu**

Tài liệu này mô tả các tính năng cốt lõi và phạm vi của phiên bản Sản phẩm Khả thi Tối thiểu (MVP) cho nền tảng CodeChallenge. Đây là một hệ thống chấm bài lập trình tự động, cho phép người dùng thực hành kỹ năng code, giải các bài toán, và nhận phản hồi tức thì về lời giải của mình. Phiên bản MVP tập trung vào việc cung cấp một trải nghiệm giải bài tập liền mạch và hiệu quả nhất.

### **2\. Tầm nhìn sản phẩm**

Tạo ra một môi trường học tập và rèn luyện kỹ năng lập trình **hiệu quả, thú vị, và miễn phí** cho mọi đối tượng, từ người mới bắt đầu đến lập trình viên chuyên nghiệp. Chúng tôi hướng tới việc xây dựng một cộng đồng nơi người dùng có thể thử thách bản thân, nâng cao kiến thức và chuẩn bị tốt hơn cho sự nghiệp trong lĩnh vực công nghệ thông tin.

### **3\. Đối tượng người dùng**

* **Sinh viên CNTT / Khoa học Máy tính:** Cần nền tảng để thực hành bài tập, ôn luyện kiến thức và chuẩn bị cho các kỳ thi.  
* **Lập trình viên muốn ôn tập hoặc luyện phỏng vấn:** Tìm kiếm một công cụ để củng cố kiến thức cơ bản, luyện tập giải thuật và cấu trúc dữ liệu, hoặc chuẩn bị cho các buổi phỏng vấn kỹ thuật.  
* **Người mới học lập trình:** Cần một môi trường thực hành đơn giản, dễ tiếp cận để làm quen với cú pháp và logic lập trình.  
* **Giảng viên / Quản trị viên:** Cần công cụ để quản lý nội dung bài tập và theo dõi hoạt động của người dùng (trong tương lai).

### **4\. Các tính năng chính (MVP)**

| Tính năng | Mô tả chi tiết | Mục tiêu |
| :---- | :---- | :---- |
| **Xác thực người dùng** | Đăng ký tài khoản mới bằng email và mật khẩu. Đăng nhập/đăng xuất an toàn. | Xác định danh tính người dùng để lưu trữ tiến độ, lịch sử nộp bài và cá nhân hóa trải nghiệm. |
| **Xem danh sách bài tập** | Hiển thị danh sách các bài tập hiện có với các thông tin cơ bản như tên bài, độ khó (dễ, trung bình, khó), và trạng thái đã giải/chưa giải (sau khi đăng nhập). Cung cấp bộ lọc và chức năng tìm kiếm cơ bản (theo độ khó, tên bài). | Giúp người dùng dễ dàng tìm kiếm và lựa chọn bài tập phù hợp với trình độ và sở thích của mình. |
| **Xem chi tiết bài tập** | Trang chi tiết hiển thị đầy đủ mô tả bài toán, định dạng đầu vào (Input), định dạng đầu ra (Output), giới hạn thời gian (Time Limit), giới hạn bộ nhớ (Memory Limit), và các ví dụ kiểm thử công khai (Sample Test Cases). | Đảm bảo người dùng hiểu rõ yêu cầu của bài toán trước khi bắt đầu viết code. |
| **Nộp bài làm** | Cung cấp trình soạn thảo code tích hợp trên giao diện web (hoặc vùng text input đơn giản). Cho phép người dùng chọn ngôn ngữ lập trình (ít nhất 3 ngôn ngữ phổ biến: C++, Java, Python). Người dùng nhập code và nhấn nút "Nộp bài" (Submit). | Cung cấp giao diện để người dùng gửi lời giải của mình tới hệ thống chấm tự động. |
| **Chấm điểm tự động** | Hệ thống nhận lời giải, biên dịch (nếu cần), chạy code với các bộ test case ẩn (Private Test Cases). So sánh đầu ra của code người dùng với đầu ra mong đợi để xác định tính đúng đắn. | Đánh giá khách quan và tự động lời giải của người dùng, cung cấp phản hồi nhanh chóng. |
| **Xem kết quả nộp bài** | Hiển thị trạng thái kết quả của lời giải (ví dụ: Accepted \- Đúng hoàn toàn, Wrong Answer \- Sai kết quả, Compile Error \- Lỗi biên dịch, Time Limit Exceeded \- Quá thời gian, Memory Limit Exceeded \- Quá bộ nhớ). Hiển thị chi tiết lỗi nếu có (ví dụ: thông báo lỗi biên dịch). | Người dùng nắm bắt được hiệu suất của code ngay lập tức và biết cách để cải thiện. |
| **Quản lý hồ sơ cá nhân** | Cho phép người dùng cập nhật các thông tin cơ bản như tên hiển thị (username), ảnh đại diện (avatar). | Cá nhân hóa trải nghiệm người dùng và giúp người dùng thể hiện bản thân trong cộng đồng (tương lai). |
| **Lưu code nháp** | Tự động hoặc cho phép người dùng lưu lại code đang viết mà chưa nộp, hoặc lưu các phiên bản code đã chỉnh sửa. | Tránh mất mát công sức của người dùng, giúp họ tiếp tục làm việc thuận tiện. |
| **Lịch sử bài nộp** | Xem danh sách tất cả các lời giải đã nộp cho mỗi bài tập, bao gồm thời gian nộp, ngôn ngữ, và kết quả. Có thể xem lại source code của các lần nộp trước đó. | Người dùng theo dõi tiến độ học tập và ôn lại các lời giải đã từng thực hiện. |
| **Phân quyền cơ bản** | Hệ thống có ít nhất 2 vai trò: User (người dùng thông thường) và Admin. Admin có quyền tạo, chỉnh sửa, và xóa bài tập. | Đảm bảo khả năng quản trị nội dung bài tập cho hệ thống. |

### **5\. Luồng người dùng (User Flow)**

* **Người mới truy cập hệ thống:**  
  1. Truy cập Trang chủ.  
  2. Chọn "Đăng ký" hoặc "Đăng nhập".  
  3. Hoàn tất quá trình đăng ký (nếu là người mới) hoặc đăng nhập bằng tài khoản đã có.  
  4. Chuyển hướng đến Trang danh sách bài tập.  
* **Người dùng giải bài tập:**  
  1. Đăng nhập vào hệ thống.  
  2. Chọn một bài tập từ danh sách.  
  3. Đọc hiểu chi tiết bài tập.  
  4. Viết code giải bài trong trình soạn thảo.  
  5. Chọn ngôn ngữ lập trình phù hợp.  
  6. Nhấn "Nộp bài".  
  7. Xem kết quả chấm bài tự động.  
  8. Nếu kết quả chưa đạt, sửa code và nộp lại; hoặc chuyển sang bài tập khác.

### **6\. Giả định và Rủi ro**

* **Giả định:**  
  * Người dùng có kiến thức cơ bản về ít nhất một ngôn ngữ lập trình được hỗ trợ.  
  * Môi trường triển khai (server, network) ổn định.  
  * Khả năng tiếp cận ban đầu các bài tập lập trình chất lượng cao.  
  * Công nghệ Docker được sử dụng để xây dựng Sandbox là đủ an toàn và cô lập.  
* **Rủi ro:**  
  * **Kỹ thuật:**  
    * **Sandbox bảo mật và hiệu năng:** Xây dựng môi trường chấm code an toàn (sandbox) để ngăn chặn mã độc và đảm bảo hiệu suất chấm bài cho nhiều người dùng đồng thời là rất phức tạp.  
    * **Quản lý tài nguyên:** Đảm bảo các worker chấm bài không bị quá tải, quản lý tài nguyên CPU/RAM hiệu quả.  
    * **Khả năng mở rộng hệ thống chấm:** Khi số lượng người dùng và bài nộp tăng lên, hệ thống chấm cần có khả năng mở rộng linh hoạt.  
  * **Nội dung:**  
    * Thiếu nguồn bài tập chất lượng và đa dạng trong giai đoạn đầu, ảnh hưởng đến trải nghiệm và sự thu hút người dùng.  
    * Việc tạo và duy trì các test case chất lượng cao cho mỗi bài tập đòi hỏi nhiều công sức.  
  * **Vận hành:**  
    * Chi phí vận hành các máy chủ cần thiết cho việc chấm code có thể cao.  
    * Đảm bảo uptime và khả năng phục hồi của hệ thống.

## **PHẦN 2: PHÂN TÍCH & THIẾT KẾ HỆ THỐNG**

### **CHƯƠNG 1: PHÂN TÍCH HỆ THỐNG**

#### **1.1 Mục tiêu**

Xác định rõ ràng các yêu cầu chức năng (Functional Requirements) và phi chức năng (Non-Functional Requirements) để làm cơ sở cho quá trình thiết kế và phát triển hệ thống chấm bài tự động **CodeChallenge**, đảm bảo đáp ứng được tầm nhìn sản phẩm và nhu cầu của người dùng.

#### **1.2 Yêu cầu chức năng (Functional Requirements \- FR)**

* **FR1: Quản lý người dùng**  
  * FR1.1: Người dùng có thể đăng ký tài khoản mới.  
  * FR1.2: Người dùng có thể đăng nhập và đăng xuất.  
  * FR1.3: Người dùng có thể cập nhật thông tin cá nhân (tên hiển thị, avatar).  
  * FR1.4: Hệ thống phân quyền người dùng (User, Admin).  
* **FR2: Quản lý bài tập**  
  * FR2.1: Người dùng có thể xem danh sách bài tập.  
  * FR2.2: Người dùng có thể xem chi tiết bài tập (mô tả, input/output, ví dụ).  
  * FR2.3: Admin có thể thêm bài tập mới (tiêu đề, mô tả, độ khó, time/memory limit).  
  * FR2.4: Admin có thể chỉnh sửa thông tin bài tập.  
  * FR2.5: Admin có thể thêm/chỉnh sửa test cases cho bài tập.  
* **FR3: Nộp bài và chấm điểm**  
  * FR3.1: Người dùng có thể nộp mã nguồn cho bài tập.  
  * FR3.2: Hệ thống hỗ trợ biên dịch và chạy mã nguồn cho các ngôn ngữ đã định (C++, Java, Python).  
  * FR3.3: Hệ thống chấm điểm tự động dựa trên các test case.  
  * FR3.4: Hệ thống trả về kết quả chấm bài (Accepted, Wrong Answer, Compile Error, TLE, MLE).  
  * FR3.5: Người dùng có thể xem lịch sử các lần nộp bài.  
  * FR3.6: Người dùng có thể lưu code nháp.

#### **1.3 Yêu cầu phi chức năng (Non-Functional Requirements \- NFR)**

* **NFR1: Hiệu năng (Performance)**  
  * NFR1.1: Thời gian phản hồi của API dưới 200ms cho các tác vụ không liên quan đến chấm bài (đăng nhập, xem danh sách bài, xem chi tiết bài).  
  * NFR1.2: Thời gian chấm bài trung bình dưới 5 giây cho các bài tập có giới hạn thời gian chạy 1 giây (không bao gồm thời gian xếp hàng).  
  * NFR1.3: Hệ thống có khả năng xử lý đồng thời 100 yêu cầu chấm bài mà vẫn duy trì hiệu suất chấp nhận được.  
* **NFR2: Bảo mật (Security)**  
  * NFR2.1: Mật khẩu người dùng phải được băm và lưu trữ an toàn (ví dụ: BCrypt).  
  * NFR2.2: Hệ thống chấm bài phải chạy trong môi trường sandbox cô lập (Docker containers) để ngăn chặn mã độc và truy cập trái phép tài nguyên hệ thống.  
  * NFR2.3: Các giao tiếp API phải được bảo vệ bằng HTTPS.  
  * NFR2.4: Xác thực và ủy quyền dựa trên JWT (JSON Web Tokens).  
* **NFR3: Khả năng mở rộng (Scalability)**  
  * NFR3.1: Hệ thống được thiết kế theo kiến trúc Microservices để dễ dàng mở rộng từng thành phần độc lập.  
  * NFR3.2: Các dịch vụ chấm bài (Judging Service) có thể mở rộng số lượng worker một cách linh hoạt khi tải tăng cao.  
  * NFR3.3: Cơ sở dữ liệu có khả năng mở rộng (ví dụ: hỗ trợ read replicas trong tương lai).  
* **NFR4: Độ sẵn sàng (Availability)**  
  * NFR4.1: Hệ thống hoạt động 24/7 với Uptime mục tiêu 99% (không bao gồm thời gian bảo trì định kỳ).  
  * NFR4.2: Các dịch vụ quan trọng (Auth, Problem, Judging) cần có khả năng chịu lỗi cơ bản.  
* **NFR5: Khả năng tương thích (Compatibility)**  
  * NFR5.1: Giao diện người dùng tương thích với các trình duyệt web phổ biến hiện nay (Chrome, Firefox, Edge, Safari phiên bản mới nhất).

#### **1.4 Use Case Diagram (Mô tả đơn giản)**

| Use Case | Actor | Mô tả |
| :---- | :---- | :---- |
| **Đăng nhập/đăng ký** | User | Người dùng thực hiện việc tạo tài khoản mới hoặc xác thực để truy cập hệ thống. |
| **Xem danh sách bài tập** | User | Người dùng duyệt qua các bài tập có sẵn trên nền tảng. |
| **Xem chi tiết bài tập** | User | Người dùng đọc mô tả, yêu cầu và ví dụ của một bài tập cụ thể. |
| **Nộp bài** | User | Người dùng gửi mã nguồn của mình cho một bài tập để hệ thống chấm điểm. |
| **Chấm bài** | Worker (Hệ thống) | Thành phần tự động xử lý mã nguồn đã nộp, chạy test và trả về kết quả. |
| **Xem kết quả nộp bài** | User | Người dùng kiểm tra trạng thái và chi tiết kết quả của bài làm đã nộp. |
| **Quản lý bài tập** | Admin | Quản trị viên thực hiện các thao tác thêm, sửa, xóa bài tập và test cases. |
| **Quản lý hồ sơ cá nhân** | User | Người dùng cập nhật thông tin cá nhân của mình. |

### **CHƯƠNG 2: THIẾT KẾ HỆ THỐNG SPRING BOOT**

#### **2.1 Kiến trúc hệ thống: Microservices**

Chúng tôi sẽ áp dụng kiến trúc Microservices để đạt được khả năng mở rộng, khả năng bảo trì và linh hoạt cao.

* **API Gateway:** **Spring Cloud Gateway**  
  * Điểm vào duy nhất cho tất cả các yêu cầu từ phía Frontend.  
  * Thực hiện định tuyến (routing) yêu cầu tới các dịch vụ phù hợp.  
  * Xử lý các tác vụ xuyên suốt (cross-cutting concerns) như xác thực, ủy quyền (token relay), ghi log, giới hạn tốc độ (rate limiting), CORS, và retry.  
* **Service Discovery:** **Eureka Server**  
  * Cho phép các microservices đăng ký (register) và khám phá (discover) lẫn nhau một cách động.  
  * Đảm bảo tính linh hoạt khi triển khai và mở rộng các dịch vụ.  
* **Các dịch vụ chính:**  
  * **Auth Service:**  
    * Chịu trách nhiệm quản lý người dùng: đăng ký, đăng nhập, đổi mật khẩu.  
    * Phát hành và xác thực **JWT (JSON Web Tokens)** để ủy quyền.  
  * **User Service:**  
    * Quản lý thông tin hồ sơ người dùng (profile).  
    * Lưu trữ lịch sử nộp bài của từng người dùng.  
  * **Problem Service:**  
    * Quản lý thông tin bài tập (mô tả, độ khó, giới hạn thời gian/bộ nhớ, test cases).  
    * Cung cấp API để Admin thêm/sửa/xóa bài tập.  
  * **Submission Service:**  
    * Tiếp nhận yêu cầu nộp bài từ người dùng (source code, ngôn ngữ, ID bài tập).  
    * Lưu trữ thông tin submission vào CSDL.  
    * **Gửi message không đồng bộ** (asynchronously) chứa thông tin submission đến hàng đợi tin nhắn (**RabbitMQ**).  
  * **Judging Service:**  
    * Đóng vai trò là các **Judging Worker**.  
    * Liên tục lắng nghe và nhận message từ hàng đợi RabbitMQ.  
    * Thực hiện quá trình chấm bài (biên dịch, chạy code trong Docker sandbox, so sánh kết quả).  
    * Cập nhật trạng thái và kết quả chấm bài trở lại Submission Service (hoặc trực tiếp vào CSDL).  
* **Message Broker:** **RabbitMQ (hoặc Kafka)**  
  * Đảm bảo giao tiếp không đồng bộ giữa Submission Service và Judging Service.  
  * Xử lý hàng đợi các yêu cầu chấm bài, giúp hệ thống chịu tải tốt hơn và tăng tính ổn định.

#### **2.2 Thiết kế CSDL (PostgreSQL)**

Sử dụng PostgreSQL làm cơ sở dữ liệu chính, hỗ trợ các mối quan hệ phức tạp và tính toàn vẹn dữ liệu.

| Bảng (Table) | Trường Chính (Key Fields) | Mô tả |
| :---- | :---- | :---- |
| users | id (PK), username, email (UNIQUE), password\_hash, role | Lưu trữ thông tin người dùng và vai trò của họ. |
| problems | id (PK), title, description, difficulty, time\_limit (ms), memory\_limit (MB) | Lưu trữ thông tin chi tiết của các bài tập. |
| submissions | id (PK), user\_id (FK to users.id), problem\_id (FK to problems.id), source\_code, language, status (Accepted, WA, CE, TLE, MLE), score, submitted\_at | Lưu trữ thông tin về mỗi lần người dùng nộp bài, bao gồm mã nguồn và kết quả. |
| test\_cases | id (PK), problem\_id (FK to problems.id), input, expected\_output, is\_sample (boolean) | Chứa các bộ dữ liệu kiểm thử (input) và đầu ra mong đợi (expected output) cho mỗi bài tập. is\_sample dùng để phân biệt test case công khai và ẩn. |

* **Quan hệ:**  
  * users 1-N submissions (Một người dùng có nhiều lượt nộp bài)  
  * problems 1-N submissions (Một bài tập có nhiều lượt nộp bài)  
  * problems 1-N test\_cases (Một bài tập có nhiều test cases)

#### **2.3 Auto-grader Design (Thiết kế hệ thống chấm tự động)**

Đây là thành phần phức tạp và quan trọng nhất của hệ thống.

1. **Submission Queueing:**  
   * Khi người dùng nộp bài, Submission Service sẽ tạo một record trong bảng submissions với trạng thái Pending và sau đó gửi một message (chứa submission\_id, problem\_id, source\_code, language) tới một hàng đợi RabbitMQ (ví dụ: submission\_queue).  
2. **Judging Worker Activation:**  
   * Các **Judging Workers** (các instance của Judging Service) sẽ liên tục lắng nghe submission\_queue.  
   * Mỗi worker sẽ lấy một message từ hàng đợi khi nó rảnh rỗi.  
3. **Docker Sandbox Execution:**  
   * Sau khi nhận message, worker sẽ sử dụng thư viện **docker-java** (hoặc Docker SDK tương ứng với ngôn ngữ) để:  
     * **Tạo một Docker Container mới:** Sử dụng image phù hợp với ngôn ngữ lập trình của submission (ví dụ: gcc-compiler, openjdk, python-runtime). Container này được cấu hình với các giới hạn về CPU, RAM, và mạng để đảm bảo an toàn và ngăn chặn lạm dụng tài nguyên.  
     * **Copy mã nguồn:** Mã nguồn của người dùng được copy vào trong container.  
     * **Biên dịch/Chạy:**  
       * Đối với ngôn ngữ biên dịch (C++, Java): Thực hiện lệnh biên dịch. Nếu có lỗi biên dịch, cập nhật status của submission là Compile Error.  
       * Đối với ngôn ngữ thông dịch (Python): Chạy trực tiếp.  
       * Thực thi mã nguồn với từng test\_case. Đầu vào của test\_case được truyền vào stdin của chương trình, và đầu ra của chương trình được so sánh với expected\_output của test\_case.  
     * **Giám sát tài nguyên:** Trong quá trình chạy, worker giám sát việc sử dụng CPU/RAM và thời gian chạy của chương trình. Nếu vượt quá giới hạn (time\_limit, memory\_limit), submission được đánh dấu là Time Limit Exceeded hoặc Memory Limit Exceeded.  
4. **Result Aggregation & Update:**  
   * Sau khi chạy tất cả các test case, worker tổng hợp kết quả (ví dụ: số test case qua, tổng điểm).  
   * Cập nhật status của submission (ví dụ: Accepted nếu tất cả test case đều đúng, Wrong Answer nếu có ít nhất một test case sai) và score vào cơ sở dữ liệu thông qua JPA/Hibernate (hoặc gọi API của Submission Service).  
5. **Container Cleanup:**  
   * Sau khi quá trình chấm bài hoàn tất, Docker container sẽ được dừng và xóa để giải phóng tài nguyên.

#### **2.4 Bảo mật (Security)**

* **Xác thực & Ủy quyền:**  
  * Sử dụng **Spring Security 6+** tích hợp đầy đủ.  
  * **JWT (JSON Web Tokens):** Auth Service sẽ tạo và phát hành JWT khi người dùng đăng nhập thành công. Các JWT này sẽ được gửi trong Header Authorization (Bearer Token) của mọi request tiếp theo từ client đến API Gateway.  
  * **FilterChain:** API Gateway và các Microservices sẽ có Spring Security FilterChain để xác thực JWT và kiểm tra quyền truy cập (Role-based access control \- RBAC).  
* **Phân quyền (Role-based Access):**  
  * Định nghĩa rõ ràng các vai trò (ROLE\_USER, ROLE\_ADMIN).  
  * Sử dụng @PreAuthorize hoặc cấu hình Security để giới hạn quyền truy cập vào các API cụ thể dựa trên vai trò của người dùng. Ví dụ: chỉ ROLE\_ADMIN mới có thể gọi API thêm/sửa/xóa bài tập.  
* **Tách biệt Auth Service:** Giúp tập trung quản lý xác thực và ủy quyền, giảm thiểu rủi ro bảo mật cho các dịch vụ khác.  
* **Refresh Token (Tính năng tương lai):** Để tăng cường bảo mật và trải nghiệm người dùng, có thể triển khai Refresh Token để cấp lại Access Token mà không yêu cầu người dùng đăng nhập lại thường xuyên.  
* **Mã hóa mật khẩu:** Sử dụng BCrypt (được tích hợp sẵn trong Spring Security) để băm mật khẩu người dùng trước khi lưu trữ vào CSDL.

#### **2.5 API Gateway (Spring Cloud Gateway)**

* **Định tuyến động:** Dựa trên Eureka Discovery, API Gateway tự động tìm và định tuyến yêu cầu đến các service phù hợp.  
* **Token Relay/Forwarding:** Gateway nhận JWT từ client và chuyển tiếp (forward) nó đến các backend service sau khi xác thực cơ bản. Các service backend sẽ tự xác thực lại JWT để đảm bảo an toàn.  
* **Bộ lọc (Filters):**  
  * **Authentication Filter:** Xác thực JWT cho mọi request đi qua Gateway.  
  * **Rate Limiting:** Ngăn chặn các cuộc tấn công DDoS hoặc lạm dụng API bằng cách giới hạn số lượng request từ một IP hoặc người dùng trong một khoảng thời gian.  
  * **CORS Configuration:** Xử lý chính sách Chia sẻ Tài nguyên Chéo Nguồn gốc (Cross-Origin Resource Sharing) để cho phép Frontend truy cập từ các domain khác.  
  * **Retry Mechanism:** Tùy chọn cấu hình để tự động thử lại các request đến backend service nếu có lỗi tạm thời.

#### **2.6 CI/CD & Giám sát (Monitoring)**

* **CI/CD (Continuous Integration/Continuous Deployment):**  
  * **Công nghệ:** **GitHub Actions / GitLab CI**  
  * **Quy trình:**  
    1. Developer commit code lên repository.  
    2. CI/CD pipeline tự động trigger.  
    3. Build code, chạy unit tests, và tạo Docker images cho từng microservice.  
    4. Push Docker images lên Container Registry (ví dụ: Docker Hub, AWS ECR).  
    5. Deploy các Docker images mới lên môi trường phát triển/staging/production (sử dụng Kubernetes/ECS hoặc thủ công bằng Docker Compose cho MVP).  
* **Logging (Ghi nhật ký):**  
  * **Công nghệ:** **ELK Stack (Elasticsearch, Logstash, Kibana)** hoặc **Loki \+ Grafana**.  
  * **Mục tiêu:** Tập trung hóa log từ tất cả các microservices để dễ dàng tìm kiếm, phân tích và gỡ lỗi.  
* **Monitoring (Giám sát):**  
  * **Công nghệ:** **Prometheus \+ Grafana**  
  * **Mục tiêu:** Thu thập các chỉ số (metrics) hiệu suất (CPU, RAM, network, số lượng request, thời gian phản hồi) từ từng microservice và hiển thị trên dashboard trực quan.  
* **Alerting (Cảnh báo):**  
  * **Công nghệ:** Tích hợp với Prometheus Alertmanager, có thể gửi cảnh báo qua Email / Slack / PagerDuty khi có sự cố hoặc vượt ngưỡng định sẵn.  
  * **Mục tiêu:** Nhanh chóng phát hiện và phản ứng với các vấn đề của hệ thống.

#### **2.7 Cấu trúc thư mục mỗi service (ví dụ: user-service)**

Mỗi microservice sẽ tuân theo một cấu trúc thư mục chuẩn, giúp dễ dàng quản lý và phát triển:  
`<tên-service>/`  
`├── src/main/java/com/codechallenge/<tên-service>/`  
`│   ├── controller/      // REST API Endpoints (ví dụ: UserController.java)`  
`│   ├── service/         // Business Logic (ví dụ: UserService.java)`  
`│   ├── repository/      // Data Access Layer (ví dụ: UserRepository.java)`  
`│   ├── dto/             // Data Transfer Objects (ví dụ: UserDTO.java, LoginRequest.java)`  
`│   ├── entity/          // JPA Entities (ví dụ: User.java)`  
`│   ├── config/          // Spring Configurations (ví dụ: SecurityConfig.java, WebConfig.java)`  
`│   ├── security/        // Security related classes (ví dụ: JwtRequestFilter.java, JwtUtil.java)`  
`│   ├── exception/       // Custom Exceptions (ví dụ: UserNotFoundException.java)`  
`│   └── util/            // Utility classes (ví dụ: MapperUtil.java)`  
`├── src/main/resources/`  
`│   ├── application.yml  // Service-specific configurations`  
`│   └── data.sql         // Initial data (optional)`  
`├── pom.xml              // Maven dependencies`  
`└── Dockerfile           // Docker build instructions`

#### **2.8 Chi tiết cấu trúc các Microservices**

Dưới đây là cấu trúc chi tiết hơn cho từng Microservice chính:

##### **2.8.1 Auth Service**

* **Mục đích:** Quản lý xác thực người dùng (đăng ký, đăng nhập) và cấp phát/xác thực JWT.  
* **Các thành phần chính:**  
  * controller/AuthController.java:  
    * POST /auth/register: Đăng ký tài khoản mới.  
    * POST /auth/login: Đăng nhập và trả về JWT.  
    * POST /auth/validate: Xác thực JWT (có thể dùng nội bộ bởi Gateway hoặc các service khác).  
  * service/AuthService.java:  
    * Chứa logic nghiệp vụ cho đăng ký, đăng nhập.  
    * Mã hóa mật khẩu (sử dụng BCryptPasswordEncoder).  
    * Tạo và quản lý JWT.  
  * repository/UserRepository.java:  
    * Interface JPA để tương tác với bảng users (chỉ các thao tác liên quan đến xác thực như tìm kiếm user theo email/username).  
  * entity/User.java:  
    * Entity JPA ánh xạ tới bảng users (chỉ các trường cần thiết cho xác thực: id, email, password\_hash, role).  
  * dto/AuthRequest.java, AuthResponse.java, RegisterRequest.java:  
    * Các đối tượng truyền dữ liệu giữa client và controller.  
  * security/JwtUtil.java:  
    * Utility class để tạo, parse, và validate JWT.  
  * security/JwtRequestFilter.java:  
    * Spring Security Filter để chặn các request, trích xuất JWT và xác thực.  
  * config/SecurityConfig.java:  
    * Cấu hình Spring Security (disable CSRF, cấu hình session management, định nghĩa PasswordEncoder, AuthenticationManager).

##### **2.8.2 User Service**

* **Mục đích:** Quản lý thông tin hồ sơ người dùng và lịch sử nộp bài.  
* **Các thành phần chính:**  
  * controller/UserController.java:  
    * GET /users/{id}: Lấy thông tin hồ sơ người dùng theo ID.  
    * PUT /users/{id}: Cập nhật thông tin hồ sơ người dùng.  
    * GET /users/{id}/submissions: Lấy lịch sử nộp bài của người dùng.  
  * service/UserService.java:  
    * Logic nghiệp vụ cho việc quản lý hồ sơ, lấy lịch sử nộp bài.  
    * Có thể gọi Submission Service để lấy dữ liệu lịch sử nộp bài (sử dụng OpenFeign).  
  * repository/UserRepository.java:  
    * Interface JPA để tương tác với bảng users (các thao tác CRUD cho profile).  
  * repository/SubmissionRepository.java:  
    * Interface JPA để truy vấn lịch sử nộp bài (chỉ đọc).  
  * entity/User.java, Submission.java:  
    * Các Entity JPA tương ứng.  
  * dto/UserDTO.java, UserUpdateRequest.java, SubmissionHistoryDTO.java:  
    * Các đối tượng truyền dữ liệu.  
  * config/WebConfig.java:  
    * Cấu hình CORS nếu cần.

##### **2.8.3 Problem Service**

* **Mục đích:** Quản lý thông tin về các bài tập lập trình (tạo, đọc, cập nhật, xóa bài tập và test cases).  
* **Các thành phần chính:**  
  * controller/ProblemController.java:  
    * GET /problems: Lấy danh sách bài tập (có thể có bộ lọc, phân trang).  
    * GET /problems/{id}: Lấy chi tiết một bài tập.  
    * POST /problems (Admin only): Tạo bài tập mới.  
    * PUT /problems/{id} (Admin only): Cập nhật bài tập.  
    * DELETE /problems/{id} (Admin only): Xóa bài tập.  
    * POST /problems/{id}/test-cases (Admin only): Thêm test case cho bài tập.  
  * service/ProblemService.java:  
    * Logic nghiệp vụ cho quản lý bài tập và test cases.  
  * repository/ProblemRepository.java:  
    * Interface JPA cho bảng problems.  
  * repository/TestCaseRepository.java:  
    * Interface JPA cho bảng test\_cases.  
  * entity/Problem.java, TestCase.java:  
    * Các Entity JPA tương ứng.  
  * dto/ProblemDTO.java, ProblemCreateRequest.java, TestCaseDTO.java:  
    * Các đối tượng truyền dữ liệu.  
  * security/AdminSecurityConfig.java:  
    * Cấu hình Spring Security để bảo vệ các API chỉ dành cho Admin.

##### **2.8.4 Submission Service**

* **Mục đích:** Tiếp nhận yêu cầu nộp bài từ người dùng, lưu trữ thông tin nộp bài và đẩy vào hàng đợi để chấm.  
* **Các thành phần chính:**  
  * controller/SubmissionController.java:  
    * POST /submissions: Nộp bài làm mới.  
    * GET /submissions/{id}: Lấy chi tiết một lượt nộp bài (bao gồm cả kết quả).  
    * GET /users/{userId}/submissions: Lấy danh sách các lượt nộp bài của một người dùng (có thể được gọi bởi User Service).  
  * service/SubmissionService.java:  
    * Lưu thông tin submission vào CSDL với trạng thái Pending.  
    * Gửi message tới RabbitMQ (sử dụng RabbitTemplate của Spring AMQP).  
    * Cập nhật trạng thái và kết quả submission khi nhận được phản hồi từ Judging Service.  
  * repository/SubmissionRepository.java:  
    * Interface JPA cho bảng submissions.  
  * entity/Submission.java:  
    * Entity JPA ánh xạ tới bảng submissions.  
  * dto/SubmissionRequest.java, SubmissionResponse.java, SubmissionResultUpdate.java:  
    * Các đối tượng truyền dữ liệu.  
  * config/RabbitMQConfig.java:  
    * Cấu hình kết nối RabbitMQ, khai báo Queue, Exchange.

##### **2.8.5 Judging Service (Judging Worker)**

* **Mục đích:** Nhận yêu cầu chấm bài từ hàng đợi, thực hiện quá trình chấm code trong Docker sandbox và cập nhật kết quả.  
* **Các thành phần chính:**  
  * listener/SubmissionMessageListener.java:  
    * Lắng nghe message từ RabbitMQ queue (@RabbitListener).  
    * Khi nhận được message, trích xuất thông tin submission.  
  * service/JudgingService.java:  
    * Logic chính của quá trình chấm bài.  
    * Gọi DockerService để tạo/quản lý container.  
    * Thực hiện biên dịch và chạy code.  
    * So sánh output với expected\_output của test cases.  
    * Cập nhật kết quả vào CSDL (hoặc gọi API của Submission Service).  
  * service/DockerService.java:  
    * Wrapper cho docker-java API.  
    * Chức năng: createContainer, startContainer, copyFileToContainer, executeCommandInContainer, getContainerLogs, stopContainer, removeContainer.  
    * Quản lý giới hạn tài nguyên (CPU, RAM, thời gian chạy).  
  * repository/ProblemRepository.java:  
    * Interface JPA để lấy thông tin bài tập và test cases.  
  * repository/SubmissionRepository.java:  
    * Interface JPA để cập nhật trạng thái và kết quả submission.  
  * entity/Problem.java, TestCase.java, Submission.java:  
    * Các Entity JPA cần thiết để đọc dữ liệu.  
  * util/CodeCompiler.java, CodeRunner.java:  
    * Các lớp tiện ích để thực hiện các lệnh biên dịch/chạy cụ thể cho từng ngôn ngữ.  
  * config/RabbitMQConfig.java:  
    * Cấu hình kết nối RabbitMQ và khai báo Queue mà nó sẽ lắng nghe.

#### **2.9 Công nghệ đề xuất**

* **Frontend:**  
  * **React.js / Angular / Vue.js:** Framework UI mạnh mẽ, phổ biến, cộng đồng lớn. (Chọn một trong số này).  
* **Backend:**  
  * **Java 17:** Phiên bản LTS, hiệu suất và tính năng mới.  
  * **Spring Boot 3.x:** Framework mạnh mẽ, hệ sinh thái phong phú cho xây dựng Microservices.  
  * **Spring Cloud:** Hỗ trợ các mẫu kiến trúc phân tán (Eureka, Gateway, OpenFeign, etc.).  
* **Cơ sở dữ liệu:**  
  * **PostgreSQL / MySQL:** Hệ quản trị CSDL quan hệ ổn định, mạnh mẽ, và miễn phí.  
* **Hàng đợi tin nhắn (Message Queue):**  
  * **RabbitMQ (với Spring AMQP):** Đã được chứng minh, tin cậy, dễ tích hợp với Spring.  
* **Containerization:**  
  * **Docker:** Essential cho việc tạo môi trường chấm bài an toàn (sandbox) và đóng gói các microservices.  
  * **docker-java:** Thư viện Java để tương tác với Docker API.  
* **Xác thực:**  
  * **JWT Auth:** Tiêu chuẩn cho xác thực không trạng thái (stateless authentication).  
  * **Spring Security 6+:** Khung bảo mật mạnh mẽ của Spring.  
* **Hạ tầng (Infrastructure):**  
  * **AWS / GCP / Azure:** Các nhà cung cấp dịch vụ đám mây hàng đầu, cung cấp khả năng mở rộng, quản lý dịch vụ và độ tin cậy cao. (Đề xuất AWS EC2 cho worker chấm bài, RDS cho DB, SQS/SNS cho queue nếu không dùng RabbitMQ self-hosted).

#### **2.10 Tính năng tương lai (Future Enhancements)**

Đây là các tính năng có thể được phát triển trong các phiên bản tiếp theo sau khi MVP ổn định:

* **Bảng xếp hạng (Leaderboard):** Xếp hạng người dùng dựa trên điểm số, số bài đã giải, hoặc thời gian giải.  
* **Tích hợp đăng nhập bên thứ ba:** Hỗ trợ đăng nhập qua Google, Facebook, GitHub để tăng sự tiện lợi cho người dùng.  
* **Giao diện thân thiện với thiết bị di động:** Phát triển ứng dụng mobile hoặc tối ưu hóa giao diện web cho di động.  
* **Huy hiệu & Thành tích (Badges & Achievements):** Gamification để khuyến khích người dùng tương tác và học hỏi.  
* **Bộ lọc nâng cao:** Lọc bài tập theo chủ đề, tag thuật toán, độ khó, trạng thái, ngôn ngữ.  
* **Tính năng cộng đồng:** Bình luận về bài tập, diễn đàn thảo luận, chia sẻ lời giải.  
* **Cuộc thi lập trình (Contests):** Tổ chức các cuộc thi với bảng xếp hạng thời gian thực.  
* **Bài tập tương tác:** Bài tập có phần tương tác trực tiếp với người dùng hoặc phần trình bày kết quả đồ họa.  
* **Phản hồi chất lượng cao:** Cung cấp thông tin chi tiết hơn về lỗi (ví dụ: hiển thị test case bị sai, debug output).  
* **Hỗ trợ thêm ngôn ngữ lập trình.**