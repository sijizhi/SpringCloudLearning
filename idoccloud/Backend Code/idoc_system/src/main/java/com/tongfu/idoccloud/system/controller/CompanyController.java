package com.tongfu.idoccloud.system.controller;

import com.tongfu.idoccloud.system.entity.Company;
import com.tongfu.idoccloud.system.entity.User;
import com.tongfu.idoccloud.system.service.CompanyService;
import com.tongfu.idoccloud.system.utils.MapVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/20 15:14
 */
@RequestMapping("/api/company/v1")
@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    /**
     * 获取公司信息
     * @return
     */
    @PostMapping("/getCompanyInfo")
    public Company getCompanyInfo(Company company){
        company=companyService.getCompanyInfo();
        System.out.println("》》》》》》》》》》》》》》》》》getCompanyInfo"+company);
        return company;
    }


    /**
     * 更新公司信息
     * @return
     */
    @PostMapping("/updateCompanyInfo")
    public Object updateCompanyInfo(@RequestBody Company company){
        System.out.println("》》》》》》》》》》》》》》》》》updateCompanyInfo"+company);
        return  MapVo.returnMap("result",companyService.updateCompanyInfo(company));
    }






}
