# Hệ thống Quản lý Dịch vụ Sửa chữa Điện Nước
Ứng dụng console viết bằng Java, quản lý khách hàng, thợ sửa chữa và 
hóa đơn thanh toán cho một dịch vụ sửa chữa điện nước. 
Dữ liệu được lưu trữ dưới dạng file CSV, không sử dụng cơ sở dữ liệu.


### Giới thiệu

Dự án mô phỏng nghiệp vụ của một cửa hàng/đội thợ sửa chữa điện nước, cho phép:
Quản lý thông tin khách hàng
Quản lý thông tin thợ sửa chữa
Tạo và theo dõi hóa đơn dịch vụ, xác nhận thanh toán
Đây là dự án học tập, tập trung vào việc rèn luyện lập trình hướng đối tượng 
(OOP) và phân tách kiến trúc theo tầng (layered architecture) trong Java.

### Kiến trúc dự án

Dự án được tổ chức theo mô hình phân tầng gồm 4 lớp:

Entity: Định nghĩa đối tượng dữ liệu (KhachHang, ThoSuaChua, HoaDon).
DAO(Data Access Object): Đọc/ghi dữ liệu từ file CSV, thao tác trực tiếp với danh sách trong bộ nhớ.
BLL(Business Logic Layer): Kiểm tra tính hợp lệ dữ liệu, xử lý nghiệp vụ trước khi gọi xuống DAO.
UI: Hiển thị menu, nhận thao tác từ người dùng qua console.

Luồng xử lý một thao tác: UI → BLL (kiểm tra hợp lệ) → DAO (đọc/ghi file) → Entity (đối tượng dữ liệu).

### Cấu trúc thư mục

src/
└── com/diennuoc/app/
├── entity/
│   ├── KhachHang.java
│   ├── ThoSuaChua.java
│   └── HoaDon.java
├── dao/
│   ├── KhachHangDAO.java
│   ├── ThoSuaChuaDAO.java
│   └── HoaDonDAO.java
├── bll/
│   ├── KhachHangBLL.java
│   ├── ThoSuaChuaBLL.java
│   └── HoaDonBLL.java
├── ui/
│   ├── Main.java
│   ├── KhachHangUI.java
│   ├── ThoSuaChuaUI.java
│   └── HoaDonUI.java
└── utils/
└── FileHandler.java

khachhang.csv       # Dữ liệu khách hàng (tự sinh khi chạy)
thosuachua.csv       # Dữ liệu thợ sửa chữa (tự sinh khi chạy)
hoadon.csv           # Dữ liệu hóa đơn (tự sinh khi chạy)

### Chức năng chính

1. Quản lý khách hàng
-Thêm khách hàng mới (kiểm tra mã trùng, họ tên và số điện thoại không được để trống)
-Hiển thị danh sách khách hàng
-Cập nhật thông tin khách hàng
-Xóa khách hàng (có xác nhận trước khi xóa)


2. Quản lý thợ sửa chữa
-Thêm thợ mới (kiểm tra mã trùng)
-Hiển thị danh sách thợ đang hoạt động
-Cập nhật thông tin thợ
-Cho thợ nghỉ việc (xóa mềm — chỉ chuyển trạng thái, không xóa khỏi file)


3. Hóa đơn & thanh toán
-Tạo hóa đơn mới, gắn với mã khách hàng và mã thợ
-Hiển thị danh sách hóa đơn
-Xác nhận thanh toán cho hóa đơn theo mã


### Yêu cầu hệ thống
JDK 8 trở lên (không dùng cú pháp/API của Java 10+)
IDE khuyến nghị: IntelliJ IDEA


### Cách chạy chương trình
Chạy bằng IntelliJ IDEA

Mở project trong IntelliJ.
Vào Run → Edit Configurations, tạo cấu hình Application với Main class là com.diennuoc.app.ui.Main.
Thêm VM option: -Dfile.encoding=UTF-8 để hiển thị đúng tiếng Việt.
Bấm Run.

Chạy bằng dòng lệnh (Windows)

bashchcp 65001
javac -d out -encoding UTF-8 -cp src src/com/diennuoc/app/ui/*.java src/com/diennuoc/app/**/*.java
java -Dfile.encoding=UTF-8 -cp out com.diennuoc.app.ui.Main

### Định dạng dữ liệu

khachhang.csv

maSo,hoTen,soDienThoai
004,Trần Văn Nhu,0356789342

thosuachua.csv

maSo,hoTen,soDienThoai,chuyenMon,sanSangLamViec,dangHoatDong
007,Lê Văn Hồng,0342198567,Dien,true,true

hoadon.csv

maHoaDon,maKhachHang,maTho,tongTien,daThanhToan,phuongThucThanhToan
HD01,004,007,150000.0,false,Ví điện tử (MoMo)

### Lưu ý về encoding tiếng Việt

Chương trình đọc/ghi file CSV theo chuẩn UTF-8 thông qua FileHandler. Tuy nhiên, việc nhập liệu từ console trên Windows có thể bị lỗi hiển thị dấu tiếng Việt nếu terminal không ở chế độ UTF-8. Trước khi chạy, hãy:

Chạy chcp 65001 trong CMD, hoặc
Thêm VM option -Dfile.encoding=UTF-8 khi chạy bằng IntelliJ/dòng lệnh.


### Hướng phát triển

Bổ sung bọc try-catch khi đọc từng dòng CSV để tránh crash toàn bộ chương trình khi gặp dòng dữ liệu lỗi.
Kiểm tra mã khách hàng/mã thợ có tồn tại trước khi tạo hóa đơn.
Cho phép người dùng chọn phương thức thanh toán thay vì mặc định "Ví điện tử (MoMo)".
Có thể mở rộng sang lưu trữ bằng cơ sở dữ liệu (SQL) thay vì file CSV.