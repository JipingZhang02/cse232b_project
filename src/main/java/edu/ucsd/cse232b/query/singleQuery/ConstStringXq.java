package edu.ucsd.cse232b.query.singleQuery;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.util.Consts;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ConstStringXq implements Query {
    private final String stringValue;

    public ConstStringXq(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) {
        return new EvalResult(Arrays.asList(Util.createTextNode(stringValue)), Consts.NONE);
    }
}
