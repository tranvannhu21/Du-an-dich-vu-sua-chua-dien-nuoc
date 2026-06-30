package com.diennuoc.app.entity;
import java.io.Serializable;

public class ThoSuaChua implements Serializable {
    private static final long serialVersionUID = 1L;
    private String maSo;
    private String hoTen;
    private String soDienThoai;
    private String chuyenMon;
    private boolean sanSangLamViec;
    private boolean dangHoatDong;

    public ThoSuaChua(String maSo, String hoTen, String soDienThoai, String chuyenMon) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.chuyenMon = chuyenMon;
        this.sanSangLamViec = true;
        this.dangHoatDong = true;
    }

    public String getMaSo() {
        return maSo;
    }
    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }
    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public boolean isSanSangLamViec() {
        return sanSangLamViec;
    }
    public void setSanSangLamViec(boolean sanSangLamViec) {
        this.sanSangLamViec = sanSangLamViec;
    }

    public boolean isDangHoatDong() {
        return dangHoatDong;
    }
    public void setDangHoatDong(boolean dangHoatDong) {
        this.dangHoatDong = dangHoatDong;
    }

    @Override
    public String toString() {
        String trangThai = sanSangLamViec ? "Đang rảnh" : "Đang bận";
        return "Mã thợ: " + maSo + " | Tên: " + hoTen + " | SĐT: " + soDienThoai
                + " | Chuyên môn: " + chuyenMon + " | Trạng thái: " + trangThai;
    }
}