package com.diennuoc.app.entity;

import java.io.Serializable;

// Thêm implements Serializable ở ngay lớp chính
public class KhachHang implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String maSo;
    protected String hoTen;
    protected String soDienThoai;

    // Constructor
    public KhachHang(String maSo, String hoTen, String soDienThoai) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
    }

    // --- Getters và Setters ---
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
}