package com.diennuoc.app.bll;

import com.diennuoc.app.dao.ThoSuaChuaDAO;
import com.diennuoc.app.entity.ThoSuaChua;
import java.util.List;

public class ThoSuaChuaBLL {
    private ThoSuaChuaDAO thoSuaChuaDAO = new ThoSuaChuaDAO();

    public void themMoiTho(String maSo, String hoTen, String soDienThoai, String chuyenMon) {
        if (maSo.isEmpty() || hoTen.isEmpty() || chuyenMon.isEmpty()) {
            System.out.println("Lỗi: Các trường thông tin không được để trống!");
            return;
        }
        ThoSuaChua tho = new ThoSuaChua(maSo, hoTen, soDienThoai, chuyenMon);
        thoSuaChuaDAO.themTho(tho);
        System.out.println("-> Thêm thợ sửa chữa thành công!");
    }

    public void hienThiDanhSach() {
        List<ThoSuaChua> ds = thoSuaChuaDAO.layDanhSachHoatDong();
        if (ds.isEmpty()) {
            System.out.println("Hệ thống hiện không có thợ nào đang hoạt động.");
        } else {
            System.out.println("--- DANH SÁCH THỢ ĐANG HOẠT ĐỘNG ---");
            for (ThoSuaChua tho : ds) {
                System.out.println(tho.toString());
            }
        }
    }

    public void capNhatThongTin(String maSo, String hoTenMoi, String soDienThoaiMoi, String chuyenMonMoi) {
        if (maSo.isEmpty()) {
            System.out.println("Lỗi: Mã thợ không được để trống!");
            return;
        }
        ThoSuaChua thoMoi = new ThoSuaChua(maSo, hoTenMoi, soDienThoaiMoi, chuyenMonMoi);
        boolean thanhCong = thoSuaChuaDAO.capNhatTho(thoMoi);

        if (thanhCong) {
            System.out.println("-> Cập nhật thành công thông tin thợ mã: " + maSo);
        } else {
            System.out.println("-> Thất bại: Không tìm thấy thợ hoặc thợ đã nghỉ việc!");
        }
    }

    public void choNghiViec(String maSo) {
        if (maSo.isEmpty()) {
            System.out.println("Lỗi: Mã thợ không được để trống!");
            return;
        }
        boolean thanhCong = thoSuaChuaDAO.xoaMemTho(maSo);

        if (thanhCong) {
            System.out.println("-> Đã chuyển trạng thái thợ mã " + maSo + " thành ĐÃ NGHỈ VIỆC.");
        } else {
            System.out.println("-> Thất bại: Không tìm thấy thợ hoặc thợ đã nghỉ từ trước!");
        }
    }
}