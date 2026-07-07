package com.diennuoc.app.dao;

import com.diennuoc.app.entity.KhachHang;
import com.diennuoc.app.utils.FileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class KhachHangDAO {
    // 1. Tên file CSV
    private static final Path FILE_PATH = Paths.get("khachhang.csv");

    // 2. Quy tắc GHI: Biến đối tượng KhachHang thành 1 dòng chữ (CSV)
    private static final Function<KhachHang, String> toCsv = kh ->
            kh.getMaSo() + "," + kh.getHoTen() + "," + kh.getSoDienThoai();

    // 3. Quy tắc ĐỌC: Cắt dòng chữ (CSV) lắp lại thành đối tượng KhachHang
    private static final Function<String, KhachHang> fromCsv = line -> {
        String[] parts = line.split(",");
        return new KhachHang(parts[0], parts[1], parts[2]);
    };

    // 4. Load dữ liệu tự động khi khởi động
    private static List<KhachHang> danhSachKhachHang = loadData();

    private static List<KhachHang> loadData() {
        if (Files.exists(FILE_PATH)) { // Chỉ đọc nếu file đã tồn tại
            try {
                return FileHandler.readFromCsv(FILE_PATH, fromCsv);
            } catch (IOException e) {
                System.out.println("Lỗi đọc file CSV: " + e.getMessage());
            }
        }
        return new ArrayList<>(); // Nếu chưa có file thì trả về danh sách rỗng
    }

    // Hàm tiện ích hỗ trợ lưu file để code gọn hơn
    private void saveData() {
        try {
            FileHandler.writeToCsv(FILE_PATH, danhSachKhachHang, toCsv);
        } catch (IOException e) {
            System.out.println("Lỗi lưu file CSV: " + e.getMessage());
        }
    }

    // --- CÁC HÀM NGHIỆP VỤ DAO ---

    public void themKhachHang(KhachHang kh) {
        danhSachKhachHang.add(kh);
        saveData();
    }

    public List<KhachHang> layDanhSach() {
        return danhSachKhachHang;
    }

    public boolean capNhatKhachHang(KhachHang khMoi) {
        for (int i = 0; i < danhSachKhachHang.size(); i++) {
            if (danhSachKhachHang.get(i).getMaSo().equals(khMoi.getMaSo())) {
                danhSachKhachHang.set(i, khMoi);
                saveData();
                return true;
            }
        }
        return false;
    }

    public boolean xoaKhachHang(String maSo) {
        boolean ketQua = danhSachKhachHang.removeIf(kh -> kh.getMaSo().equals(maSo));
        if (ketQua) {
            saveData();
        }
        return ketQua;
    }
}