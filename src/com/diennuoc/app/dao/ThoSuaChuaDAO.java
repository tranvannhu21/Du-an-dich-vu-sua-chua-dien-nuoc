package com.diennuoc.app.dao;

import com.diennuoc.app.entity.ThoSuaChua;
import com.diennuoc.app.utils.DocGhiFile; // Import công cụ
import java.util.List;

public class ThoSuaChuaDAO {
    private static final String TEN_FILE = "thosuachua.dat";
    private static List<ThoSuaChua> danhSachTho = DocGhiFile.<ThoSuaChua>docFile(TEN_FILE);

    public void themTho(ThoSuaChua tho) {
        danhSachTho.add(tho);
        DocGhiFile.ghiFile(danhSachTho, TEN_FILE);
    }

    public List<ThoSuaChua> layDanhSachHoatDong() {
        java.util.ArrayList<ThoSuaChua> dsHoatDong = new java.util.ArrayList<>();
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
                DocGhiFile.ghiFile(danhSachTho, TEN_FILE);
                return true;
            }
        }
        return false;
    }

    public boolean xoaMemTho(String maSo) {
        for (ThoSuaChua tho : danhSachTho) {
            if (tho.getMaSo().equals(maSo) && tho.isDangHoatDong()) {
                tho.setDangHoatDong(false);
                DocGhiFile.ghiFile(danhSachTho, TEN_FILE);
                return true;
            }
        }
        return false;
    }
}