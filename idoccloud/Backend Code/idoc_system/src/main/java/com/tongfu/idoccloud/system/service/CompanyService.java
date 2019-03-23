package com.tongfu.idoccloud.system.service;

import com.tongfu.idoccloud.system.entity.Company;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/20 15:06
 */
public interface CompanyService {
    Company getCompanyInfo();
    boolean updateCompanyInfo(Company company);
}
