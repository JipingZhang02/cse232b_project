package edu.ucsd.cse232b.expression;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public interface Expression {
    List<Node> evaluate(List<Node> inputNodes) throws Exception;

    default List<Node> evaluate(NodeList nodeList) throws Exception{
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            nodes.add(nodeList.item(i));
        }
        return evaluate(nodes);
    }

    default List<Node> filter(Expression rp, Node inputNode) throws Exception {
        Objects.requireNonNull(rp);
        Objects.requireNonNull(inputNode);
        return rp.evaluate(Arrays.asList(inputNode));
    }

    default Expression removeLeftmostSelfExpr(){
        return this;
    }
}
