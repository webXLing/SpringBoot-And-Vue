package com.ihrm.commom.controller;


import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String companyId;
    protected String companyName ;


    // 在所有controller 执行前 执行
    //
    @ModelAttribute
    public void setResAndReq(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;

        this.companyId = "1206110693677506560";
        this.companyName = "公司名称九点";
    }
}
