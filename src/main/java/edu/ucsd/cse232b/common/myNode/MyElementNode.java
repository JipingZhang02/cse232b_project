package edu.ucsd.cse232b.common.myNode;

import edu.ucsd.cse232b.common.Util;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyElementNode implements MyNode{
    String tagName = "";
    List<MyNode> children = new ArrayList<>();

    public MyElementNode() {
    }

    public MyElementNode(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyElementNode that = (MyElementNode) o;
        return Objects.equals(tagName, that.tagName) && Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagName, children);
    }

    @Override
    public Node toW3cNode() {
        List<Node> childrenW3cNodes = new ArrayList<>();
        for (MyNode child:children){
            childrenW3cNodes.add(child.toW3cNode());
        }
        return Util.assembleNode(tagName,childrenW3cNodes);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("<%s>",tagName));
        for (MyNode child:children){
            res.append(child.toString());
        }
        res.append(String.format("</%s>",tagName));
        return res.toString();
    }

    public List<MyNode> getChildren() {
        return children;
    }
}
