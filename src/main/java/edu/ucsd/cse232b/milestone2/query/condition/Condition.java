package edu.ucsd.cse232b.milestone2.query.condition;

import edu.ucsd.cse232b.milestone2.query.Query;
import org.w3c.dom.Node;

import java.util.Map;

public interface Condition {
    boolean assess(Map<String, Node> variables) throws Exception;

    Condition substitute(Query originQuery, Query newQuery);

    default String serialize(){
        return toString();
    }
}
