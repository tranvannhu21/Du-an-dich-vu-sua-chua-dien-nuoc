package com.diennuoc.app.bll;

import com.diennuoc.app.dao.HoaDonDAO;
import com.diennuoc.app.entity.HoaDon;
import java.util.List;

public class HoaDonBLL {
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();

    public void taoHoaDonMoi(String maHoaDon, String maKhachHang, String maTho, double tongTien) {
        if (maHoaDon.isEmpty() || maKhachHang.isEmpty() || maTho.isEmpty()) {
            System.out.println("Lỗi: Không được để trống các mã liên quan");
            return;
        }
        if (tongTien <= 0) {
            System.out.println("Lỗi: Tổng tiền thanh toán phải lớn hơn 0");
            return;
        }

        HoaDon hd = new HoaDon(maHoaDon, maKhachHang, maTho, tongTien, false);
        hoaDonDAO.themHoaDon(hd);
        System.out.println("-> Tạo hóa đơn thành công!");
    }

    public void hienThiDanhSach() {
        List<HoaDon> ds = hoaDonDAO.layDanhSach();
        if (ds.isEmpty()) {
            System.out.println("Chưa có hóa đơn nào trong hệ thống.");
        } else {
            System.out.println("Danh sách hóa đơn: ");
            for (HoaDon hd : ds) {
                System.out.println(hd.toString());
            }
        }
    }

    public void thanhToanHoaDon(String maHoaDon) {
        if (maHoaDon.isEmpty()) {
            System.out.println("Lỗi: Vui lòng nhập mã hóa đơn");
            return;
        }
        boolean thanhCong = hoaDonDAO.xacNhanThanhToan(maHoaDon);
        if (thanhCong) {
            System.out.println("-> Hóa đơn " + maHoaDon + " đã được thanh toán thành công");
        } else {
            System.out.println("-> Thất bại: Mã hóa đơn không tồn tại");
        }
    }
}