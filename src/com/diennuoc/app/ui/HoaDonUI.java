package com.diennuoc.app.ui;

import com.diennuoc.app.bll.HoaDonBLL;
import java.util.Scanner;

public class HoaDonUI {
    private HoaDonBLL hoaDonBLL = new HoaDonBLL();
    private Scanner scanner = new Scanner(System.in);

    public void hienThiMenu() {
        int luaChon = -1;
        while (luaChon != 0) {
            System.out.println("\n--- QUẢN LÝ THANH TOÁN & HÓA ĐƠN ---");
            System.out.println("1. Tạo hóa đơn mới");
            System.out.println("2. Xem danh sách hóa đơn");
            System.out.println("3. Xác nhận thu tiền (Thanh toán)");
            System.out.println("0. Quay lại menu chính");
            System.out.print("=> Chọn chức năng: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine());
                switch (luaChon) {
                    case 1:
                        xuLyTaoHoaDon();
                        break;
                    case 2:
                        hoaDonBLL.hienThiDanhSach();
                        break;
                    case 3:
                        xuLyThanhToan();
                        break;
                    case 0:
                        System.out.println("Quay lại menu chính...");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ!");
            }
        }
    }

    private void xuLyTaoHoaDon() {
        System.out.println("\n--- TẠO HÓA ĐƠN MỚI ---");
        System.out.print("Nhập mã hóa đơn: ");
        String maHD = scanner.nextLine();
        System.out.print("Nhập mã khách hàng: ");
        String maKH = scanner.nextLine();
        System.out.print("Nhập mã thợ sửa chữa: ");
        String maTho = scanner.nextLine();

        System.out.print("Nhập tổng tiền (VNĐ): ");
        try {
            double tongTien = Double.parseDouble(scanner.nextLine());
            hoaDonBLL.taoHoaDonMoi(maHD, maKH, maTho, tongTien);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Tổng tiền phải là một con số!");
        }
    }

    private void xuLyThanhToan() {
        System.out.print("\nNhập mã hóa đơn khách hàng vừa trả tiền: ");
        String maHD = scanner.nextLine();
        hoaDonBLL.thanhToanHoaDon(maHD);
    }
}