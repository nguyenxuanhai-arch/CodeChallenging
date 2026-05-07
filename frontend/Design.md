# CodeChallenging — Design.md

## 1. Product Overview

**CodeChallenging** là nền tảng luyện lập trình online bằng tiếng Việt.

Người dùng có thể:
- Luyện bài tập lập trình.
- Viết code trực tiếp trên trình duyệt.
- Chạy thử test case.
- Nộp bài lên hệ thống chấm tự động.
- Xem kết quả bài nộp.
- Theo dõi tiến độ học tập.
- Xem bảng xếp hạng.

Quản trị viên có thể:
- Quản lý bài tập.
- Quản lý bộ kiểm thử.
- Quản lý bài nộp.
- Quản lý người dùng.
- Quản lý vai trò và phân quyền.
- Theo dõi nhật ký hệ thống.

Mục tiêu thiết kế: tạo một giao diện web **chuyên nghiệp, tối giản, đồng bộ, responsive, hỗ trợ dark mode/light mode**, phù hợp với một nền tảng lập trình online dùng thực tế.

---

## 2. Design Direction

### 2.1 Visual Style

Giao diện cần mang cảm giác:

- Sạch
- Tối giản
- Bình tĩnh
- Kỹ thuật
- Chuyên nghiệp
- Dễ đọc
- Phù hợp developer
- Không màu mè
- Không giống game
- Không giống landing page bán hàng đơn thuần

Phong cách màu sắc lấy cảm hứng từ **chatgpt.com**:

- Nền trung tính
- Surface nhẹ
- Border mảnh
- Accent xanh lá/xanh teal tiết chế
- Không dùng quá nhiều màu nổi
- Không dùng neon
- Không dùng gradient ngẫu nhiên

### 2.2 Product Feeling

Sản phẩm nên có cảm giác kết hợp giữa:

- ChatGPT: sạch, trung tính, dễ tập trung
- GitHub: thực dụng, developer-focused
- LeetCode: workflow luyện bài và nộp code rõ ràng
- Vercel: SaaS polish, hiện đại, gọn

---

## 3. Language Requirement

Toàn bộ text hiển thị trong UI phải là **tiếng Việt**.

Bao gồm:

- Navigation labels
- Sidebar items
- Page titles
- Buttons
- Form labels
- Placeholders
- Table headers
- Empty states
- Error messages
- Success messages
- Toast notifications
- Modal titles
- Modal actions
- Footer links
- Status labels
- Difficulty labels
- Admin actions
- Dashboard cards
- Filter labels
- Sorting labels
- Chart labels
- User-facing helper text

Chỉ giữ tiếng Anh với các thuật ngữ kỹ thuật quen thuộc với developer:

- API
- JWT
- REST
- Online Judge
- Java
- JavaScript
- Python
- C++
- Runtime
- Memory
- Test case
- GitHub

### 3.1 Vietnamese UI Dictionary

| English | Vietnamese |
|---|---|
| Dashboard | Tổng quan |
| Problems | Bài tập |
| Submissions | Bài nộp |
| My Submissions | Bài nộp của tôi |
| Leaderboard | Bảng xếp hạng |
| Profile | Hồ sơ |
| Settings | Cài đặt |
| Search | Tìm kiếm |
| Filter | Bộ lọc |
| Sort | Sắp xếp |
| Save | Lưu |
| Cancel | Hủy |
| Delete | Xóa |
| Edit | Chỉnh sửa |
| Create | Tạo mới |
| Update | Cập nhật |
| View Detail | Xem chi tiết |
| Back | Quay lại |
| Continue | Tiếp tục |
| Sign In | Đăng nhập |
| Sign Up | Đăng ký |
| Get Started | Bắt đầu |
| Forgot Password | Quên mật khẩu |
| Reset Password | Đặt lại mật khẩu |
| Start Coding | Bắt đầu luyện tập |
| Explore Problems | Xem bài tập |
| Run | Chạy thử |
| Submit | Nộp bài |
| Console Output | Kết quả chạy |
| Language | Ngôn ngữ |
| Time Limit | Giới hạn thời gian |
| Memory Limit | Giới hạn bộ nhớ |
| Input | Đầu vào |
| Output | Đầu ra |
| Expected Output | Kết quả mong đợi |
| Explanation | Giải thích |
| Constraints | Ràng buộc |
| Related Topics | Chủ đề liên quan |
| Admin Dashboard | Tổng quan quản trị |
| Problem Management | Quản lý bài tập |
| Test Case Management | Quản lý bộ kiểm thử |
| Submission Management | Quản lý bài nộp |
| User Management | Quản lý người dùng |
| Roles & Permissions | Vai trò & phân quyền |
| System Logs | Nhật ký hệ thống |

---

## 4. Color System

Thiết kế phải có **Light Mode** và **Dark Mode**.

### 4.1 Light Mode

| Token | Usage |
|---|---|
| `background` | Nền chính, off-white hoặc warm neutral |
| `surface` | Card, panel, form container |
| `surface-muted` | Khu vực phụ, filter bar, sidebar nhẹ |
| `surface-elevated` | Modal, dropdown, popover |
| `border` | Border mảnh, ít tương phản |
| `text-primary` | Text chính, gần đen |
| `text-secondary` | Text phụ, xám trung tính |
| `text-muted` | Text ít quan trọng |
| `accent` | Xanh lá/xanh teal tiết chế |
| `accent-hover` | Hover của CTA chính |

### 4.2 Dark Mode

| Token | Usage |
|---|---|
| `background` | Nền chính, charcoal/near-black |
| `surface` | Card, panel, table |
| `surface-muted` | Sidebar, filter area |
| `surface-elevated` | Modal, dropdown |
| `border` | Border xám tối mềm |
| `text-primary` | Text chính, gần trắng |
| `text-secondary` | Text phụ, xám sáng |
| `text-muted` | Text ít quan trọng |
| `accent` | Xanh lá/xanh teal tiết chế |
| `accent-hover` | Hover của CTA chính |

### 4.3 Accent Usage

Accent chỉ dùng cho:

- Primary CTA
- Active navigation item
- Focus ring
- Selected tab
- Active filter
- Progress indicator
- Accepted status
- Important highlight

Không dùng accent để trang trí lung tung.

---

## 5. Status & Difficulty Colors

### 5.1 Submission Status

| Status | Vietnamese Label | Color Direction |
|---|---|---|
| Accepted | Đúng | Muted green |
| Wrong Answer | Sai kết quả | Muted red |
| Time Limit Exceeded | Quá thời gian | Muted orange |
| Runtime Error | Lỗi khi chạy | Muted purple |
| Compilation Error | Lỗi biên dịch | Muted yellow |
| Pending | Đang chờ | Muted blue/gray |
| Judging | Đang chấm | Muted blue/gray |

Không chỉ dựa vào màu. Luôn có label hoặc icon.

### 5.2 Difficulty

| Difficulty | Vietnamese Label | Color Direction |
|---|---|---|
| Easy | Dễ | Muted green |
| Medium | Trung bình | Muted amber |
| Hard | Khó | Muted red |

---

## 6. Typography

### 6.1 UI Font

- Dùng sans-serif hiện đại.
- Text tiếng Việt phải rõ dấu, dễ đọc.
- Không dùng font quá decorative.
- Heading rõ hierarchy.
- Body text dễ đọc ở desktop và mobile.

### 6.2 Code Font

- Dùng monospace font cho code editor, console output, test case input/output.
- Code phải có line height thoải mái.
- Không làm code quá nhỏ.

---

## 7. Layout System

Ứng dụng có 3 layout chính:

1. Public Layout
2. Client/User Layout
3. Admin Layout

Ba layout này phải khác nhau về mục đích sử dụng nhưng vẫn dùng chung design system.

---

## 8. Public Layout

Dùng cho:

- Landing Page
- Login
- Register
- Forgot Password
- Reset Password
- Public Problem Preview nếu cần

### 8.1 Public Navbar

Cấu trúc:

- Logo bên trái
- Navigation bên phải
- CTA
- Theme toggle

Navigation labels:

- Bài tập
- Bảng xếp hạng
- Đăng nhập
- Bắt đầu

### 8.2 Public Footer

Footer gồm:

- CodeChallenging
- Mô tả ngắn
- Điều khoản
- Quyền riêng tư
- Liên hệ
- GitHub
- Copyright

Public layout **không dùng sidebar**.

---

## 9. Client/User Layout

Dùng cho người dùng đã đăng nhập.

### 9.1 Client Navbar

Gồm:

- Logo
- Global search shortcut
- Link nhanh: Bài tập, Bảng xếp hạng
- Theme toggle
- Notification bell
- User avatar dropdown

Search placeholder:

> Tìm bài tập, chủ đề hoặc người dùng...

### 9.2 Client Sidebar

Desktop:

- Sidebar trái, có thể collapse.
- Active item rõ ràng.
- Icon đồng bộ.

Sidebar items:

- Tổng quan
- Bài tập
- Bài nộp của tôi
- Bảng xếp hạng
- Hồ sơ
- Cài đặt

Tablet/Mobile:

- Sidebar chuyển thành drawer.
- Có overlay.
- Có nút đóng.
- Không gây overflow ngang.

### 9.3 Client Footer

Footer nhỏ, không gây phân tán:

- CodeChallenging
- Điều khoản
- Quyền riêng tư
- Liên hệ
- Phiên bản hệ thống

Client layout phải giống app làm việc của developer, không giống landing page.

---

## 10. Admin Layout

Dùng cho quản trị viên.

Admin layout phải khác Client layout:

- Dữ liệu dày hơn
- Sidebar rõ hơn
- Table nhiều hơn
- Action management rõ hơn
- Ít yếu tố marketing hơn

### 10.1 Admin Sidebar

Items:

- Tổng quan quản trị
- Quản lý bài tập
- Quản lý bộ kiểm thử
- Quản lý bài nộp
- Quản lý người dùng
- Vai trò & phân quyền
- Nhật ký hệ thống
- Cài đặt
- Đăng xuất

### 10.2 Admin Topbar

Gồm:

- Page title
- Breadcrumb
- Search
- Theme toggle
- Admin avatar dropdown

### 10.3 Admin Footer

Có thể nhỏ hoặc bỏ nếu layout full-height.

Nếu có:

- CodeChallenging Admin
- Phiên bản hệ thống
- Cập nhật lần cuối

---

## 11. Responsive Rules

### 11.1 Desktop

- Full navbar
- Sidebar đầy đủ
- Multi-column layout
- Table layout cho dữ liệu lớn
- Coding workspace split-screen

### 11.2 Tablet

- Sidebar collapsible
- Giảm spacing
- Layout 2 cột có thể chuyển thành 1 cột
- Coding workspace có thể stack hoặc dùng tabs

### 11.3 Mobile

- Sidebar thành drawer
- Navbar compact
- Tables thành cards
- Forms single-column
- Buttons dễ bấm
- Không horizontal overflow
- Coding workspace dùng tabs:

Tabs:

- Mô tả
- Code
- Bộ kiểm thử
- Kết quả

Mobile không được chỉ là desktop thu nhỏ.

---

## 12. Core Components

### 12.1 Buttons

Variants:

- Primary
- Secondary
- Ghost
- Danger
- Success
- Icon button

States:

- Default
- Hover
- Active
- Focus
- Disabled
- Loading

### 12.2 Forms

Mỗi field cần có:

- Label
- Placeholder
- Helper text nếu cần
- Validation error
- Required indicator
- Disabled state
- Loading state

### 12.3 Tables

Table phải production-ready:

- Search
- Filter
- Sort
- Pagination
- Row actions
- Bulk actions cho admin
- Loading skeleton
- Empty state
- Mobile card version

### 12.4 Cards

Dùng cho:

- Dashboard metrics
- Recommended problems
- Profile stats
- Mobile table replacement
- Submission summary

### 12.5 Badges

Dùng cho:

- Difficulty
- Submission status
- User role
- Account status
- Problem visibility

### 12.6 Modals

Dùng cho:

- Delete confirmation
- Publish confirmation
- Change role
- Lock user
- Rejudge submission

### 12.7 Toasts

Dùng cho:

- Lưu thành công
- Cập nhật thất bại
- Đã nộp bài
- Đang chấm bài
- Không thể tải dữ liệu

### 12.8 Empty States

Ví dụ:

- Chưa có bài nộp nào
- Không tìm thấy bài tập phù hợp
- Chưa có người dùng nào
- Chưa có bộ kiểm thử

### 12.9 Loading States

- Skeleton cho cards
- Skeleton cho tables
- Loading button
- Spinner nhỏ trong action
- Pending state khi chấm bài

---

## 13. Page Specification

## 13.1 Landing Page

Mục tiêu: giới thiệu nền tảng và chuyển đổi người dùng.

Sections:

1. Hero
   - Headline tiếng Việt
   - Mô tả ngắn
   - CTA:
     - Bắt đầu luyện tập
     - Xem bài tập

2. Product Preview
   - Hiển thị coding workspace preview
   - Có problem panel, code editor, result panel

3. Feature Cards
   - Online Judge
   - Kho bài tập
   - Theo dõi tiến độ
   - Bảng xếp hạng

4. How It Works
   - Chọn bài tập
   - Viết code
   - Chạy bộ kiểm thử
   - Nộp bài
   - Nhận kết quả chấm

5. Statistics
   - Tổng số bài tập
   - Tổng bài nộp
   - Người dùng hoạt động
   - Lời giải đúng

6. Final CTA

7. Footer

Landing page phải nghiêm túc, không trẻ con.

---

## 13.2 Login Page

Fields:

- Email
- Mật khẩu

Actions:

- Đăng nhập
- Quên mật khẩu
- Đăng ký tài khoản

States:

- Loading
- Invalid credentials
- Required field error
- Password visibility toggle

---

## 13.3 Register Page

Fields:

- Tên người dùng
- Email
- Mật khẩu
- Xác nhận mật khẩu
- Checkbox đồng ý điều khoản

Actions:

- Đăng ký
- Đăng nhập

States:

- Validation error
- Loading
- Success

---

## 13.4 Forgot Password Page

Fields:

- Email

Actions:

- Gửi hướng dẫn
- Quay lại đăng nhập

States:

- Success message
- Email not found
- Loading

---

## 13.5 Reset Password Page

Fields:

- Mật khẩu mới
- Xác nhận mật khẩu

Actions:

- Đặt lại mật khẩu

States:

- Password rules
- Validation error
- Success

---

## 13.6 User Dashboard

Client layout.

Sections:

- Welcome card
- Số bài đã giải
- Tổng bài nộp
- Tỷ lệ đúng
- Xếp hạng hiện tại
- Hoạt động trong tuần
- Tiến độ theo độ khó
- Tiến độ theo chủ đề
- Bài nộp gần đây
- Bài tập đề xuất
- Tiếp tục luyện tập

Dashboard phải có giá trị sử dụng thật, không chỉ trang trí.

---

## 13.7 Problem List Page

Client layout.

Components:

- Search bar
- Filter độ khó:
  - Dễ
  - Trung bình
  - Khó
- Filter trạng thái:
  - Đã giải
  - Đã thử
  - Chưa làm
- Filter chủ đề/tag
- Sort:
  - Mới nhất
  - Tỷ lệ đúng
  - Độ khó
- Pagination

Desktop:

- Table

Mobile:

- Card list

Problem item:

- Tên bài
- Badge độ khó
- Tags
- Tỷ lệ đúng
- Trạng thái
- Button: Giải bài

---

## 13.8 Problem Detail / Coding Workspace

Đây là trang quan trọng nhất.

### Desktop Layout

Split-screen:

Left panel:

- Tiêu đề bài tập
- Badge độ khó
- Tags
- Mô tả bài toán
- Định dạng đầu vào
- Định dạng đầu ra
- Ràng buộc
- Ví dụ
- Giải thích
- Chủ đề liên quan

Right panel:

- Language selector
- Code editor
- Button: Chạy thử
- Button: Nộp bài
- Test case tabs
- Console output
- Result panel

### Mobile Layout

Tabs:

- Mô tả
- Code
- Bộ kiểm thử
- Kết quả

### Result States

- Đúng
- Sai kết quả
- Quá thời gian
- Lỗi khi chạy
- Lỗi biên dịch
- Đang chờ
- Đang chấm

Coding workspace phải giống một lightweight IDE, nhưng vẫn tối giản và dễ dùng.

---

## 13.9 Submission Detail Page

Sections:

- Status summary card
- Tên bài tập
- Ngôn ngữ
- Runtime
- Memory
- Thời gian nộp
- Tổng kết test case
- Code viewer
- Error message panel
- So sánh đầu ra nếu sai
- Button quay lại bài tập

---

## 13.10 My Submissions Page

Components:

- Submission table desktop
- Submission card mobile
- Filter status
- Filter language
- Filter problem
- Sort by time
- Pagination

Item fields:

- Tên bài
- Trạng thái
- Ngôn ngữ
- Runtime
- Memory
- Thời gian nộp
- Xem chi tiết

---

## 13.11 Leaderboard Page

Sections:

- Rank hiện tại của user
- Bảng xếp hạng toàn hệ thống
- Bảng xếp hạng tuần
- Search user
- Ranking table

Row fields:

- Hạng
- Avatar
- Tên người dùng
- Số bài đã giải
- Điểm
- Tỷ lệ đúng

---

## 13.12 User Profile Page

Sections:

- Avatar
- Username
- Bio
- GitHub
- Website
- Thống kê bài đã giải
- Breakdown theo độ khó
- Bài nộp gần đây
- Badges
- Activity heatmap
- Chủ đề yêu thích

---

## 13.13 Account Settings Page

Sections:

- Thông tin hồ sơ
- Upload avatar
- Đổi mật khẩu
- Cài đặt thông báo
- Tùy chọn giao diện
- Tài khoản liên kết
- Vùng nguy hiểm

Danger zone cần visually distinct nhưng không quá gắt.

---

## 13.14 Admin Dashboard

Admin layout.

Sections:

- Tổng người dùng
- Tổng bài tập
- Tổng bài nộp
- Bài nộp đúng
- Hoạt động gần đây
- Biểu đồ trạng thái bài nộp
- Biểu đồ tăng trưởng người dùng
- Phân bố độ khó bài tập
- Tình trạng hệ thống

Admin dashboard phải data-focused, compact hơn user dashboard.

---

## 13.15 Admin Problem Management Page

Components:

- Problem table
- Search
- Filter difficulty
- Filter status
- Button tạo bài tập
- Edit action
- Delete action
- Publish/unpublish toggle
- Bulk actions

Row fields:

- Tên bài
- Slug
- Độ khó
- Tags
- Trạng thái
- Số bài nộp
- Tỷ lệ đúng
- Cập nhật lần cuối
- Hành động

---

## 13.16 Admin Create/Edit Problem Page

Fields:

- Tiêu đề
- Slug
- Độ khó
- Tags
- Nội dung bài toán
- Định dạng đầu vào
- Định dạng đầu ra
- Ràng buộc
- Ví dụ
- Bộ kiểm thử
- Giới hạn thời gian
- Giới hạn bộ nhớ
- Ngôn ngữ hỗ trợ
- Trạng thái:
  - Bản nháp
  - Đã xuất bản
  - Đã lưu trữ

Actions:

- Lưu bản nháp
- Xuất bản
- Hủy

Form nên có section grouping rõ ràng.
Có thể có sticky action bar.

---

## 13.17 Admin Test Case Management Page

Components:

- Danh sách test case
- Thêm test case
- Input editor
- Expected output editor
- Toggle public/hidden
- Order index
- Delete test case
- Bulk upload
- Preview output

---

## 13.18 Admin Submission Management Page

Components:

- Submission table
- Filter status
- Filter language
- Filter problem
- Filter user
- View detail
- Rejudge action
- Bulk action nếu cần

---

## 13.19 Admin User Management Page

Components:

- User table
- Search username/email
- Filter role
- Filter status
- Role badge
- Account status badge
- Lock/unlock
- View detail
- Change role

---

## 13.20 Admin Role & Permission Page

Purpose:

- Quản lý role-based access control.

Components:

- Role list
- Permission matrix
- Create role
- Edit role
- Delete role
- Assign permissions
- Save changes

---

## 13.21 Error Pages

Pages:

- 404 Not Found
- 403 Forbidden
- 500 Server Error
- Maintenance Page

Requirements:

- Illustration tối giản
- Message tiếng Việt
- Button về trang chủ
- Button về tổng quan
- Dark mode/light mode support

---

## 14. Realistic Sample Data

### 14.1 Problem Names

- Tổng hai số
- Kiểm tra ngoặc hợp lệ
- Gộp khoảng thời gian
- Chuỗi con không lặp dài nhất
- Duyệt cây nhị phân theo tầng
- Tìm kiếm nhị phân
- Đường đi ngắn nhất
- Sắp xếp lịch họp

### 14.2 Languages

- Java
- JavaScript
- Python
- C++

### 14.3 Users

- minhcode
- hai_backend
- dev_nam
- linh_java
- data_runner

### 14.4 Admin Sample Users

- Nguyễn Văn Minh
- Trần Hoàng Nam
- Lê Gia Hân
- Phạm Anh Khoa
- Võ Minh Quân

### 14.5 Submission Statuses

- Đúng
- Sai kết quả
- Quá thời gian
- Lỗi khi chạy
- Lỗi biên dịch
- Đang chấm

---

## 15. Accessibility

Yêu cầu:

- Text contrast cao
- Focus state rõ
- Touch target đủ lớn trên mobile
- Không chỉ dùng màu để thể hiện status
- Icon cần có label hoặc tooltip
- Dark mode phải dễ đọc
- Form phải dễ scan
- Table mobile phải dễ hiểu
- Text tiếng Việt không được quá nhỏ
- Label dài tiếng Việt không được phá layout

---

## 16. Implementation Context

Thiết kế nên phù hợp để implement bằng:

- React
- Tailwind CSS
- RESTful API
- Spring Boot backend
- JWT authentication
- Role-based access control
- Online judge workflow
- Client/Admin route separation

---

## 17. Design Quality Checklist

Trước khi hoàn thành thiết kế, kiểm tra:

- Toàn bộ UI text là tiếng Việt.
- Public layout, Client layout, Admin layout tách biệt rõ.
- Navbar, sidebar, footer đồng bộ.
- Light mode và dark mode dùng chung design token.
- Màu sắc trung tính, calm, giống tinh thần chatgpt.com.
- Admin pages data-dense và management-focused.
- Client pages coding-focused và dễ dùng.
- Mobile layout dùng drawer, tabs, cards.
- Không có table bị ép ngang trên mobile.
- Coding workspace là trang mạnh nhất.
- Không còn English label ngẫu nhiên.
- Không dùng màu trang trí lung tung.
- Không có component mỗi trang một kiểu.
- Empty/loading/error/success states đầy đủ.
- Form có validation state.
- Table có filter/sort/pagination.
- Status có label rõ, không chỉ dùng màu.

---

## 18. Prompt for Google Stitch

Use this prompt when generating the design in Google Stitch:

```text
Create a complete, production-ready UI/UX design system for a Vietnamese web application named “CodeChallenging”.

CodeChallenging is an online programming platform where users can practice coding problems, write code, submit solutions to an online judge, view verdicts, track progress, and compete on leaderboards. Admins can manage problems, test cases, submissions, users, roles, permissions, and system data.

The UI must support Public pages, Client/User pages, and Admin pages. The interface must be fully responsive for desktop, laptop, tablet, and mobile.

All visible UI text must be in Vietnamese. Keep only common programming terms in English when natural for developers, such as API, JWT, REST, Online Judge, Java, JavaScript, Python, C++, Runtime, Memory, Test case, and GitHub.

Use a calm, minimal, professional visual style inspired by chatgpt.com. The product should feel clean, neutral, developer-focused, mature, technical, calm, minimal, premium, and SaaS-ready.

Create both Light Mode and Dark Mode. Use soft off-white and neutral surfaces in Light Mode. Use deep charcoal, dark neutral surfaces, subtle borders, and readable text in Dark Mode. Use a restrained green/teal accent inspired by ChatGPT for CTA buttons, active navigation, focus rings, selected tabs, progress indicators, and important highlights.

Create three layout systems:
1. Public Layout with top navbar and footer, no sidebar.
2. Client/User Layout with top navbar, optional sidebar, drawer on mobile, compact footer.
3. Admin Layout with fixed/collapsible sidebar, admin topbar, breadcrumbs, dense tables, and management-focused pages.

Design these pages:
- Landing Page
- Login Page
- Register Page
- Forgot Password Page
- Reset Password Page
- User Dashboard
- Problem List Page
- Problem Detail / Coding Workspace
- Submission Detail Page
- My Submissions Page
- Leaderboard Page
- User Profile Page
- Account Settings Page
- Admin Dashboard
- Admin Problem Management Page
- Admin Create/Edit Problem Page
- Admin Test Case Management Page
- Admin Submission Management Page
- Admin User Management Page
- Admin Role & Permission Page
- Error Pages: 404, 403, 500, Maintenance

The coding workspace is the most important page. On desktop, use split screen: problem statement on the left, code editor and result panel on the right. On mobile, use tabs: Mô tả, Code, Bộ kiểm thử, Kết quả.

All tables must support search, filter, sort, pagination, row actions, loading skeleton, empty state, and mobile card layout.

All forms must include labels, placeholders, helper text, validation errors, required indicators, disabled state, loading submit state, success feedback, cancel button, and save button.

Use Vietnamese labels such as:
Tổng quan, Bài tập, Bài nộp, Bài nộp của tôi, Bảng xếp hạng, Hồ sơ, Cài đặt, Đăng nhập, Đăng ký, Bắt đầu luyện tập, Xem bài tập, Chạy thử, Nộp bài, Bộ kiểm thử, Kết quả chạy, Quản lý bài tập, Quản lý người dùng, Vai trò & phân quyền, Nhật ký hệ thống.

Use status labels:
Đúng, Sai kết quả, Quá thời gian, Lỗi khi chạy, Lỗi biên dịch, Đang chờ, Đang chấm.

Use difficulty labels:
Dễ, Trung bình, Khó.

Avoid neon cyberpunk style, gaming UI, random gradients, decorative clutter, inconsistent layouts, English labels, and desktop-only responsive behavior.

The final design must feel cohesive, realistic, production-ready, and suitable for implementation with React, Tailwind CSS, RESTful API, Spring Boot backend, JWT authentication, role-based access control, and online judge workflow.
```

---

## 19. Refinement Prompt for Google Stitch

Use this after the first generation:

```text
Refine the entire design for consistency.

Make sure:
- All visible UI text is Vietnamese.
- Public layout, Client layout, and Admin layout are clearly separated.
- Navigation, sidebar, footer, spacing, border, radius, and colors are consistent.
- Light Mode and Dark Mode use the same design tokens.
- The color palette stays calm and neutral like chatgpt.com.
- Admin pages look more data-dense and management-focused.
- Client pages look more user-friendly and coding-focused.
- Mobile layouts use drawers, tabs, and cards instead of squeezed desktop tables.
- The coding workspace feels like a real lightweight IDE.
- Remove random English labels unless they are technical programming terms.
- Remove random colors, decorative clutter, and inconsistent components.
```
