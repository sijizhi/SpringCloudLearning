package com.example.mycat.service.Impl;

import com.example.mycat.entity.Node;
import com.example.mycat.mapper.NodeDao;
import com.example.mycat.service.NodeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/21 20:49
 */
@Component
public class NodeServiceImpl implements NodeService {
    @Resource
    private NodeDao nodeDao;

    /**
     * ����tree
     * @return
     */
    @Override
    public List<Node> getNodeTree() {
        return nodeDao.getNodeTree();
    }

    /**
     * һ���ڵ�
     * @return
     */
    @Override
    public List<Node> getBaseTree() {
        return nodeDao.getBaseTree();
    }

    /**
     * ��һ���ڵ�
     * @return
     */
    @Override
    public List<Node> getChildrenNodeTree(Long id) {
        return nodeDao.getChildrenNodeTree(id);
    }
}
