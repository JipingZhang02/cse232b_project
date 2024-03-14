package edu.ucsd.cse232b.milestone2.xquery;

import edu.ucsd.cse232b.autogen.XQueryBaseVisitor;
import edu.ucsd.cse232b.autogen.XQueryParser;
import edu.ucsd.cse232b.common.Pair;
import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.milestone1.expression.Expression;
import edu.ucsd.cse232b.milestone2.query.Query;
import edu.ucsd.cse232b.milestone2.query.QueryBuilderTool;
import edu.ucsd.cse232b.milestone2.query.binaryQuery.CommaQuery;
import edu.ucsd.cse232b.milestone2.query.binaryQuery.XQSlashRP;
import edu.ucsd.cse232b.milestone2.query.condition.*;
import edu.ucsd.cse232b.milestone2.query.condition.conjunctCondition.OrCondition;
import edu.ucsd.cse232b.milestone2.query.singleQuery.ConstStringXq;
import edu.ucsd.cse232b.milestone2.query.singleQuery.TagGeneratorQuery;
import edu.ucsd.cse232b.milestone2.query.singleQuery.VarXq;
import edu.ucsd.cse232b.milestone2.query.ExpressionWrapper;
import edu.ucsd.cse232b.milestone2.query.condition.conjunctCondition.AndCondition;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder extends XQueryBaseVisitor<Pair<Query, Condition>> {
    public static final QueryBuilder INSTANCE = new QueryBuilder();

    protected QueryBuilder() {
        // singleton design mode
    }

/*    @Override
    public Pair<Query, Condition> visitWsXq2(XQueryParser.WsXq2Context ctx) {
        return visit(ctx.xq());
    }

    @Override
    public Pair<Query, Condition> visitWsXq1(XQueryParser.WsXq1Context ctx) {
        return visit(ctx.xq());
    }*/

    @Override
    public Pair<Query, Condition> visitRpXq(XQueryParser.RpXqContext ctx) {
        Query xq = visit(ctx.xq()).left;
        Expression rp = XPath.buildRpExpression(ctx.rp().getText());
        switch (ctx.pathOp().getText()) {
            case "//":
                return new Pair<>(new XQSlashRP(xq, rp, SlashStatus.DOUBLE_SLASH), null);
            case "/":
                return new Pair<>(new XQSlashRP(xq, rp, SlashStatus.SINGLE_SLASH), null);
            default:
                throw new IllegalArgumentException(); // this line is not expected to be executed
        }
    }

    @Override
    public Pair<Query, Condition> visitStringXq(XQueryParser.StringXqContext ctx) {
        String stringConst = ctx.STRING().getText();
        return new Pair<>(new ConstStringXq(stringConst.substring(1, stringConst.length() - 1)), null);
    }

    @Override
    public Pair<Query, Condition> visitParaXq(XQueryParser.ParaXqContext ctx) {
        return visit(ctx.xq());
    }

    @Override
    public Pair<Query, Condition> visitApXq(XQueryParser.ApXqContext ctx) {
        return new Pair<>(new ExpressionWrapper(XPath.buildApExpression(ctx.ap().getText())), null);
    }

    @Override
    public Pair<Query, Condition> visitCommaXq(XQueryParser.CommaXqContext ctx) {
        return new Pair<>(new CommaQuery(visit(ctx.xq(0)).left, visit(ctx.xq(1)).left), null);
    }

    @Override
    public Pair<Query, Condition> visitCommaXq2(XQueryParser.CommaXq2Context ctx) {
        return new Pair<>(new CommaQuery(visit(ctx.xq(0)).left, visit(ctx.xq(1)).left), null);
    }

    @Override
    public Pair<Query, Condition> visitTagXq2(XQueryParser.TagXq2Context ctx) {
        return new Pair<>(new TagGeneratorQuery(ctx.startTag().tagName().getText(), visit(ctx.xq()).left), null);
    }

    @Override
    public Pair<Query, Condition> visitVarXq(XQueryParser.VarXqContext ctx) {
        return new Pair<>(new VarXq(ctx.VAR().getText().substring(1)), null);
    }

    @Override
    public Pair<Query, Condition> visitLetXq(XQueryParser.LetXqContext ctx) {
        List<String> varNames = new ArrayList<>();
        List<Query> assignValXqs = new ArrayList<>();
        if (ctx.letClause() != null) {
            for (TerminalNode tmNode : ctx.letClause().VAR()) {
                varNames.add(tmNode.getText());
            }
            for (XQueryParser.XqContext xqCtx : ctx.letClause().xq()) {
                assignValXqs.add(visit(xqCtx).left);
            }
        }
        return new Pair<>(QueryBuilderTool.buildLetClause(varNames, assignValXqs, visit(ctx.xq()).left), null);
    }

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
        Condition whereCondition = new True();
        if (ctx.whereClause() != null) {
            whereCondition = visit(ctx.whereClause().cond()).right;
        }
        Query returnClause = visit(ctx.returnClause().xq()).left;
        Query res = QueryBuilderTool.buildForClause(forVarNames, forAssignValXqs, letVarNames, letAssignValXqs, whereCondition, returnClause,true);
        return new Pair<>(res, null);
    }

    @Override
    public Pair<Query, Condition> visitTagXq(XQueryParser.TagXqContext ctx) {
        return new Pair<>(new TagGeneratorQuery(ctx.startTag().tagName().getText(), visit(ctx.xq()).left), null);
    }



    @Override
    public Pair<Query, Condition> visitEqCondDoubleMathOp(XQueryParser.EqCondDoubleMathOpContext ctx) {
        return new Pair<>(null, new EqCondition(visit(ctx.xq(0)).left, visit(ctx.xq(1)).left,EqCondition.DOUBLE_EQ_SIGN));
    }

    @Override
    public Pair<Query, Condition> visitEqCondEqStr(XQueryParser.EqCondEqStrContext ctx) {
        return new Pair<>(null, new EqCondition(visit(ctx.xq(0)).left, visit(ctx.xq(1)).left,EqCondition.EQ_STR));
    }

    @Override
    public Pair<Query, Condition> visitEqCondMathOp(XQueryParser.EqCondMathOpContext ctx) {
        return new Pair<>(null, new EqCondition(visit(ctx.xq(0)).left, visit(ctx.xq(1)).left,EqCondition.EQ_SIGN));
    }

    @Override
    public Pair<Query, Condition> visitEqCondIsStr(XQueryParser.EqCondIsStrContext ctx) {
        return new Pair<>(null, new EqCondition(visit(ctx.xq(0)).left, visit(ctx.xq(1)).left,EqCondition.IS_STR));
    }

    @Override
    public Pair<Query, Condition> visitConjunctCond(XQueryParser.ConjunctCondContext ctx) {
        switch (ctx.filterOp().getText()) {
            case "and":
                return new Pair<>(null, new AndCondition(visit(ctx.cond(0)).right, visit(ctx.cond(1)).right));
            case "or":
                return new Pair<>(null, new OrCondition(visit(ctx.cond(0)).right, visit(ctx.cond(1)).right));
            default:
                throw new IllegalArgumentException();
        }
    }


    @Override
    public Pair<Query, Condition> visitSatCond(XQueryParser.SatCondContext ctx) {
        List<String> varNames = new ArrayList<>();
        List<Query> assignValXqs = new ArrayList<>();
        for (TerminalNode tmNode : ctx.satisfy().VAR()) {
            varNames.add(tmNode.getText());
        }
        for (XQueryParser.XqContext xqCtx : ctx.satisfy().xq()) {
            assignValXqs.add(visit(xqCtx).left);
        }
        Condition whereCondition = QueryBuilderTool.buildSomeSatisfyCondition(varNames,assignValXqs,visit(ctx.cond()).right);
        return new Pair<>(null,whereCondition);
    }

    @Override
    public Pair<Query, Condition> visitEmptyCond(XQueryParser.EmptyCondContext ctx) {
        return new Pair<>(null, new EmptyCondition(visit(ctx.xq()).left));
    }

    @Override
    public Pair<Query, Condition> visitNegCond(XQueryParser.NegCondContext ctx) {
        return new Pair<>(null,new NegCondition(visit(ctx.cond()).right));
    }

    @Override
    public Pair<Query, Condition> visitParaCond(XQueryParser.ParaCondContext ctx) {
        return visit(ctx.cond());
    }


    @Override
    public Pair<Query, Condition> visitJoinXq(XQueryParser.JoinXqContext ctx) {
        throw new IllegalArgumentException("milestone2 parser cannot handle with join!");
    }
}
