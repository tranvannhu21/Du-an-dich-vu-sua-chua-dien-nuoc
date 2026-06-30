package com.diennuoc.app.entity;

import java.io.Serializable;

// Thêm implements Serializable ở ngay lớp chính
public class KhachHang implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String maSo;
    protected String hoTen;
    protected String soDienThoai;
    protected int diemTichLuy;

    // Constructor
    public KhachHang(String maSo, String hoTen, String soDienThoai, int diemTichLuy) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diemTichLuy = diemTichLuy;
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

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }
}