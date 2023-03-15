package com.air.controller;

import com.air.entity.Monitor;
import com.air.entity.Student;
import com.air.entity.Teacher;
import com.air.service.LoginService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;// TODO 存在问题看，因为loginService里包含一个monitorDao的bean

    @RequestMapping("/")
    public String redirectLogin(){
        return "loginPage";
    }

    @RequestMapping("/loginPage")
    public String loginPage()
    {
        //ModelAndView m=new ModelAndView("login.html");
        return "loginPage.jsp";
    }

    //管理权限登录
    @RequestMapping("/manage/login")
    public ModelAndView loginMonitor(@RequestBody String s){
        Monitor user=JSON.parseObject(s,Monitor.class);
        //判断管理账号是否能能登录账号
        Monitor manageUser = loginService.monitorLoginJudge(user);
        System.out.println(user+"user check:"+manageUser);
        if(manageUser == null){
            ModelAndView modelAndView = new ModelAndView("/loginPage");
            modelAndView.addObject("message","error");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/monitor/monitorIndex.jsp");
        return modelAndView;
    }

    //学生登录
    @RequestMapping("/student/login")
    public ModelAndView loginStudent(@RequestBody String s){
        Student user=JSON.parseObject(s, Student.class);
        //判断学生账号是否能能登录账号
        Student studentUser = loginService.studentLoginJudge(user);
        System.out.println(user+"user check:"+studentUser);
        if(studentUser == null){
            ModelAndView modelAndView = new ModelAndView("/loginPage");
            modelAndView.addObject("message","error");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("/student/studentIndex.jsp");
        modelAndView.addObject("name",studentUser.getSname());
        modelAndView.addObject("no",studentUser.getSno());
        modelAndView.addObject("dept",studentUser.getSdept());
        modelAndView.addObject("message","success");
//        modelAndView.addObject("password",studentUser.getSpassword());
        return modelAndView;
    }

    //学生登录
    @RequestMapping("/teacher/login")
    public ModelAndView loginTeacher(@RequestBody String s){
        Teacher user=JSON.parseObject(s, Teacher.class);
        //判断学生账号是否能能登录账号
        Teacher teacherUser = loginService.teacherLoginJudge(user);
        System.out.println(user+"user check:"+teacherUser);
        if(teacherUser == null){
            ModelAndView modelAndView = new ModelAndView("/loginPage");
            modelAndView.addObject("message","error");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("/teacher/teacherIndex.jsp");
        modelAndView.addObject("name",teacherUser.getTname());
        modelAndView.addObject("no",teacherUser.getTno());
        modelAndView.addObject("dept",teacherUser.getTdept());
        modelAndView.addObject("message","success");
        return modelAndView;
    }
}
