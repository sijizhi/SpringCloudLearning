package com.tongfu.idoccloud.preposition.controller.sys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tongfu.idoccloud.preposition.entity.Company;
import com.tongfu.idoccloud.preposition.entity.LoggerEntity;
import com.tongfu.idoccloud.preposition.entity.User;
import com.tongfu.idoccloud.preposition.enums.ResponseEnums;
import com.tongfu.idoccloud.preposition.feign.system.CompanyFeign;
import com.tongfu.idoccloud.preposition.feign.system.UserFeign;
import com.tongfu.idoccloud.preposition.service.LoggerService;
import com.tongfu.idoccloud.preposition.utils.ResponseUtil;
import com.tongfu.idoccloud.preposition.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 前置服务 统一接口
 * @Author: Sijie Zhi
 * @Date: 2019/3/12 16:51
 */
@RequestMapping("/uniteapi/sys/v1")
@RestController
public class UniteCompanyController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CompanyFeign companyFeign;



    /**
     *系统- 公司统一接口
     * @param map
     * @return
     */
    @PostMapping("/company/operation")
    public ResponseVO uniteForCompany(@RequestParam Map<String,Object> map){
        System.out.println(map.toString());
        String operation=map.get("operation").toString();
        Company comparam=JSON.parseObject(JSONArray.toJSONString(map),Company.class);
        try{
            System.out.println("controller>>>"+comparam);
            /**
             * 获取公司信息
             */
            if(operation.equals("getCompanyInfo")){
                Company company=companyFeign.getCompanyInfo(comparam.getIdoc_token());
                if(!StringUtils.isEmpty(company)){
                    if(company.getCompanyId()!=0){
                        return ResponseUtil.success(company);
                    }else{
                        return ResponseUtil.error(500,"服务器繁忙，请稍后再试！" );
                    }
                }

            }
            /**
             * 更新公司信息
             */
            else if(operation.equals("updateCompanyInfo")){
                Map resultMap=JSON.parseObject(JSONArray.toJSONString(companyFeign.updateCompanyInfo(comparam, comparam.getIdoc_token())),Map.class);
                if(!resultMap.get("result").equals("fallback")){
                    return ResponseUtil.success(resultMap);
                }else{
                    return ResponseUtil.error(500,"服务器繁忙，请稍后再试！" );
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error("执行操作operation="+operation+"有误");
            return ResponseUtil.error(ResponseEnums.ERROR);
        }

        return ResponseUtil.error(ResponseEnums.ERROR);
    }

}
