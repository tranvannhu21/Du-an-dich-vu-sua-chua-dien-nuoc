package com.diennuoc.app.dao;

import com.diennuoc.app.entity.KhachHang;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {
    // Dùng ArrayList làm Database giả lập
    private List<KhachHang> danhSachKhachHang = new ArrayList<>();

    // CREATE: Thêm khách hàng mới
    public void themKhachHang(KhachHang kh) {
        danhSachKhachHang.add(kh);
    }

    // READ: Lấy toàn bộ danh sách
    public List<KhachHang> layDanhSach() {
        return danhSachKhachHang;
    }

    // UPDATE: Cập nhật thông tin dựa trên Mã số
    public boolean capNhatKhachHang(KhachHang khMoi) {
        for (int i = 0; i < danhSachKhachHang.size(); i++) {
            if (danhSachKhachHang.get(i).getMaSo().equals(khMoi.getMaSo())) {
                danhSachKhachHang.set(i, khMoi);
                return true; // Cập nhật thành công
            }
        }
        return false; // Không tìm thấy
    }

    // DELETE: Xóa khách hàng (Xóa cứng)
    public boolean xoaKhachHang(String maSo) {
        return danhSachKhachHang.removeIf(kh -> kh.getMaSo().equals(maSo));
    }
}