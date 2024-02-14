package edu.ucsd.cse232b.query.singleQuery;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.util.Consts;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VarXq implements Query {
    private final String varName;

    public VarXq(String varName) {
        this.varName = varName;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) {
        if (variables.containsKey(varName)){
            return new EvalResult(Arrays.asList(variables.get(varName)), Consts.NONE);
        }
        throw new RuntimeException("variable '"+varName+"' has not been defined!");
    }
}
