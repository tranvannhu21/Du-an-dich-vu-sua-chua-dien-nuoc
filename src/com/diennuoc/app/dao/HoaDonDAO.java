package com.diennuoc.app.dao;

import com.diennuoc.app.entity.HoaDon;
import com.diennuoc.app.utils.DocGhiFile; // Import công cụ
import java.util.List;

public class HoaDonDAO {
    private static final String TEN_FILE = "hoadon.dat";
    private static List<HoaDon> danhSachHoaDon = DocGhiFile.<HoaDon>docFile(TEN_FILE);

    public void themHoaDon(HoaDon hd) {
        danhSachHoaDon.add(hd);
        DocGhiFile.ghiFile(danhSachHoaDon, TEN_FILE);
    }

    public List<HoaDon> layDanhSach() {
        return danhSachHoaDon;
    }

    public boolean xacNhanThanhToan(String maHoaDon) {
        for (HoaDon hd : danhSachHoaDon) {
            if (hd.getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                hd.setDaThanhToan(true);
                DocGhiFile.ghiFile(danhSachHoaDon, TEN_FILE);
                return true;
            }
        }
        return false;
    }
}