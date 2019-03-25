package com.tongfu.idoccloud.system.mapper;

import com.tongfu.idoccloud.system.entity.Company;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/20 15:09
 */
public interface CompanyMapper {
    Company getCompanyInfo();
    int updateCompanyInfo(Company company);

}
