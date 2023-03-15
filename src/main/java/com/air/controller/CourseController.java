package com.air.controller;


import com.air.dao.CourseDao;
import com.air.dao.TeacherDao;
import com.air.entity.Course;
import com.air.entity.Teacher;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseDao courseDao;

    @RequestMapping(value = "/findById",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String findById(@RequestBody String id)
    {
        System.out.println("ret-------"+id);
        String ret=JSON.toJSONString(courseDao.findById(id));
        System.out.println("ret-------"+ret);
        return ret;
    }
    @RequestMapping(value = "/getAll2",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getAll2()
    {
        return JSON.toJSONString(courseDao.findAll2());
    }
    @RequestMapping(value = "/getAll",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getAll()
    {
        return JSON.toJSONString(courseDao.findAll());
    }

    //增
    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestBody String s)
    {
        Course course=JSON.parseObject(s,Course.class);

        if(course.getCpno().length()==0){
            System.out.println("course.cpno-----"+course.getCpno()+"---");
            courseDao.save2(course);
        }
        else courseDao.save(course);
        return "save success";
    }

    //删
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestBody String s)
    {
        Course course=JSON.parseObject(s,Course.class);
        System.out.println(s+"----------------");

        courseDao.delete(course);
        return "delete successs";
    }

    //改
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody String s)
    {
        Course course=JSON.parseObject(s,Course.class);
        System.out.println("course--"+course);
        if(course.getCpno().length()==0){
            System.out.println("course.cpno-----"+course.getCpno()+"---");
            courseDao.update2(course);
        }
        else courseDao.update(course);
        return "update success";
    }

}
