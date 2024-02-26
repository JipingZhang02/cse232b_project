package edu.ucsd.cse232b.milestone3;

import edu.ucsd.cse232b.autogen.XQueryParser;
import edu.ucsd.cse232b.common.Pair;
import edu.ucsd.cse232b.milestone3.join.JoinXq;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.query.QueryBuilderTool;
import edu.ucsd.cse232b.query.condition.Condition;
import edu.ucsd.cse232b.query.condition.IdentityCondition;
import edu.ucsd.cse232b.xquery.QueryBuilder;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class Ms3QueryBuilder extends QueryBuilder {
    @Override
    public Pair<Query, Condition> visitForXq(XQueryParser.ForXqContext ctx) {
        List<String> forVarNames = new ArrayList<>();
        for (TerminalNode tmNode : ctx.forClause().VAR()) {
            forVarNames.add(tmNode.getText());
        }
        List<Query> forAssignValXqs = new ArrayList<>();
        for (XQueryParser.XqContext xqCtx : ctx.forClause().xq()) {
            forAssignValXqs.add(visit(xqCtx).left);
        }
        List<String> letVarNames = new ArrayList<>();
        List<Query> letAssignValXqs = new ArrayList<>();
        if (ctx.letClause() != null) {
            for (TerminalNode tmNode : ctx.letClause().VAR()) {
                letVarNames.add(tmNode.getText());
            }
            for (XQueryParser.XqContext xqCtx : ctx.letClause().xq()) {
                letAssignValXqs.add(visit(xqCtx).left);
            }
        }
        Condition whereCondition = new IdentityCondition();
        if (ctx.whereClause() != null) {
            whereCondition = visit(ctx.whereClause().cond()).right;
        }
        Query returnClause = visit(ctx.returnClause().xq()).left;
        Query res = QueryBuilderTool.buildForClause(forVarNames, forAssignValXqs, letVarNames, letAssignValXqs, whereCondition, returnClause);
        return new Pair<>(res, null);
    }

    private static class CanNotOptimizeException extends Exception{

    }

    private static JoinXq tryOptimizeImplicitJoin(List<String> forVarNames,List<Query> forAssignValXqs,Condition whereCondition) throws CanNotOptimizeException{
        return null;
    }
}
