package edu.ucsd.cse232b.query.condition;

import org.w3c.dom.Node;

import java.util.Map;

public interface Condition {
    boolean assess(Map<String, Node> variables) throws Exception;
}
