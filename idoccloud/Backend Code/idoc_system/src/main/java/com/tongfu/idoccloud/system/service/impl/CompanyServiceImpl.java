package com.tongfu.idoccloud.system.service.impl;

import com.tongfu.idoccloud.system.entity.Company;
import com.tongfu.idoccloud.system.mapper.CompanyMapper;
import com.tongfu.idoccloud.system.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 公司业务层
 * @Author: Sijie Zhi
 * @Date: 2019/3/20 15:08
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    /**
     * 获取公司信息
     * @return
     */
    @Override
    public Company getCompanyInfo() {
        Company company=companyMapper.getCompanyInfo();
        return company;
    }

    /**
     * 修改公司信息
     * @param company
     * @return
     */
    @Override
    public boolean updateCompanyInfo(Company company) {
        company.setUpdateDate(new Date());
        if(companyMapper.updateCompanyInfo(company)==1){
            return true;
        }
        return false;
    }
}
