/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author An Dong PC
 */
public class Grade {
    private int iD;
    private String maSV;
    private int tiengAnh, tinHoc, gDTC;
    private Student stu;

    public Grade() {
    }

    public Grade(int iD, String maSV, int tiengAnh, int tinHoc, int gDTC, Student stu) {
        this.iD = iD;
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.gDTC = gDTC;
        this.stu = stu;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(int tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public int getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(int tinHoc) {
        this.tinHoc = tinHoc;
    }

    public int getgDTC() {
        return gDTC;
    }

    public void setgDTC(int gDTC) {
        this.gDTC = gDTC;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }
    public int getDiemTB(){
        int diemTB=(this.getTiengAnh()+this.getTinHoc()+this.getgDTC())/3;
        return diemTB;
    }
    

}
