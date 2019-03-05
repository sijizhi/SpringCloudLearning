package com.example.mycat.controller;

import com.example.mycat.entity.Node;
import com.example.mycat.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/21 21:11
 */
@RestController
@RequestMapping("/api/v1")
public class NodeRestController {

    @Autowired
    private NodeService nodeService;

    /**
     * 整个tree
     * @return
     */
    @GetMapping(value = "/node/allTree")
    public List<Node> getNodeTree() {
        return nodeService.getNodeTree();
    }

    /**
     * 一级节点
     * @return
     */
    @GetMapping(value = "/node/baseTree")
    public List<Node> getBaseTree() {
        return nodeService.getBaseTree();
    }

    /**
     * 下一级节点
     * @return
     */
    @GetMapping(value = "/node/nextTree")
    public List<Node> getChildrenNodeTree(Long id) {
        return nodeService.getChildrenNodeTree(id);
    }



    @GetMapping(value = "/node/getTree")
    public List<Node> getTree(){
//        int i = 0;
        List<Node> list = nodeService.getNodeTree();
//        首次循环获取母节点
        for(Node node: list){
            System.out.println("start"+node.getName());
            getList(node.getNext());
        }

        return list;
    }
    public void getList(List<Node> list){

        Node nd = new Node();
        if(list != null){
            if(list.size()>0){
                for(Node node : list){
//                    i++;
                    System.out.println(node.getName());
                    nd.setId(node.getId());
                    nd.setName(node.getName());
                    //递归获取下一个子节点
                    getList(node.getNext());
                }
            } else{
//                i = 0;
//                System.out.println("枝干结束"+i);
            }
        } else{
//            i = 0;
        }
    }



}
