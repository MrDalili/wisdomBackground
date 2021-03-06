package com.smart.controller;


import com.smart.pojo.StudentInfo;
import com.smart.pojo.TbStudent;
import com.smart.pojo.TbTeacher;
import com.smart.pojo.WisdomResult;
import com.smart.service.WXLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Controller
@RequestMapping("/wx1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class WeiXinLoginController {
    @Autowired
    private WXLoginService wxLoginService;
    /**
     * 绑定帐号与openid
     * @param account 账号
     * @param password 密码
     * @param status 状态
     */
    @RequestMapping("bindOpenid")
    @ResponseBody
    public WisdomResult bindOpenidWithAccount(String openid1,String account, String password, int status,
                                              HttpServletRequest request){
        //获取openid
        String openid = (String) request.getSession().getAttribute("openid");
        //调用service绑定openid与账号
        WisdomResult wisdomResult = wxLoginService.bindOpenidWithAccount(openid1, account, password, status);
        //判断该人为老师还是学生，把对应的变量存入session中
        if (wisdomResult.getStatus() == 1){
            request.getSession().setAttribute("status",1);
            request.getSession().setAttribute("student",(StudentInfo)wisdomResult.getData());
        }else if (wisdomResult.getStatus() == 2){
            request.getSession().setAttribute("status",2);
            request.getSession().setAttribute("student",(TbTeacher)wisdomResult.getData());
        }
        //返回结果
        return wisdomResult;
    }
}
