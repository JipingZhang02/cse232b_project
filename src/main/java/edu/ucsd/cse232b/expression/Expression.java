package edu.ucsd.cse232b.expression;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public interface Expression {
//    List<Node> evaluate(List<Node> inputNodes) throws Exception;

/*    default List<Node> evaluate(NodeList nodeList) throws Exception{
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            nodes.add(nodeList.item(i));
        }
        return evaluate(nodes);
    }*/

    EvalResult evaluate(EvalResult input) throws Exception;

    default Expression removeLeftmostSelfExpr(){
        return this;
    }
}
