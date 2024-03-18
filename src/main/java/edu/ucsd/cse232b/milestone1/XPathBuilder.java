package edu.ucsd.cse232b.milestone1;

import edu.ucsd.cse232b.autogen.XPathBaseVisitor;
import edu.ucsd.cse232b.autogen.XPathParser;
import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import edu.ucsd.cse232b.milestone1.xpath.path.FilterXPath;
import edu.ucsd.cse232b.milestone1.xpath.path.absPath.AbsPath;
import edu.ucsd.cse232b.milestone1.xpath.path.binaryPath.ComaPath;
import edu.ucsd.cse232b.milestone1.xpath.path.binaryPath.SlashPath;
import edu.ucsd.cse232b.milestone1.xpath.fltr.binaryFltr.BinaryConstEqualsFltr;
import edu.ucsd.cse232b.milestone1.xpath.fltr.binaryFltr.BinaryEqualsFltr;
import edu.ucsd.cse232b.milestone1.xpath.fltr.conjuctFltr.AndFltr;
import edu.ucsd.cse232b.milestone1.xpath.fltr.conjuctFltr.OrFltr;
import edu.ucsd.cse232b.milestone1.xpath.fltr.singleFltr.NegFltr;
import edu.ucsd.cse232b.milestone1.xpath.fltr.singleFltr.SingleFltr;
import edu.ucsd.cse232b.milestone1.xpath.path.singlePath.*;

public class XPathBuilder extends XPathBaseVisitor<XPath> {
    public static final XPathBuilder INSTANCE = new XPathBuilder();

    private XPathBuilder(){
        // singleton design mode
    }


    @Override
    public XPath visitAp(XPathParser.ApContext ctx) {
        String filename = ctx.docName().fileName().getText();
        filename = filename.substring(1,filename.length()-1);
        String pathOp = ctx.pathOp().getText();
        XPath relPathExpr = visit(ctx.rp());
        if (pathOp.equals("//")){
            return new AbsPath(relPathExpr,filename, SlashStatus.DOUBLE_SLASH);
        } else {
            return new AbsPath(relPathExpr,filename, SlashStatus.SINGLE_SLASH);
        }
    }

    @Override
    public XPath visitStarRp(XPathParser.StarRpContext ctx) {
        return new StarPath();
    }

    @Override
    public XPath visitBinaryRp(XPathParser.BinaryRpContext ctx) {
        XPath left = visit(ctx.rp(0));
        XPath right = visit(ctx.rp(1));
        String pathOp = ctx.pathOp().getText();
        if (pathOp.equals("//")){
            return new SlashPath(left,right, SlashStatus.DOUBLE_SLASH);
        } else {
            return new SlashPath(left,right, SlashStatus.SINGLE_SLASH);
        }
    }

    @Override
    public XPath visitTagnameRp(XPathParser.TagnameRpContext ctx) {
        String tagname = ctx.tagName().getText();
        return new TagPath(tagname);
    }

    @Override
    public XPath visitTextRp(XPathParser.TextRpContext ctx) {
        return new GetTextPath();
    }

    @Override
    public XPath visitFilterRp(XPathParser.FilterRpContext ctx) {
        return new FilterXPath(visit(ctx.rp()),visit(ctx.filter()));
    }

    @Override
    public XPath visitAttrRp(XPathParser.AttrRpContext ctx) {
        return new AttrPath(ctx.attName().getText().substring(1)); // ignore '@' at index 0
    }

    @Override
    public XPath visitBracketRp(XPathParser.BracketRpContext ctx) {
        return visit(ctx.rp());
    }

    @Override
    public XPath visitParentRp(XPathParser.ParentRpContext ctx) {
        return new ParentPath();
    }

    @Override
    public XPath visitCommaRp(XPathParser.CommaRpContext ctx) {
        XPath left = visit(ctx.rp(0));
        XPath right = visit(ctx.rp(1));
        return new ComaPath(left,right);
    }

    @Override
    public XPath visitSelfRp(XPathParser.SelfRpContext ctx) {
        return new SelfPath();
    }

    @Override
    public XPath visitUnaryFta(XPathParser.UnaryFtaContext ctx) {
        return new SingleFltr(visit(ctx.rp()));
    }

    @Override
    public XPath visitBinaryFt(XPathParser.BinaryFtContext ctx) {
        return new BinaryEqualsFltr(visit(ctx.rp(0)),visit(ctx.rp(1)));
    }

    @Override
    public XPath visitNegFt(XPathParser.NegFtContext ctx) {
        return new NegFltr(visit(ctx.filter()));
    }

    @Override
    public XPath visitStrEqFt(XPathParser.StrEqFtContext ctx) {
        String str = ctx.stringCondition().getText();
        str = str.substring(1,str.length()-1);
        return new BinaryConstEqualsFltr(visit(ctx.rp()),str);
    }

    @Override
    public XPath visitCompoundFt(XPathParser.CompoundFtContext ctx) {
        XPath leftFt = visit(ctx.filter(0));
        XPath rightFt = visit(ctx.filter(1));
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
    public XPath visitBracketFt(XPathParser.BracketFtContext ctx) {
        return visit(ctx.filter());
    }

/*    @Override
    public Expression visitWsRp2(XPathParser.WsRp2Context ctx) {
        return visit(ctx.rp());
    }

    @Override
    public Expression visitWsRp1(XPathParser.WsRp1Context ctx) {
        return visit(ctx.rp());
    }

    @Override
    public Expression visitWsFt2(XPathParser.WsFt2Context ctx) {
        return visit(ctx.filter());
    }

    @Override
    public Expression visitWsFt1(XPathParser.WsFt1Context ctx) {
        return visit(ctx.filter());
    }*/
}
