package edu.ucsd.cse232b.query.binaryQuery;

import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.query.Query;
import org.w3c.dom.Node;

import java.util.Map;

public class XQSlashRP implements Query {
    protected Query query;
    protected final Expression relPath;
    private final int slashStatus;

    public XQSlashRP(Query query, Expression relPath, int slashStatus) {
        this.query = query;
        this.relPath = relPath;
        this.slashStatus = slashStatus;
    }

    public Query getQuery() {
        return query;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        EvalResult leftRes = query.evaluate(input, variables);


        leftRes.slashStatus = slashStatus;
        return relPath.evaluate(leftRes);
    }

    @Override
    public Query substitute(Query originQuery, Query newQuery) {
        query = query.substitute(originQuery, newQuery);
        return this;
    }

    @Override
    public String toString(){
        return String.format("%s%s%s",query.toString(), SlashStatus.toString(slashStatus),relPath.toString());
    }
}
