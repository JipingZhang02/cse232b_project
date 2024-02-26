package edu.ucsd.cse232b.milestone3.join;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import org.w3c.dom.Node;

import java.util.Map;
import java.util.List;

public class JoinXq implements Query {
    private final Query leftTable,rightTable;
    private final List<String> joinOnColumnL,joinOnColumnR;

    public JoinXq(Query leftTable, Query rightTable, List<String> joinOnColumnL, List<String> joinOnColumnR) {
        this.leftTable = leftTable;
        this.rightTable = rightTable;
        this.joinOnColumnL = joinOnColumnL;
        this.joinOnColumnR = joinOnColumnR;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        return null;
    }
}
