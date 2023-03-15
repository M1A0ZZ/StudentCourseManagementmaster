package com.air.service.impl;

import com.air.dao.MonitorDao;
import com.air.dao.StudentDao;
import com.air.dao.TeacherDao;
import com.air.entity.Monitor;
import com.air.entity.Student;
import com.air.entity.Teacher;
import com.air.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    MonitorDao monitorDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;

    @Override
    public Monitor monitorLoginJudge(Monitor user) {
        Monitor monitor=monitorDao.findMonitor(user);
        return monitor;
    }

    @Override
    public Student studentLoginJudge(Student user) {
        Student student=studentDao.findStudent(user);
        return student;
    }

    @Override
    public Teacher teacherLoginJudge(Teacher user) {
        Teacher teacher=teacherDao.findTeacher(user);
        return teacher;
    }
}
