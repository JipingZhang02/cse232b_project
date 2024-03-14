package edu.ucsd.cse232b.common.myNode;

import edu.ucsd.cse232b.common.Util;
import org.w3c.dom.Node;

import java.util.Objects;

public class MyStringNode implements MyNode{
    String strValue="";

    MyStringNode(){

    }

    MyStringNode(String strValue) {
        this.strValue = strValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyStringNode that = (MyStringNode) o;
        return Objects.equals(strValue, that.strValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strValue);
    }

    @Override
    public Node toW3cNode() {
        return Util.createTextNode(strValue);
    }

    @Override
    public String toString(){
        return strValue;
    }
}
