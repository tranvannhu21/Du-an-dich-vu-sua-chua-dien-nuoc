package com.diennuoc.app.entity;

import java.io.Serializable;

public class HoaDon implements Serializable {
    private static final long serialVersionUID = 1L;
    private String maHoaDon;
    private String maKhachHang;
    private String maTho;
    private double tongTien;
    private boolean daThanhToan;
    private String phuongThucThanhToan;

    public HoaDon() {}
    public HoaDon(String maHoaDon, String maKhachHang, String maTho, double tongTien, boolean daThanhToan) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maTho = maTho;
        this.tongTien = tongTien;
        this.daThanhToan = daThanhToan;
        this.phuongThucThanhToan = "Ví điện tử (MoMo)";
    }

    // --- Getters và Setters ---
    public String getMaHoaDon() {
        return maHoaDon;
    }
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }
    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaTho() {
        return maTho;
    }
    public void setMaTho(String maTho) {
        this.maTho = maTho;
    }

    public double getTongTien() {
        return tongTien;
    }
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isDaThanhToan() {
        return daThanhToan;
    }
    public void setDaThanhToan(boolean daThanhToan) {
        this.daThanhToan = daThanhToan;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }
    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    @Override
    public String toString() {
        String trangThai = daThanhToan ? "Đã thanh toán" : "Chưa thanh toán";
        return String.format("Mã HĐ: %-5s | Mã KH: %-5s | Mã Thợ: %-5s | Tổng tiền: %-9.0f | Trạng thái: %-15s | Cổng TT: %s",
                maHoaDon, maKhachHang, maTho, tongTien, trangThai, phuongThucThanhToan);
    }
}