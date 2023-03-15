package com.air.entity;

import lombok.Data;

//学生
@Data
public class Student {
    private String Sno;
    private String Sname;//姓名
    private String Spassword;//密码
    private String Ssex;//性别
    private String Sage;//年龄
    private String Sdept;//学院
    public Student(){}
    public Student(String studentNumber,String name,String age,String password,String sex,String dept)
    {
        Sno=studentNumber;
        Sname=name;
        Spassword=password;
        Ssex=sex;
        Sage=age;
        Sdept=dept;
    }
}
