package com.tongfu.idoccloud.preposition.feign.system.fallback;

import com.tongfu.idoccloud.preposition.entity.Company;
import com.tongfu.idoccloud.preposition.feign.system.CompanyFeign;
import com.tongfu.idoccloud.preposition.utils.InformError;
import com.tongfu.idoccloud.preposition.utils.MapVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/20 15:42
 */
@Component
public class CompanyFeignFallback implements CompanyFeign {
    /**
     * 调用失败发送通知
     */
    @Autowired
    private InformError informError;

    @Override
    public Company getCompanyInfo(String idoc_token) {
        informError.sendInform("trongfu:errorInform:getCompanyInfo",
                "/api/company/v1/getCompanyInfo获取公司信息调用服务失败！");
        return new Company(0);
    }

    @Override
    public Object updateCompanyInfo(Company company, String idoc_token) {
        informError.sendInform("trongfu:errorInform:getCompanyInfo",
                "/api/company/v1/updateCompanyInfo修改公司信息调用服务失败！");
        return  MapVo.returnMap("result","fallback" );
    }
}
