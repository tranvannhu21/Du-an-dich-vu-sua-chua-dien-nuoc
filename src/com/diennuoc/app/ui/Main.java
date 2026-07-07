package com.diennuoc.app.ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KhachHangUI khachHangUI = new KhachHangUI();
        ThoSuaChuaUI thoSuaChuaUI = new ThoSuaChuaUI();
        HoaDonUI hoaDonUI = new HoaDonUI(); // MỚI THÊM: Khởi tạo UI của hóa đơn

        int luaChon = -1;

        while (luaChon != 0) {
            System.out.println("Hệ thống quản lý dịch vụ sửa chữa điện nước");
            System.out.println("1.Quản lý khách hàng");
            System.out.println("2.Quản lý thợ sửa chữa");
            System.out.println("3.Hóa đơn & thanh toán");
            System.out.println("0.Thoát");
            System.out.print("Mời nhập: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    khachHangUI.hienThiMenu();
                    break;
                case 2:
                    thoSuaChuaUI.hienThiMenu();
                    break;
                case 3:
                    hoaDonUI.hienThiMenu();
                    break;
                case 0:
                    System.out.println("Đang đóng hệ thống. Cảm ơn bạn đã sử dụng!");
                    break;
                default:
                    System.out.println("Lựa chọn không tồn tại, vui lòng thử lại.");
            }
        }
        scanner.close();
    }
}