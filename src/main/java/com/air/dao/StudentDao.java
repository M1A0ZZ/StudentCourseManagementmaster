package com.air.dao;

import com.air.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentDao {
    @Insert("insert into student values (#{Sno},#{Spassword},#{Sname},#{Ssex},#{Sage},#{Sdept})")
    void save(Student student);
    @Delete("delete from student where Sno=${Sno}")
    void delete(String Sno);
    @Update("update student set Sname=#{Sname},Spassword=#{Spassword},Sage=#{Sage},Ssex=#{Ssex},Sdept=#{Sdept} where Sno=#{Sno}")
    void update(Student student);

    @Select("select * from student where Sno=${Sno}")
    // TODO Sno=no_error?${Sno}:#{Sno}
    Student findById(String Sno);
    @Select("select * from student where Sno=#{Sno} and Spassword=#{Spassword}")
    Student findStudent(Student student);
    @Select("select * from student")
    List<Student> findAll();
    @Select("select * from student where Sname like '%${pattern}%'")
    List<Student> getByStudentName(String pattern);
    @Select("select * from student ${cond}")
    List<Student> findByCond(String cond);
}
