package com.xhj.dddrug.utils;

/**
 * User: asus
 * Date: 2018/1/31
 * Time: 15:41
 * Version:V1.0
 */
public class Node {

    private String name;
    private Attributes attributes;
    private String id;
    private int size;
    private int category;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                ", id='" + id + '\'' +
                ", size=" + size +
                ", category=" + category +
                ", type='" + type + '\'' +
                '}';
    }
}
