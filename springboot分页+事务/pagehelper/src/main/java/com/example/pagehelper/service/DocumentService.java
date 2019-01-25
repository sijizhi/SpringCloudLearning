package com.example.pagehelper.service;

import com.example.pagehelper.entity.Document;
import com.example.pagehelper.entity.User;

import java.util.List;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/23 21:15
 */
public interface DocumentService {
    public int  millionAdd() throws  Exception;
    public List<Document> listDocument(int currentPage, int pageSize) throws Exception;
}
