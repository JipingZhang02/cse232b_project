package edu.ucsd.cse232b.query;

import edu.ucsd.cse232b.expression.EvalResult;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Query{
    EvalResult evaluate(EvalResult input,Map<String,Node> variables) throws Exception;

    default String serialize(){
        return toString();
    }
}
