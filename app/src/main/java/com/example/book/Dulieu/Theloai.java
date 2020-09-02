package com.example.book.Dulieu;

public class Theloai {
    private String maTheloai;
    private String tenTheloai;
    private String moTa;
    private String viTri;
    public Theloai() {
    }
    public Theloai(String maTheloai, String tenTheloai, String moTa,String viTri) {
        this.maTheloai = maTheloai;
        this.tenTheloai = tenTheloai;
        this.moTa = moTa;
        this.viTri = viTri;
    }
    public String getMaTheloai() {
        return maTheloai;
    }
    public void setMaTheloai(String maTheloai) {
        this.maTheloai = maTheloai;
    }
    public String getTenTheloai() {
        return tenTheloai;
    }
    public void setTenTheloai(String tenTheloai) {
        this.tenTheloai = tenTheloai;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    public String getViTri() {
        return viTri;
    }
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    @Override
    public String toString() {
        return getMaTheloai()+" | "+getTenTheloai();
    }
}