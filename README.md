### 1. Mục tiêu dự án
   Làm template chuẩn kiến trúc phân tầng (Layered Architecture).
   Rèn luyện OOP nâng cao: kế thừa, đa hình, interface, abstract class, generic, exception, tách lớp trách nhiệm.
   Thực hành mở rộng nghiệp vụ theo hướng clean code và dễ bảo trì.

### 2. Yêu cầu môi trường
   JDK 17 trở lên.
   Terminal (zsh/bash/cmd) để biên dịch và chạy thủ công.
   IDE khuyến nghị: VS Code hoặc IntelliJ.
   Kiểm tra Java:

java -version
javac -version

### 3. Cấu trúc thư mục
   src/main/java/com/diennuoc
   ├── bll
   │   ├── HoaDonBLL.java
   │   ├── KhachHangBLL.java
   │   ├── ThoSuaChuaBLL.java
   ├── dao
   │   ├── HoaDonDAO.java
   │   ├── KhachHangDAO.java
   │   ├── ThoSuaChuaDAO.java
   ├── entity
   │   ├── HoaDon.java
   │   ├── KhachHang.java
   │   └── ThoSuaChua.java
   ├── ui
   │   ├── HoaDonUI.java
       ├── Main.java
   │   ├── KhachHang.java
   │   └── ThoSuaChua.java
   └── util
   ├── FileHandler.java

### 4. Vai trò từng tầng

#### 4.1 entity (Tầng Thực thể dữ liệu)
Vai trò: Là nơi chứa các "khuôn đúc" tạo nên các đối tượng trong hệ thống.
Nhiệm vụ: Chỉ chứa các thuộc tính (ví dụ: maSo, hoTen, tongTien), hàm khởi tạo (constructor) và các hàm Getters/Setters.
Đặc điểm: Tầng này "ngây thơ" nhất. Nó không chứa bất kỳ logic tính toán phức tạp, không in ra màn hình và không biết gì về việc lưu file. Nó chỉ đơn thuần là gói bọc dữ liệu.

#### 4.2 ui (User Interface - Tầng Giao diện)
Vai trò: Là "mặt tiền" của ứng dụng, nơi duy nhất tương tác trực tiếp với người dùng.
Nhiệm vụ: * Hiển thị menu chức năng ra màn hình Console (System.out.println).
Tiếp nhận lựa chọn và dữ liệu người dùng nhập vào (thông qua InputHelper).
Gọi tầng bll để xử lý yêu cầu, sau đó nhận kết quả từ bll để in ra thông báo "Thành công" hoặc "Thất bại".
Đặc điểm: Tuyệt đối không tự ý lưu dữ liệu hay chứa các logic kiểm tra đúng sai (như kiểm tra mã trùng).

#### 4.3 bll (Business Logic Layer - Tầng Nghiệp vụ)
Vai trò: Là "bộ não" của hệ thống, đứng ở giữa làm cầu nối bảo vệ dữ liệu.
Nhiệm vụ: Kiểm tra các quy tắc nghiệp vụ (Business Rules).
Ví dụ: Khi ui gửi yêu cầu thêm khách hàng, bll sẽ kiểm tra xem mã khách hàng đó đã tồn tại chưa, số điện thoại có hợp lệ không.
Nếu hợp lệ, bll mới ra lệnh cho dao lưu lại. Nếu sai, bll sẽ trả về thông báo lỗi cho ui.
Đặc điểm: Nó nhận dữ liệu từ ui, nhào nặn, kiểm tra, rồi mới đẩy xuống dao.

#### 4.4 dao (Data Access Object - Tầng Truy xuất dữ liệu)
Vai trò: Là "thủ kho", chuyên làm việc với kho lưu trữ.
Nhiệm vụ: Thực hiện các thao tác Thêm (Create), Đọc (Read), Sửa (Update), Xóa (Delete) trực tiếp lên danh sách ArrayList và ghi/đọc xuống file .csv.
Đặc điểm: Tầng này không quan tâm dữ liệu đúng hay sai (vì bll đã kiểm tra rồi). Cứ bll đưa dữ liệu xuống là nó lưu vào file, bll đòi lấy danh sách là nó đọc từ file lên trả về.

#### 4.5 utils (Tầng Tiện ích)
Vai trò: Là "hộp đồ nghề" dùng chung cho toàn bộ dự án.
Nhiệm vụ: Chứa các lớp hỗ trợ độc lập, có thể mang đi dùng ở bất cứ đâu.
FileHandler: Chuyên xử lý kỹ thuật đọc/ghi file CSV.
InputHelper: Chuyên ép kiểu và bắt lỗi khi người dùng gõ phím.
Đặc điểm: Các hàm trong này thường là public static để gọi trực tiếp mà không cần khởi tạo đối tượng.

### 5. Luồng chạy tổng quát
   Main khởi tạo repository in-memory cho Product và Order.
   Main khởi tạo ProductServiceImpl và OrderServiceImpl.
   Main truyền service vào MenuConsole.
   MenuConsole chạy vòng lặp menu, nhận lựa chọn người dùng.
   Service xử lý nghiệp vụ và gọi repository để CRUD.

### 6. Hướng dẫn sử dụng menu Console

#### Menu hiện có:
1.Quản lý khách hàng
2.Quản lý thợ sửa chữa
3.Hóa đơn & thanh toán
0.Thoát

##### Luồng Quản lý khách hàng:
1.Thêm khách hàng
2.Hiển thi thông tin khách hàng
3.Cập nhật thông tin khách hàng
4.Xóa khách hàng
0.Quay lại/Thoát

##### Luồng quản lý thợ:
1.Thêm thợ mới
2.Hiển thị thợ đang hoạt động
3.Thông tin thợ
4.Cho nghỉ việc
0.Quay lại/Thoát

##### Luồng hóa đơn & thanh toán:
1.Tạo hóa đơn mới
2.Xem danh sách hóa đơn
3.Xác nhận thanh toán
0.Quay lại

### 7. Tài liệu tính năng
