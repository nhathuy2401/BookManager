package com.example.book.Dulieu;

import java.util.Date;

public class Hoadon {
    private String maHoaDon;
    private Date ngayMua;
    public Hoadon() {
    }
    public Hoadon(String maHoaDon, Date ngayMua) {
        this.maHoaDon = maHoaDon;
        this.ngayMua = ngayMua;
    }
    public String getMaHoaDon() {
        return maHoaDon;
    }
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    public Date getNgayMua() {
        return ngayMua;
    }
    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }
}
