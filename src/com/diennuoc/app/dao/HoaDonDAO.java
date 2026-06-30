package com.diennuoc.app.dao;

import com.diennuoc.app.entity.HoaDon;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO {
    private static final List<HoaDon> danhSachHoaDon = new ArrayList<>();

    public void themHoaDon(HoaDon hd) {
        danhSachHoaDon.add(hd);
    }

    public List<HoaDon> layDanhSach() {
        return danhSachHoaDon;
    }

    public boolean xacNhanThanhToan(String maHoaDon) {
        for (HoaDon hd : danhSachHoaDon) {
            if (hd.getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                hd.setDaThanhToan(true);
                return true;
            }
        }
        return false;
    }
}