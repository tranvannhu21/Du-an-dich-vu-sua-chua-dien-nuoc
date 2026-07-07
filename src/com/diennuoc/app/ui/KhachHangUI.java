package com.diennuoc.app.ui;
import com.diennuoc.app.bll.KhachHangBLL;
import java.util.Scanner;

public class KhachHangUI {
    private KhachHangBLL bll = new KhachHangBLL();
    private Scanner scanner = new Scanner(System.in);

    public void hienThiMenu() {
        int luaChon = -1;
        while (luaChon != 0) {
            System.out.println("\nQuản lý khách hàng: ");
            System.out.println("1. Thêm khách hàng mới");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Cập nhật thông tin khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("0. Quay lại/Thoát");
            System.out.print("Nhập: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    xuLyThem();
                    break;
                case 2:
                    bll.hienThiDanhSach();
                    break;
                case 3:
                    xuLyCapNhat();
                    break;
                case 4:
                    xuLyXoa();
                    break;
                case 0:
                    System.out.println("Đã thoát menu Quản lý khách hàng.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 0 đến 4.");
            }
        }
    }

    private void xuLyThem() {
        System.out.println("\nThêm khách hàng");
        System.out.print("Nhập mã số: ");
        String maSo = scanner.nextLine();
        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String sdt = scanner.nextLine();

        System.out.print("Nhập điểm tích lũy ban đầu: ");
        int diem = 0;
        try {
            diem = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Điểm tích lũy phải là số! Hệ thống mặc định gán = 0.");
        }
        bll.themMoiKhachHang(maSo, hoTen, sdt, diem);
    }

    private void xuLyCapNhat() {
        System.out.println("\nCập nhật thông tin");
        System.out.print("Nhập mã khách hàng cần sửa: ");
        String maSo = scanner.nextLine();

        System.out.print("Nhập họ tên mới: ");
        String hoTenMoi = scanner.nextLine();

        System.out.print("Nhập số điện thoại mới: ");
        String sdtMoi = scanner.nextLine();

        System.out.print("Nhập điểm tích lũy mới: ");
        int diemMoi = 0;
        try {
            diemMoi = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Điểm phải là số, hủy thao tác cập nhật.");
            return; // Thoát hàm nếu nhập sai
        }
        bll.capNhatKhachHang(maSo, hoTenMoi, sdtMoi, diemMoi);
    }

    private void xuLyXoa() {
        System.out.println("\nXóa khách hàng");
        System.out.print("Nhập chính xác mã khách hàng cần xóa: ");
        String maSo = scanner.nextLine();

        // Cảnh báo xác nhận trước khi xóa (Best practice)
        System.out.print("Bạn có chắc chắn muốn xóa mã " + maSo + " không? (Y/N): ");
        String xacNhan = scanner.nextLine();

        if (xacNhan.equalsIgnoreCase("Y")) {
            bll.xoaKhachHang(maSo);
        } else {
            System.out.println("Đã hủy thao tác xóa.");
        }
    }
}