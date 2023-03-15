package com.air.service;

import com.air.entity.*;

import java.util.List;

public interface MonitorService {
    void save(Monitor monitor);

    void delete(String no);

    List<Monitor> findAll();

    Monitor findById(String no);
}
