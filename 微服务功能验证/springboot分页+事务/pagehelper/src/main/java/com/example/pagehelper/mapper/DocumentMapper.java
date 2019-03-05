package com.example.pagehelper.mapper;

import com.example.pagehelper.entity.Document;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/23 21:18
 */
public interface DocumentMapper {
    public int  millionAdd( Document document);
    public List<Document> listDocument(@Param("str") String str);
}
