package com.diennuoc.app.dao;

import com.diennuoc.app.entity.HoaDon;
import com.diennuoc.app.utils.FileHandler;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class HoaDonDAO {
    private static final Path FILE_PATH = Paths.get("hoadon.csv");

    // Quy tắc Ghi CSV
    private static final Function<HoaDon, String> toCsv = hd ->
            hd.getMaHoaDon() + "," + hd.getMaKhachHang() + "," + hd.getMaTho() + "," +
                    hd.getTongTien() + "," + hd.isDaThanhToan() + "," + hd.getPhuongThucThanhToan();

    // Quy tắc Đọc CSV
    private static final Function<String, HoaDon> fromCsv = line -> {
        String[] parts = line.split(",");
        HoaDon hd = new HoaDon(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), Boolean.parseBoolean(parts[4]));
        if (parts.length > 5) {
            hd.setPhuongThucThanhToan(parts[5]);
        }
        return hd;
    };

    // Tự động load dữ liệu
    private static List<HoaDon> danhSachHoaDon = loadData();

    private static List<HoaDon> loadData() {
        if (Files.exists(FILE_PATH)) {
            try {
                return FileHandler.readFromCsv(FILE_PATH, fromCsv);
            } catch (IOException e) {
                System.out.println("Lỗi đọc file hóa đơn: " + e.getMessage());
            }
        }
        return new ArrayList<>();
    }

    private void saveData() {
        try {
            FileHandler.writeToCsv(FILE_PATH, danhSachHoaDon, toCsv);
        } catch (IOException e) {
            System.out.println("Lỗi lưu file hóa đơn: " + e.getMessage());
        }
    }

    // --- CÁC HÀM NGHIỆP VỤ DAO ---
    public void themHoaDon(HoaDon hd) {
        danhSachHoaDon.add(hd);
        saveData();
    }

    public List<HoaDon> layDanhSach() {
        return danhSachHoaDon;
    }

    public boolean xacNhanThanhToan(String maHoaDon) {
        for (HoaDon hd : danhSachHoaDon) {
            if (hd.getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                hd.setDaThanhToan(true);
                saveData();
                return true;
            }
        }
        return false;
    }
}