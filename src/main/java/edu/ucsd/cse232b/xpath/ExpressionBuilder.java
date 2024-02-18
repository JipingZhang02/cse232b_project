package edu.ucsd.cse232b.xpath;

import edu.ucsd.cse232b.autogen.XPathBaseVisitor;
import edu.ucsd.cse232b.autogen.XPathParser;
import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.expression.FilterExpr;
import edu.ucsd.cse232b.expression.absPathExpr.AbsPath;
import edu.ucsd.cse232b.expression.binaryExpr.ComaExpr;
import edu.ucsd.cse232b.expression.binaryExpr.SlashExpr;
import edu.ucsd.cse232b.expression.binaryFltr.BinaryConstEqualsFltr;
import edu.ucsd.cse232b.expression.binaryFltr.BinaryEqualsFltr;
import edu.ucsd.cse232b.expression.conjuctFltr.AndFltr;
import edu.ucsd.cse232b.expression.conjuctFltr.OrFltr;
import edu.ucsd.cse232b.expression.singleExpr.*;
import edu.ucsd.cse232b.expression.singleFltr.NegFltr;
import edu.ucsd.cse232b.expression.singleFltr.SingleFltr;

public class ExpressionBuilder extends XPathBaseVisitor<Expression> {
    public static final ExpressionBuilder INSTANCE = new ExpressionBuilder();

    private ExpressionBuilder(){

    }


    @Override
    public Expression visitAp(XPathParser.ApContext ctx) {
        String filename = ctx.docName().fileName().getText();
        filename = filename.substring(1,filename.length()-1);
        String pathOp = ctx.pathOp().getText();
        Expression relPathExpr = visit(ctx.rp());
        if (pathOp.equals("//")){
            return new AbsPath(relPathExpr,filename, SlashStatus.DOUBLE_SLASH);
        } else {
            return new AbsPath(relPathExpr,filename, SlashStatus.SINGLE_SLASH);
        }
    }

    @Override
    public Expression visitStarRp(XPathParser.StarRpContext ctx) {
        return new StarExpr();
    }

    @Override
    public Expression visitBinaryRp(XPathParser.BinaryRpContext ctx) {
        Expression left = visit(ctx.rp(0));
        Expression right = visit(ctx.rp(1));
        String pathOp = ctx.pathOp().getText();
        if (pathOp.equals("//")){
            return new SlashExpr(left,right, SlashStatus.DOUBLE_SLASH);
        } else {
            return new SlashExpr(left,right, SlashStatus.SINGLE_SLASH);
        }
    }

    @Override
    public Expression visitTagnameRp(XPathParser.TagnameRpContext ctx) {
        String tagname = ctx.tagName().getText();
        return new TagExpr(tagname);
    }

    @Override
    public Expression visitTextRp(XPathParser.TextRpContext ctx) {
        return new GetTextExpr();
    }

    @Override
    public Expression visitFilterRp(XPathParser.FilterRpContext ctx) {
        return new FilterExpr(visit(ctx.rp()),visit(ctx.filter()));
    }

    @Override
    public Expression visitAttrRp(XPathParser.AttrRpContext ctx) {
        return new AttrExpr(ctx.attName().getText());
    }

    @Override
    public Expression visitBracketRp(XPathParser.BracketRpContext ctx) {
        return visit(ctx.rp());
    }

    @Override
    public Expression visitParentRp(XPathParser.ParentRpContext ctx) {
        return new ParentExpr();
    }

    @Override
    public Expression visitCommaRp(XPathParser.CommaRpContext ctx) {
        Expression left = visit(ctx.rp(0));
        Expression right = visit(ctx.rp(1));
        return new ComaExpr(left,right);
    }

    @Override
    public Expression visitSelfRp(XPathParser.SelfRpContext ctx) {
        return new SelfExpr();
    }

    @Override
    public Expression visitUnaryFta(XPathParser.UnaryFtaContext ctx) {
        return new SingleFltr(visit(ctx.rp()));
    }

    @Override
    public Expression visitBinaryFt(XPathParser.BinaryFtContext ctx) {
        return new BinaryEqualsFltr(visit(ctx.rp(0)),visit(ctx.rp(1)));
    }

    @Override
    public Expression visitNegFt(XPathParser.NegFtContext ctx) {
        return new NegFltr(visit(ctx.filter()));
    }

    @Override
    public Expression visitStrEqFt(XPathParser.StrEqFtContext ctx) {
        String str = ctx.stringCondition().getText();
        str = str.substring(1,str.length()-1);
        return new BinaryConstEqualsFltr(visit(ctx.rp()),str);
    }

    @Override
    public Expression visitCompoundFt(XPathParser.CompoundFtContext ctx) {
        Expression leftFt = visit(ctx.filter(0));
        Expression rightFt = visit(ctx.filter(1));
        switch (ctx.filterOp().getText()){
            case "and":
                return new AndFltr(leftFt,rightFt);
            case "or":
                return new OrFltr(leftFt,rightFt);
            default:
                throw new RuntimeException("There is some bug in code, this should not happen!!!");
        }
    }

    @Override
    public Expression visitBracketFt(XPathParser.BracketFtContext ctx) {
        return visit(ctx.filter());
    }
}
