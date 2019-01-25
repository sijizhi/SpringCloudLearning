package com.example.pagehelper.controller;

import com.example.pagehelper.entity.Document;
import com.example.pagehelper.entity.PageResultBean;
import com.example.pagehelper.service.DocumentService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/23 21:55
 */
@RestController
public class DocumentController {
    @Resource
    private DocumentService documentService;

    @RequestMapping("millionAdd")
    public int millionAdd() throws Exception {
        return documentService.millionAdd();
    }


    @RequestMapping("getin")
    public StringBuffer getin()throws  Exception{
        StringBuffer str=new StringBuffer();
        for(int i=1;i<=1000;i++){
            str=str.append(",").append(i);
        }

        return str;
    }



    @RequestMapping("pageDocument")
    public PageResultBean<Document> listDocument(int currentPage, int pageSize) throws Exception {
        return new PageResultBean<>(documentService.listDocument(currentPage,pageSize ));
    }
}
