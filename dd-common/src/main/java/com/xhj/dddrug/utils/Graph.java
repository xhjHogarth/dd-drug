package com.xhj.dddrug.utils;

import java.util.List;

/**
 * User: asus
 * Date: 2018/1/31
 * Time: 15:42
 * Version:V1.0
 */
public class Graph {
    private List<Node> nodes;
    private List<Link> links;

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
