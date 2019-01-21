package com.example.mycat.service;

import com.example.mycat.entity.Node;

import java.util.List;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/21 20:47
 */
public interface NodeService {

    /**
     * ��ȡ�ڵ���
     */
    List<Node> getNodeTree();

    List<Node> getBaseTree();//һ��
    List<Node> getChildrenNodeTree(Long id);//��һ��

}
