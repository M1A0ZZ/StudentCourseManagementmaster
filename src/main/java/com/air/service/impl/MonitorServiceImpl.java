package com.air.service.impl;


import com.air.dao.MonitorDao;
import com.air.entity.Monitor;
import com.air.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorService {
    @Override
    public void save(Monitor monitor) {

    }

    @Override
    public void delete(String no) {

    }

    @Override
    public List<Monitor> findAll() {
        return null;
    }

    @Override
    public Monitor findById(String no) {
        return null;
    }

//    @Autowired
//    private MonitorDao monitorDao;


//    @Override
//    public void save(Monitor monitor) {
//        monitorDao.save(monitor);
//    }
//
//    @Override
//    public void delete(String no) {
//        monitorDao.delete(no);
//    }
//
//    @Override
//    public List<Monitor> findAll() {
//        return monitorDao.findAll();
//    }
//
//    @Override
//    public Monitor findById(String no) {
//        return monitorDao.findById(no);
//    }
}
