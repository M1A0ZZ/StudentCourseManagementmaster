package com.air.dao;

import com.air.entity.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface TeacherDao {
    @Insert("insert into teacher values (#{Tno},#{Tpassword},#{Tname},#{Tsex},#{Tage},#{Tdept})")
    void save(Teacher teacher);
    @Delete("delete from teacher where Tno=#{Tno}")
    void delete(String Tno);
    @Update("update teacher set Tno=#{Tno},Tname=#{Tname},Tpassword=#{Tpassword},Tsex=#{Tsex},Tage=#{Tage},Tdept=#{Tdept} where Tno=#{Tno}")
    void update(Teacher teacher);

    @Select("select * from teacher where Tno=#{Tno}")
    Teacher findById(String Tno);
    @Select("select * from teacher where Tno=#{Tno} and Tpassword=#{Tpassword}")
    Teacher findTeacher(Teacher teacher);
    @Select("select * from teacher")
    List<Teacher> findAll();
    @Select("select * from teacher where Tname like '%${teacherName}%'")
    // FIXME 此处的模式串改为 '%#{teacherName}%' 就会报错,个人猜测是javaType 和 jdbcType 冲突的原因
    // 具体待解决
    List<Teacher> getByTeacherName(String teacherName);
    @Select("select * from teacher ${cond}")
    List<Teacher> findByCond(String cond);
//    # 根据教师号查询课程号
//    # 再根据课程号查询学号
//    # 再返回相应值
//    # Sno,Sname,Cno,Cname,Sdept,Sage,Ssex,Grade
//    # 嵌套查询，先查出cno，再查sno，再查对应属性
//    # Tno+course->c.Cno,c.Cname
//    # c.Cno+sc->sc.Sno,sc.Grade
//    # sc.Sno+student->s.Sname,S.dept,s.Sage,s.sSex
//    select s.Sno,s.Sname,c.Cno,c.Cname,s.Sage,s.Ssex,s.Sdept,sac.Grade
//    from (select Sno,Cno,Grade from sc where Cno in (select Cno from course c where Tno='01001')) as sac,student s,course c
//    where s.Sno=sac.Sno and c.Cno=sac.Cno;
    @Select("select s.Sno,s.Sname,c.Cno,c.Cname,s.Sage,s.Ssex,s.Sdept,sac.Grade " +
            "from (select Sno,Cno,Grade from sc where Cno in (select Cno from course c where Tno=${Tno})) as sac,student s,course c " +
            "where s.Sno=sac.Sno and c.Cno=sac.Cno;")
    //TODO
    List<Map<String,Object>> getMyStudent(String Tno);

}
