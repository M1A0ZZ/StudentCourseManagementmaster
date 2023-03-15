package com.air.dao;


import com.air.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface CourseDao {
    @Insert("insert into course values (#{Cno},#{Tno},#{Cname},#{Cpno},#{Ccredit})")
    void save(Course course);
    @Insert("insert into course (Cno,Tno,Cname,Ccredit) values (#{Cno},#{Tno},#{Cname},#{Ccredit})")
    void save2(Course course);
    @Delete("delete from course where Cno=#{Cno} and Tno=#{Tno}")
    void delete(Course course);
    @Update("update course set Cname=#{Cname},Cpno=#{Cpno},Ccredit=#{Ccredit} where Cno=#{Cno} and Tno=#{Tno}")
    void update(Course course);
    @Update("update course set Cname=#{Cname},Ccredit=#{Ccredit} where Cno=#{Cno} and Tno=#{Tno}")
    void update2(Course course);

    @Select("select Cno,Cname,Tname,Ccredit from course,teacher where Cno=${Cno} and teacher.Tno=course.Tno")
    Map<String,Object> findById(String Cno);
    @Select("select * from course")
    List<Course > findAll();
    @Select("select Cno cno,Cname cname,Tname tname,Ccredit ccredit,Cpname cpname,Tdept tdept "
        +"from (select c1.Cno,c1.Cname,c1.Tno,c1.Ccredit,c2.Cname Cpname from course c1 left outer join course c2 on (c1.cpno=c2.cno)) as c,teacher t "
                +"where c.Tno=t.Tno"
                )
    List<Map<String,Object>> findAll2();//注意此返回值的方式很好用！！！
    @Select("select Cno cno,Cname cname,Tno tno,Ccredit ccredit,Cpno cpno,Tdept tdept "
            +"from course c,teacher t "
            +"where c.Tno=t.Tno"
    )
    List<Map<String,Object>> findAll3();//注意此返回值的方式很好用！！！
}
