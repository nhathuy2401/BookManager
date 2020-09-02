package com.example.book.Dulieu;

public class Hoadonchitiet {
    private int maHDCT;
    private Hoadon hoaDon;
    private Sach sach;
    private int soLuongMua;
    public Hoadonchitiet() {
    }
    public Hoadonchitiet(int maHDCT, Hoadon hoaDon, Sach sach, int soLuongMua) {
        this.maHDCT = maHDCT;
        this.hoaDon = hoaDon;
        this.sach = sach;
        this.soLuongMua = soLuongMua;
    }
    public int getMaHDCT() {
        return maHDCT;
    }
    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }
    public Hoadon getHoaDon() {
        return hoaDon;
    }
    public void setHoaDon(Hoadon hoaDon) {
        this.hoaDon = hoaDon;
    }
    public Sach getSach() {
        return sach;
    }
    public void setSach(Sach sach) {
        this.sach = sach;
    }
    public int getSoLuongMua() {
        return soLuongMua;
    }
    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }
    @Override
    public String toString() {
        return "HoaDonChiTiet{" +
                "maHDCT=" + maHDCT +
                ", hoaDon=" + hoaDon.toString() +
                ", sach=" + sach.toString() +
                ", soLuongMua=" + soLuongMua +
                '}';
    }
}
