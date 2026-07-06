package com.diennuoc.app.dao;

import com.diennuoc.app.entity.ThoSuaChua;
import com.diennuoc.app.utils.FileHandler;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ThoSuaChuaDAO {
    private static final Path FILE_PATH = Paths.get("thosuachua.csv");

    // Quy tắc Ghi CSV
    private static final Function<ThoSuaChua, String> toCsv = tho ->
            tho.getMaSo() + "," + tho.getHoTen() + "," + tho.getSoDienThoai() + "," +
                    tho.getChuyenMon() + "," + tho.isSanSangLamViec() + "," + tho.isDangHoatDong();

    // Quy tắc Đọc CSV
    private static final Function<String, ThoSuaChua> fromCsv = line -> {
        String[] parts = line.split(",");
        ThoSuaChua tho = new ThoSuaChua(parts[0], parts[1], parts[2], parts[3]);
        // Phục hồi lại trạng thái boolean từ file
        tho.setSanSangLamViec(Boolean.parseBoolean(parts[4]));
        tho.setDangHoatDong(Boolean.parseBoolean(parts[5]));
        return tho;
    };

    // Tự động load dữ liệu
    private static List<ThoSuaChua> danhSachTho = loadData();

    private static List<ThoSuaChua> loadData() {
        if (Files.exists(FILE_PATH)) {
            try {
                return FileHandler.readFromCsv(FILE_PATH, fromCsv);
            } catch (IOException e) {
                System.out.println("Lỗi đọc file thợ: " + e.getMessage());
            }
        }
        return new ArrayList<>();
    }

    private void saveData() {
        try {
            FileHandler.writeToCsv(FILE_PATH, danhSachTho, toCsv);
        } catch (IOException e) {
            System.out.println("Lỗi lưu file thợ: " + e.getMessage());
        }
    }

    // --- CÁC HÀM NGHIỆP VỤ DAO ---
    public void themTho(ThoSuaChua tho) {
        danhSachTho.add(tho);
        saveData();
    }

    public List<ThoSuaChua> layDanhSachHoatDong() {
        List<ThoSuaChua> dsHoatDong = new ArrayList<>();
        for (ThoSuaChua tho : danhSachTho) {
            if (tho.isDangHoatDong()) {
                dsHoatDong.add(tho);
            }
        }
        return dsHoatDong;
    }

    public boolean capNhatTho(ThoSuaChua thoMoi) {
        for (int i = 0; i < danhSachTho.size(); i++) {
            ThoSuaChua thoHienTai = danhSachTho.get(i);
            if (thoHienTai.getMaSo().equals(thoMoi.getMaSo()) && thoHienTai.isDangHoatDong()) {
                thoMoi.setSanSangLamViec(thoHienTai.isSanSangLamViec());
                danhSachTho.set(i, thoMoi);
                saveData();
                return true;
            }
        }
        return false;
    }

    public boolean xoaMemTho(String maSo) {
        for (ThoSuaChua tho : danhSachTho) {
            if (tho.getMaSo().equals(maSo) && tho.isDangHoatDong()) {
                tho.setDangHoatDong(false);
                saveData();
                return true;
            }
        }
        return false;
    }
}