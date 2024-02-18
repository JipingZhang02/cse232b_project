package edu.ucsd.cse232b.query.condition;

import org.w3c.dom.Node;

import java.util.Map;

public class IdentityCondition implements Condition{
    @Override
    public boolean assess(Map<String, Node> variables) throws Exception {
        return true;
    }

    @Override
    public String toString(){
        return "true";
    }
}
