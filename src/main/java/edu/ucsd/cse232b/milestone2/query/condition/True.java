package edu.ucsd.cse232b.milestone2.query.condition;

import edu.ucsd.cse232b.milestone2.query.Query;
import org.w3c.dom.Node;

import java.util.Map;

public class True implements Condition{
    @Override
    public boolean assess(Map<String, Node> variables) throws Exception {
        return true;
    }

    @Override
    public Condition substitute(Query originQuery, Query newQuery) {
        return this;
    }

    @Override
    public String toString(){
        return "true";
    }
}
