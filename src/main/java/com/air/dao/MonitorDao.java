package com.air.dao;

import com.air.entity.Monitor;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MonitorDao {
    @Insert("insert monitor(Mno,Mpassword) values(#{Mno},#{Mpassword})")
    void save(Monitor monitor);
    @Delete("delete from monitor where Mno = #{Mno} ")
    void delete(String Mno);
    @Update("update monitor set Mno=${Mno},Mpassword=#{Mpassword} where Mno=#{Mno}")
    void update(Monitor monitor);

    @Select("select * from monitor where Mno = #{Mno} ")
    Monitor findById(String Mno);
    @Select("select * from monitor where Mno = #{Mno} and Mpassword=#{Mpassword}")
    Monitor findMonitor(Monitor user);
    @Select("select * from monitor ")
    List<Monitor> findAll();
}
