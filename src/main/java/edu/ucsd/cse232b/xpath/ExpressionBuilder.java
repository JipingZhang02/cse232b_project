package edu.ucsd.cse232b.xpath;

import edu.ucsd.cse232b.autogen.XPathBaseVisitor;
import edu.ucsd.cse232b.autogen.XPathParser;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.expression.FilterExpr;
import edu.ucsd.cse232b.expression.absPathExpr.AbsPathDSL;
import edu.ucsd.cse232b.expression.absPathExpr.AbsPathSL;
import edu.ucsd.cse232b.expression.binaryExpr.ComaExpr;
import edu.ucsd.cse232b.expression.binaryExpr.DoubleSLExpr;
import edu.ucsd.cse232b.expression.binaryExpr.SingleSLExpr;
import edu.ucsd.cse232b.expression.singleExpr.*;

public class ExpressionBuilder extends XPathBaseVisitor<Expression> {

    @Override
    public Expression visitAp(XPathParser.ApContext ctx) {
        String filename = ctx.docName().fileName().getText();
        filename = filename.substring(1,filename.length()-1);
        String pathOp = ctx.pathOp().getText();
        Expression relPathExpr = visit(ctx.rp());
        if (pathOp.equals("//")){
            return new AbsPathDSL(filename,relPathExpr);
        } else {
            return new AbsPathSL(filename,relPathExpr);
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
            return new DoubleSLExpr(left,right);
        } else {
            return new SingleSLExpr(left,right);
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
        return super.visitUnaryFta(ctx); //todo
    }

    @Override
    public Expression visitBinaryFt(XPathParser.BinaryFtContext ctx) {
        return super.visitBinaryFt(ctx); //todo
    }

    @Override
    public Expression visitNegFt(XPathParser.NegFtContext ctx) {
        return super.visitNegFt(ctx); //todo
    }

    @Override
    public Expression visitStrEqFt(XPathParser.StrEqFtContext ctx) {
        return super.visitStrEqFt(ctx); //todo
    }

    @Override
    public Expression visitCompoundFt(XPathParser.CompoundFtContext ctx) {
        return super.visitCompoundFt(ctx); //todo
    }

    @Override
    public Expression visitBracketFt(XPathParser.BracketFtContext ctx) {
        return visit(ctx.filter());
    }

    @Override
    public Expression visitFilterOp(XPathParser.FilterOpContext ctx) {
        return super.visitFilterOp(ctx);
    }

    @Override
    public Expression visitStringCondition(XPathParser.StringConditionContext ctx) {
        return super.visitStringCondition(ctx);
    }
}
