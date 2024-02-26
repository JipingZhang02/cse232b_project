package edu.ucsd.cse232b.milestone3.join;

import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import org.w3c.dom.Node;

import java.util.Map;
import java.util.List;

public class JoinXq implements Query {
    private final Query leftTableGenerator, rightTableGenerator;
    private final List<String> joinOnColumnL,joinOnColumnR;

    public JoinXq(Query leftTableGenerator, Query rightTableGenerator, List<String> joinOnColumnL, List<String> joinOnColumnR) {
        this.leftTableGenerator = leftTableGenerator;
        this.rightTableGenerator = rightTableGenerator;
        this.joinOnColumnL = joinOnColumnL;
        this.joinOnColumnR = joinOnColumnR;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        Table leftTable = new Table(leftTableGenerator.evaluate(input, variables).nodes);
        Table rightTable = new Table(rightTableGenerator.evaluate(input, variables).nodes);
        Table joinedTable = Table.join2Tables(leftTable,rightTable,joinOnColumnL,joinOnColumnR);
        return new EvalResult(joinedTable.toNodes(), SlashStatus.NONE);
    }
}
