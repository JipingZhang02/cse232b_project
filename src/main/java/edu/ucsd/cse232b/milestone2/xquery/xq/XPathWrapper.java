package edu.ucsd.cse232b.milestone2.xquery.xq;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import org.w3c.dom.Node;

import java.util.Map;

/*
    Using adapter mode here:
        ExpressionWrapper contains an expression while implements Query.
    This class will be used when a whole absolute path in XPath is interpreted as an XQuery
 */
public class XPathWrapper implements XQuery {
    private final XPath XPath;

    public XPathWrapper(XPath XPath) {
        this.XPath = XPath;
    }

    public XPath getExpression() {
        return XPath;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        return XPath.evaluate(input);
    }

    @Override
    public XQuery substitute(XQuery originXQuery, XQuery newXQuery) {
        return this;
    }

    @Override
    public String toString(){
        return XPath.toString();
    }
}
