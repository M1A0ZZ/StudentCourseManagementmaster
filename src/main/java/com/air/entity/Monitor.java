package com.air.entity;

import lombok.Data;

//管理员
@Data
public class Monitor {
    private String Mno;
    private String Mpassword;//密码
    /**loginName是前端登录界面输入的账号
     * password是前端登录界面输入的密码
     * */

    public Monitor(){}
    public Monitor(String loginName, String password)
    {
        Mno=loginName;
        Mpassword=password;
    }
}
