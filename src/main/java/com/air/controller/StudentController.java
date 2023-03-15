package com.air.controller;

import com.air.dao.SCDao;
import com.air.dao.StudentDao;
import com.air.entity.Student;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentDao studentDao;

    @RequestMapping(value = "/getAll",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getAll()
    {
        System.out.println("getAll------------------");
        List<Student> arr=studentDao.findAll();
        String ret=JSON.toJSONString(arr);
        return ret;
    }
    @RequestMapping(value = "/findById",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String findById(@RequestBody String sno)
    {
        System.out.println(sno);
        Student stu= studentDao.findById(sno);
        String ret=JSON.toJSONString(stu);
        return ret;
    }
    @RequestMapping(value = "/getStudentName",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getStudentName(@RequestBody String pattern)
    {
        Student student=JSON.parseObject(pattern,Student.class);
        System.out.println(student);
        System.out.println(pattern);
        List<Student> arr=studentDao.getByStudentName(student.getSname());
        String ret=JSON.toJSONString(arr);
        return ret;
    }
    @RequestMapping(value = "/findByCond",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String findByCond(@RequestBody String cond)
    {
        System.out.println(cond+"getTeacherName------------------");
        Student student=JSON.parseObject(cond,Student.class);

        System.out.println("getStudentName-"+student);
        String condition=null;
        if(student.getSdept()!=null)
        {
            condition="where Sdept='"+student.getSdept()+"'";
        }
        if(student.getSsex()!=null)
        {
            if(condition!=null)
            {
                condition+=" and "+"Ssex='"+student.getSsex()+"'";
            }
            else{
                condition="where Ssex='"+student.getSsex()+"'";
            }
        }
        if(condition==null)condition="";
        System.out.println(condition);
        List<Student> arr=studentDao.findByCond(condition);
        String ret=JSON.toJSONString(arr);
        return ret;
    }

    //增
    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestBody String s)
    {
        Student student=JSON.parseObject(s,Student.class);
        System.out.println(s+"----------------"+student);

        studentDao.save(student);
        return "save success";
    }

    //删
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestBody String s)
    {
        System.out.println(s+"----------------");

        studentDao.delete(s);
        return "delete successs";
    }

    //改
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody String s)
    {
        Student student=JSON.parseObject(s,Student.class);
        System.out.println("update---"+student);

        studentDao.update(student);
        return "update success";
    }


}
