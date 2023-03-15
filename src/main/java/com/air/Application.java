package com.air;

import com.air.dao.*;
import com.air.entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void test1_databaseTest() throws IOException {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 3. 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // 4. 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 5. 执行SqlSession对象执行查询，获取结果User
        MonitorDao md=sqlSession.getMapper(MonitorDao.class);
        Monitor m=md.findById("admin");
        System.out.println("print monitor : "+m);

        StudentDao sd=sqlSession.getMapper(StudentDao.class);
        List<Student> arr0=sd.findAll();
        for(Student i:arr0)System.out.println("Student : "+i);

        TeacherDao td=sqlSession.getMapper(TeacherDao.class);
        List<Teacher> arr=td.findAll();
        for(Teacher i:arr)System.out.println("teacher : "+i);
        td.save(new Teacher("1","1","1","1","1","1"));

        CourseDao cd=sqlSession.getMapper(CourseDao.class);
        List<Course> arr2=cd.findAll();
        for(Course i:arr2)System.out.println("course : "+i);

        SCDao scd=sqlSession.getMapper(SCDao.class);
        List<SC> arr3=scd.findAll();
        for(SC i:arr3)System.out.println("sc : "+i);

        // 6. 释放资源
        sqlSession.close();
    }


    public static void main(String[] args) throws IOException {

        test1_databaseTest();


    }
}
