package com.tongfu.idoccloud.preposition.feign.system;

import com.tongfu.idoccloud.preposition.entity.Company;
import com.tongfu.idoccloud.preposition.feign.system.fallback.CompanyFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/20 15:41
 */
@FeignClient(name = "system-service",fallback = CompanyFeignFallback.class)
public interface CompanyFeign {

    String str ="/api/company/v1";

    @PostMapping(value =str+"/getCompanyInfo")
    public Company getCompanyInfo(@RequestParam("idoc_token")String  idoc_token);

    @PostMapping(value = "/api/company/v1/updateCompanyInfo",consumes = "application/json" )
    public Object updateCompanyInfo(@RequestBody Company company,
                                    @RequestParam("idoc_token")String  idoc_token);

}
