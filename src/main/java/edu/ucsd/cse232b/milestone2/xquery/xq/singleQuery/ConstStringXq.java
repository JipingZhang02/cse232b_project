package edu.ucsd.cse232b.milestone2.xquery.xq.singleQuery;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.Util;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Map;

public class ConstStringXq implements XQuery {
    private final String stringValue;

    public ConstStringXq(String stringValue) {
        if (stringValue.length()>=2&&stringValue.startsWith("\"")&&stringValue.endsWith("\"")){
            stringValue = stringValue.substring(1,stringValue.length()-1);
        }
        this.stringValue = stringValue;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) {
        return new EvalResult(Arrays.asList(Util.createTextNode(stringValue)), SlashStatus.NONE);
    }

    @Override
    public XQuery substitute(XQuery originXQuery, XQuery newXQuery) {
        return this;
    }

    @Override
    public String toString(){
        return "\""+stringValue+"\"";
    }
}
