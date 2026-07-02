package com.diennuoc.app.utils;

import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);

    // Dùng cái này thay cho scanner.nextLine() ở mọi chỗ nhập số
    public static int nhapSoNguyen(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng chỉ nhập số nguyên!");
            }
        }
    }
}