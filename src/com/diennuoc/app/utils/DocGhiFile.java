package com.diennuoc.app.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {

    // Hàm Ghi dữ liệu xuống file (dùng <?> để nhận mọi loại danh sách)
    public static void ghiFile(List<?> danhSach, String tenFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tenFile))) {
            oos.writeObject(danhSach);
        } catch (Exception e) {
            System.out.println("Lỗi khi lưu file " + tenFile + ": " + e.getMessage());
        }
    }

    // Hàm Đọc dữ liệu từ file lên (dùng <T> để trả về đúng kiểu cần thiết)
    @SuppressWarnings("unchecked")
    public static <T> List<T> docFile(String tenFile) {
        List<T> danhSach = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tenFile))) {
            danhSach = (List<T>) ois.readObject();
        } catch (Exception e) {
        }
        return danhSach;
    }
}