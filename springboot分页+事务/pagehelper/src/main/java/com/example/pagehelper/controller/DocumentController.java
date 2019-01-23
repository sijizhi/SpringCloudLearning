package com.example.pagehelper.controller;

import com.example.pagehelper.service.DocumentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
}
