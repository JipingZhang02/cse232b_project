package edu.ucsd.cse232b.expression;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public interface Expression {
    List<Node> evaluate(List<Node> inputNodes) throws Exception;

    default List<Node> filter(Expression rp, Node inputNode) throws Exception {
        Objects.requireNonNull(rp);
        Objects.requireNonNull(inputNode);
        return rp.evaluate(Arrays.asList(inputNode));
    }
}
