package com.air.service;

import com.air.entity.Monitor;
import com.air.entity.Student;
import com.air.entity.Teacher;

public interface LoginService {
    //管理账号登录判断
    Monitor monitorLoginJudge(Monitor user);

    //学生账号登录判断
    Student studentLoginJudge(Student user);

    //教师账号登录判断
    Teacher teacherLoginJudge(Teacher user);
}
