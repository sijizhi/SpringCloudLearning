package com.example.mycat.mapper;

import com.example.mycat.entity.Node;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/21 20:48
 */
public interface NodeDao {
    List<Node> getNodeTree();
    List<Node> getBaseTree();
    List<Node> getChildrenNodeTree(@Param("id") Long id);
}
