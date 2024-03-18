package edu.ucsd.cse232b.milestone2.xquery.xq.binaryQuery;

import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import org.w3c.dom.Node;

import java.util.Map;

public class XQSlashRP implements XQuery {
    protected XQuery XQuery;
    protected final XPath relPath;
    private final int slashStatus;

    public XQSlashRP(XQuery XQuery, XPath relPath, int slashStatus) {
        this.XQuery = XQuery;
        this.relPath = relPath;
        this.slashStatus = slashStatus;
    }

    public XQuery getQuery() {
        return XQuery;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        EvalResult leftRes = XQuery.evaluate(input, variables);


        leftRes.slashStatus = slashStatus;
        return relPath.evaluate(leftRes);
    }

    @Override
    public XQuery substitute(XQuery originXQuery, XQuery newXQuery) {
        XQuery = XQuery.substitute(originXQuery, newXQuery);
        return this;
    }

    @Override
    public String toString(){
        return String.format("%s%s%s", XQuery.toString(), SlashStatus.toString(slashStatus),relPath.toString());
    }
}
