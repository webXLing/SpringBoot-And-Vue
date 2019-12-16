package com.ihrm.company.controller;

import com.ihrm.commom.entity.Result;
import com.ihrm.commom.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;


    //保存企业
    @RequestMapping(value="")
    @PostMapping
//    @RequestBody 将请求体分装为 company对象
    public Result save(@RequestBody Company company)  {
        //业务操作
        companyService.add(company);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新企业
    /**
     * 1.方法
     * 2.请求参数
     * 3.响应
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result delete(@PathVariable(value = "id") String id,@RequestBody Company company){

        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id删除企业
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value="id") String id) {
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询企业
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value="id") String id) {
        Company company = companyService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(company);
        return result;
    }

    //查询全部企业列表
    @RequestMapping(value="",method = RequestMethod.GET)
    public Result findAll() {
        List<Company> all = companyService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(all);
        return result;
    }
//
//    @RequestMapping(value="",method = RequestMethod.GET)
//    public String findAll() {
//
//        return "ewdwefdew";
//    }

}
