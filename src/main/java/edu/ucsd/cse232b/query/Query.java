package edu.ucsd.cse232b.query;

import edu.ucsd.cse232b.expression.EvalResult;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Query{
    //EvalResult evaluate(EvalResult input, Map<String, Node> variables, Map<String, List<Node>> forInVariables) throws Exception;

    EvalResult evaluate(EvalResult input,Map<String,Node> variables) throws Exception;

/*    default EvalResult evaluate(EvalResult input) throws Exception{
        return evaluate(input,new HashMap<>());
    }*/
}
