/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Student;
import java.util.List;

/**
 *
 * @author An Dong PC
 */
public class StudentDAO {
    StudentRes res=new StudentRes();
    public List<Student> getAll() {
        return res.getAll();
    }
    public int Add(Student st){
        return res.Add(st);
    }
    public int Update(Student st){
        return res.Update(st);
    }
    public int delete(String maSV){
        return res.delete(maSV);
    }
    public int checkMaSV(String maSV){
        return res.checkMaSV(maSV);
    }
}
