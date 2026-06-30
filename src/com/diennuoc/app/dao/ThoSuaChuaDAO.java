package com.diennuoc.app.dao;

import com.diennuoc.app.entity.ThoSuaChua;
import java.util.ArrayList;
import java.util.List;

public class ThoSuaChuaDAO {
    private List<ThoSuaChua> danhSachTho = new ArrayList<>();

    // CREATE
    public void themTho(ThoSuaChua tho) {
        danhSachTho.add(tho);
    }

    // READ: Chỉ lấy danh sách những thợ CÒN ĐANG HOẠT ĐỘNG (Chưa nghỉ việc)
    public List<ThoSuaChua> layDanhSachHoatDong() {
        List<ThoSuaChua> dsHoatDong = new ArrayList<>();
        for (ThoSuaChua tho : danhSachTho) {
            if (tho.isDangHoatDong()) {
                dsHoatDong.add(tho);
            }
        }
        return dsHoatDong;
    }

    // UPDATE
    public boolean capNhatTho(ThoSuaChua thoMoi) {
        for (int i = 0; i < danhSachTho.size(); i++) {
            ThoSuaChua thoHienTai = danhSachTho.get(i);
            // Chỉ cập nhật nếu đúng mã và thợ đó chưa nghỉ việc
            if (thoHienTai.getMaSo().equals(thoMoi.getMaSo()) && thoHienTai.isDangHoatDong()) {
                // Giữ lại trạng thái làm việc hiện tại, chỉ cập nhật thông tin
                thoMoi.setSanSangLamViec(thoHienTai.isSanSangLamViec());
                danhSachTho.set(i, thoMoi);
                return true;
            }
        }
        return false;
    }

    // DELETE (Soft Delete - Chuyển trạng thái sang Đã nghỉ việc)
    public boolean xoaMemTho(String maSo) {
        for (ThoSuaChua tho : danhSachTho) {
            if (tho.getMaSo().equals(maSo) && tho.isDangHoatDong()) {
                tho.setDangHoatDong(false); // Đánh dấu là đã nghỉ việc
                return true;
            }
        }
        return false;
    }
}