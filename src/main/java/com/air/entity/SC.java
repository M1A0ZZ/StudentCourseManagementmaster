package com.air.entity;

import lombok.Data;

//选课关系
@Data
public class SC {
    private String Sno;
    private String Cno;
    private int Grade;//学分
}
