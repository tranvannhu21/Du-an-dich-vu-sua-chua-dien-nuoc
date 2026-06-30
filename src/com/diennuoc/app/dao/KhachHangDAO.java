package com.diennuoc.app.dao;

import com.diennuoc.app.entity.KhachHang;
import com.diennuoc.app.utils.DocGhiFile; // Import công cụ đọc ghi file
import java.util.List;

public class KhachHangDAO {
    private static final String TEN_FILE = "khachhang.dat";
    private static List<KhachHang> danhSachKhachHang = DocGhiFile.<KhachHang>docFile(TEN_FILE);
    public void themKhachHang(KhachHang kh) {
        danhSachKhachHang.add(kh);
        DocGhiFile.ghiFile(danhSachKhachHang, TEN_FILE);
    }

    public List<KhachHang> layDanhSach() {
        return danhSachKhachHang;
    }

    public boolean capNhatKhachHang(KhachHang khMoi) {
        for (int i = 0; i < danhSachKhachHang.size(); i++) {
            if (danhSachKhachHang.get(i).getMaSo().equals(khMoi.getMaSo())) {
                danhSachKhachHang.set(i, khMoi);
                // THÊM MỚI: Lưu lại ngay sau khi cập nhật
                DocGhiFile.ghiFile(danhSachKhachHang, TEN_FILE);
                return true;
            }
        }
        return false;
    }

    public boolean xoaKhachHang(String maSo) {
        boolean ketQua = danhSachKhachHang.removeIf(kh -> kh.getMaSo().equals(maSo));
        if (ketQua) {
            // THÊM MỚI: Lưu lại danh sách mới sau khi đã xóa
            DocGhiFile.ghiFile(danhSachKhachHang, TEN_FILE);
        }
        return ketQua;
    }
}