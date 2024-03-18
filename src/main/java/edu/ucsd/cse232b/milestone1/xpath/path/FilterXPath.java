package edu.ucsd.cse232b.milestone1.xpath.path;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;

import java.util.Objects;

public class FilterXPath implements XPath {
    private final XPath expr,ft;

    public FilterXPath(XPath expr, XPath ft) {
        this.expr = expr;
        Objects.requireNonNull(ft, "filter is NULL!");
        this.ft = ft.removeLeftmostSelfExpr();
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        return ft.evaluate(expr.evaluate(input));
    }

    @Override
    public String toString(){
        return expr.toString()+"["+ft.toString()+"]";
    }
}
