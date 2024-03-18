package edu.ucsd.cse232b.milestone2.xquery.condition;

import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import org.w3c.dom.Node;

import java.util.Map;

public class True implements Condition{
    @Override
    public boolean assess(Map<String, Node> variables) throws Exception {
        return true;
    }

    @Override
    public Condition substitute(XQuery originXQuery, XQuery newXQuery) {
        return this;
    }

    @Override
    public String toString(){
        return "true";
    }
}
