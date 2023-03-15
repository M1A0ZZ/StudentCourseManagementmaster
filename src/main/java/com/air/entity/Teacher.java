package com.air.entity;

import lombok.Data;

import javax.swing.text.html.HTML;
import java.util.Date;

//教师
@Data
public class Teacher {
    private String Tno;
    private String Tname;//姓名
    private String Tpassword;//密码
    private String Tsex;//性别
    private String Tage;
    private String Tdept;//学院
    public Teacher(){}
    public Teacher(String loginName,String name,String password,String sex,String age,String dept)
    {
        Tno=loginName;
        Tname=name;
        Tpassword=password;
        Tsex=sex;
        Tage=age;
        Tdept=dept;
    }
}
