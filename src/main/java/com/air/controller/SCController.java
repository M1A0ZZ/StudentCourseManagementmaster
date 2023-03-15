package com.air.controller;


import com.air.dao.SCDao;
import com.air.entity.SC;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sc")
public class SCController {
    @Autowired
    SCDao scDao;


    @RequestMapping(value = "/myCourse",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String findMyCourse(@RequestBody String Sno)
    {
        System.out.println(scDao.findAll());
        return JSON.toJSONString(scDao.findMyCourse(Sno));
    }

    @RequestMapping(value = "/findAll",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String findAll()
    {
        System.out.println(scDao.findAll());
        return JSON.toJSONString(scDao.findAll());
    }

    @RequestMapping(value = "/insert",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insert(@RequestBody String data)
    {
        // TODO 先检查是否存在，再决定是否插入
        System.out.println(data);
        SC sc=JSON.parseObject(data,SC.class);
        System.out.println(sc);
        scDao.insert(sc);
        return "insert sc success";
    }

    @RequestMapping(value = "/delete",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String delete(@RequestBody String data)
    {
        SC sc=JSON.parseObject(data,SC.class);
        System.out.println(sc);
        scDao.delete(sc);
        return "delete sc success";
    }

    @RequestMapping(value = "/update",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String update(@RequestBody String data)
    {
        SC sc=JSON.parseObject(data,SC.class);
        System.out.println("sc----"+sc);
        System.out.println(sc);
        scDao.update(sc);
        return "update sc success";
    }


}
