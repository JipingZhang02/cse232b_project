package edu.ucsd.cse232b.milestone2.xquery.condition;

import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import org.w3c.dom.Node;

import java.util.Map;

public interface Condition {
    boolean assess(Map<String, Node> variables) throws Exception;

    Condition substitute(XQuery originXQuery, XQuery newXQuery);
}
