package com.example.mycat.service;

import com.example.mycat.entity.Node;

import java.util.List;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/21 20:47
 */
public interface NodeService {

    /**
     * 获取节点树
     */
    List<Node> getNodeTree();

    List<Node> getBaseTree();//一级
    List<Node> getChildrenNodeTree(Long id);//下一级

}
