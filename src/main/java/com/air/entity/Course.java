package com.air.entity;

import lombok.Data;


//课程
@Data
public class Course {
    private String Cno;
    private String Tno;//教师id
    private String Cname;//课程名称
    private String Cpno;//先修课
    private int Ccredit;//学分

    Course(){}
    Course(String cno,String tno,String cname,String cpno,int ccredit)
    {
        Cno=cno;
        Tno=tno;
        Cname=cname;
        Cpno=(cpno==""?null:cpno);
        Ccredit=ccredit;
    }
}
