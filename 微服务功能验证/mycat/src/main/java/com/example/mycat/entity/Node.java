package com.example.mycat.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/21 20:44
 */
public class Node {

    private Long id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Node> next;

    public Node() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNext() {
        return next;
    }

    public void setNext(List<Node> next) {
        this.next = next;
    }
}
