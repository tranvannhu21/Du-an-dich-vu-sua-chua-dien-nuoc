package com.diennuoc.app.bll;

import com.diennuoc.app.dao.KhachHangDAO;
import com.diennuoc.app.entity.KhachHang;
import java.util.List;

public class KhachHangBLL {
    private KhachHangDAO khachHangDAO = new KhachHangDAO();

    public void themMoiKhachHang(String maSo, String hoTen, String soDienThoai ) {
        if (maSo.isEmpty() || hoTen.isEmpty()) {
            System.out.println("Lỗi: Mã số và Họ tên không được để trống!");
            return;
        }
        if (soDienThoai.length() < 10) {
            System.out.println("Lỗi: Số điện thoại không hợp lệ!");
            return;
        }
        KhachHang kh = new KhachHang(maSo, hoTen, soDienThoai);
        khachHangDAO.themKhachHang(kh);
        System.out.println("-> Thêm khách hàng thành công!");
    }

    public void hienThiDanhSach() {
        List<KhachHang> ds = khachHangDAO.layDanhSach();
        if (ds.isEmpty()) {
            System.out.println("Danh sách khách hàng đang trống.");
        } else {
            System.out.println("Danh sách khách hàng:");
            for (KhachHang kh : ds) {
                System.out.println(kh.toString());
            }
        }
    }
    public void capNhatKhachHang(String maSo, String hoTenMoi, String soDienThoaiMoi) {
        if (maSo.isEmpty()) {
            System.out.println("Lỗi: Vui lòng nhập mã khách hàng cần sửa!");
            return;
        }
        if (hoTenMoi.isEmpty() || soDienThoaiMoi.length() < 10) {
            System.out.println("Lỗi: Dữ liệu cập nhật không hợp lệ (Tên trống hoặc SĐT quá ngắn)!");
            return;
        }
        KhachHang khMoi = new KhachHang(maSo, hoTenMoi, soDienThoaiMoi);
        boolean thanhCong = khachHangDAO.capNhatKhachHang(khMoi);
        if (thanhCong) {
            System.out.println("-> Cập nhật thành công thông tin khách hàng mã: " + maSo);
        } else {
            System.out.println("-> Thất bại: Không tìm thấy khách hàng mang mã " + maSo + " trong hệ thống!");
        }
    }

    public void xoaKhachHang(String maSo) {
        if (maSo.isEmpty()) {
            System.out.println("Lỗi: Vui lòng cung cấp mã khách hàng cần xóa!");
            return;
        }
        boolean thanhCong = khachHangDAO.xoaKhachHang(maSo);
        if (thanhCong) {
            System.out.println("-> Đã xóa vĩnh viễn khách hàng mã: " + maSo);
        } else {
            System.out.println("-> Thất bại: Mã " + maSo + " không tồn tại để xóa!");
        }
    }
}