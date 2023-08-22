/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Grade;
import java.util.List;

/**
 *
 * @author An Dong PC
 */
public class GradeDAO {
    GradeRES res=new GradeRES();
    
    public List<Grade> getAll(){
        return res.getAll();
    }
    public int Add(Grade gr){
        return res.Add(gr);
    }

    public int checkMaSV(String maSV){
        return res.checkMaSV(maSV);
    }
    public int checkMaSVInStudent(String maSV){
        return res.checkMaSVInStudent(maSV);
    }
    public int delete(String maSV){
        return res.delete(maSV);
    }
    public Grade timMaSVInGrade(String maSV){
        return res.timMaSVInGrade(maSV);
    }
    public int update(Grade gr){
        return res.update(gr);
    }
    public List<Grade> getAll1(){
        return res.getAll1();
    }
}
