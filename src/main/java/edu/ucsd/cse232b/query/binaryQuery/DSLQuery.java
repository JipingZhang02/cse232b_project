package edu.ucsd.cse232b.query.binaryQuery;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.util.Consts;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Map;

public class DSLQuery extends XQSlashRP{
    public DSLQuery(Query query, Expression relPath) {
        super(query, relPath);
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        EvalResult leftRes = query.evaluate(input, variables);
        leftRes.slashStatus = Consts.DOUBLE_SLASH;
        return relPath.evaluate(leftRes);
    }
}
