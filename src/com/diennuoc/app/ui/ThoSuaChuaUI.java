package com.diennuoc.app.ui;

import com.diennuoc.app.bll.ThoSuaChuaBLL;
import java.util.Scanner;

public class ThoSuaChuaUI {
    private ThoSuaChuaBLL bll = new ThoSuaChuaBLL();
    private Scanner scanner = new Scanner(System.in, "UTF-8");

    public void hienThiMenu() {
        int luaChon = -1;
        while (luaChon != 0) {
            System.out.println("\nQuản lý thợ: ");
            System.out.println("1. Thêm thợ mới");
            System.out.println("2. Hiển thị thợ đang hoạt động");
            System.out.println("3. Cập nhật thông tin thợ");
            System.out.println("4. Cho nghỉ việc");
            System.out.println("0. Quay lại/Thoát");
            System.out.print("Nhập: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
                continue;
            }

            switch (luaChon) {
                case 1: xuLyThem(); break;
                case 2: bll.hienThiDanhSach(); break;
                case 3: xuLyCapNhat(); break;
                case 4: xuLyXoa(); break;
                case 0: System.out.println("Đã thoát menu Quản lý Thợ."); break;
                default: System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void xuLyThem() {
        System.out.println("\nThêm thợ mới");
        System.out.print("Nhập mã thợ: ");
        String maSo = scanner.nextLine();
        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String sdt = scanner.nextLine();
        System.out.print("Nhập chuyên môn (Điện/Nước/Cả hai): ");
        String chuyenMon = scanner.nextLine();
        bll.themMoiTho(maSo, hoTen, sdt, chuyenMon);
    }

    private void xuLyCapNhat() {
        System.out.println("\nCập nhật thông tin");
        System.out.print("Nhập mã thợ cần sửa: ");
        String maSo = scanner.nextLine();
        System.out.print("Nhập họ tên mới: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập số điện thoại mới: ");
        String sdt = scanner.nextLine();
        System.out.print("Nhập chuyên môn mới: ");
        String chuyenMon = scanner.nextLine();
        bll.capNhatThongTin(maSo, hoTen, sdt, chuyenMon);
    }

    private void xuLyXoa() {
        System.out.println("\nCho nghỉ việc");
        System.out.print("Nhập mã thợ cần cho nghỉ: ");
        String maSo = scanner.nextLine();

        System.out.print("Xác nhận cho thợ này nghỉ việc? (Y/N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            bll.choNghiViec(maSo);
        }
    }
}