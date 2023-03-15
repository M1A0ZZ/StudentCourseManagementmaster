package com.air.dao;

import com.air.entity.SC;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface SCDao {
    @Insert("insert into sc (Sno,Cno) values (#{Sno},#{Cno})")
    void insert(SC sc);
    @Delete("delete from sc where Cno=#{Cno} and Sno=#{Sno}")
    void delete(SC sc);
    @Update("update sc set Grade=#{Grade} where Sno=#{Sno} and Cno=#{Cno}")
    void update(SC sc);

    @Select("select * from sc where Cno=$(Cno) and Sno=$(Sno)")
    SC  findById(String Sno,String Cno);
    @Select("select * from sc")
    List<SC> findAll();
    @Select("select c.Cno cno,c.Cname cname,t.Tname tname,c.Ccredit ccredit,c.Cpname cpname,t.Tdept tdept, sc.Grade grade " +
            "from (select c1.Cno,c1.Cname,c1.Tno,c1.Ccredit,c2.Cname Cpname from course c1 left outer join course c2 on (c1.cpno=c2.cno)) as c,teacher t,sc " +
            "where sc.Sno=${Sno} and c.Cno=sc.Cno and t.Tno=c.Tno")
    List<Map<String,Object>> findMyCourse(String Sno);
}
