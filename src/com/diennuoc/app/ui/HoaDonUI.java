package com.diennuoc.app.ui;

import com.diennuoc.app.bll.HoaDonBLL;
import java.util.Scanner;

public class HoaDonUI {
    private HoaDonBLL hoaDonBLL = new HoaDonBLL();
    private Scanner scanner = new Scanner(System.in, "UTF-8");

    public void hienThiMenu() {
        int luaChon = -1;
        while (luaChon != 0) {
            System.out.println("\nHóa đơn & thanh toán: ");
            System.out.println("1. Tạo hóa đơn mới");
            System.out.println("2. Xem danh sách hóa đơn");
            System.out.println("3. Xác nhận thanh toán");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");

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
                        System.out.println("Quay lại menu chính");
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
        System.out.println("\nTạo hóa đơn mới");
        System.out.print("Nhập mã hóa đơn: ");
        String maHD = scanner.nextLine();
        System.out.print("Nhập mã khách hàng: ");
        String maKH = scanner.nextLine();
        System.out.print("Nhập mã thợ sửa chữa: ");
        String maTho = scanner.nextLine();

        System.out.print("Nhập số tiền thanh toán: ");
        try {
            double tongTien = Double.parseDouble(scanner.nextLine());
            hoaDonBLL.taoHoaDonMoi(maHD, maKH, maTho, tongTien);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi:Tiền thanh toán phải là một số!");
        }
    }

    private void xuLyThanhToan() {
        System.out.print("\nNhập mã hóa đơn khách hàng vừa trả tiền: ");
        String maHD = scanner.nextLine();
        hoaDonBLL.thanhToanHoaDon(maHD);
    }
}