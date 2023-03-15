package com.air.controller;

import com.air.dao.TeacherDao;
import com.air.entity.Teacher;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherDao teacherDao;

    //查
    @RequestMapping(value = "/getAll",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getAll()
    {
        System.out.println("getAll------------------");
        List<Teacher> arr=teacherDao.findAll();
        String ret=JSON.toJSONString(arr);
        return ret;
    }
    @RequestMapping(value = "/myStudent",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getMyStudent(@RequestBody String tno)
    {
        System.out.println("get my student------------------tno");
        List<Map<String,Object>> arr=teacherDao.getMyStudent(tno);
        String ret=JSON.toJSONString(arr);
        return ret;
    }
    @RequestMapping(value = "/getTeacherName",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getByTeacherName(@RequestBody String teacherName)
    {
        Teacher teacher=JSON.parseObject(teacherName,Teacher.class);

        List<Teacher> arr=teacherDao.getByTeacherName(teacher.getTname());
        String ret=JSON.toJSONString(arr);
        return ret;
    }
    @RequestMapping(value = "/findByCond",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String findByCond(@RequestBody String cond)
    {
        System.out.println(cond+"getTeacherName------------------");
        Teacher teacher=JSON.parseObject(cond,Teacher.class);

        System.out.println(teacher+"getTeacherName------------------");
        String condition=null;
        if(teacher.getTdept()!=null)
        {
            condition="where Tdept='"+teacher.getTdept()+"'";
        }
        if(teacher.getTsex()!=null)
        {
            if(condition!=null)
            {
                condition+=" and "+"Tsex='"+teacher.getTsex()+"'";
            }
            else{
                condition="where Tsex='"+teacher.getTsex()+"'";
            }
        }
        if(condition==null)condition="";
        System.out.println(condition);
        List<Teacher> arr=teacherDao.findByCond(condition);
        String ret=JSON.toJSONString(arr);
        return ret;
    }


    // TODO 增删改中如果出现错误、异常，怎么处理？？？
    //增
    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestBody String s)
    {
        Teacher teacher=JSON.parseObject(s,Teacher.class);
        System.out.println(s+"----------------"+teacher);

        teacherDao.save(teacher);
        return "save success";
    }

    //删
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestBody String s)
    {
        System.out.println(s+"----------------");
        teacherDao.delete(s);
        return "delete successs";
    }

    //改
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody String s)
    {
        Teacher teacher=JSON.parseObject(s,Teacher.class);
        System.out.println(s+"----------------"+teacher);

        teacherDao.update(teacher);
        return "update success";
    }
}
