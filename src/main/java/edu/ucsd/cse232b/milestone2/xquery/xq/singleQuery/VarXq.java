package edu.ucsd.cse232b.milestone2.xquery.xq.singleQuery;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class VarXq implements XQuery {
    private final String varName;

    public VarXq(String varName) {
        if (varName.startsWith("$")){
            System.out.printf("Warning: got an unremoved '$' when constructing variable query: %s\n",varName);
            varName = varName.substring(1);
            System.out.println("    the $is auto removed");
        }
        this.varName = varName;
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) {
        if (variables.containsKey(varName)){
            return new EvalResult(Arrays.asList(variables.get(varName)), SlashStatus.NONE);
        }
        throw new RuntimeException("variable '"+varName+"' has not been defined!");
    }

    @Override
    public XQuery substitute(XQuery originXQuery, XQuery newXQuery) {
        return this.equals(originXQuery)? newXQuery :this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VarXq varXq = (VarXq) o;
        return Objects.equals(varName, varXq.varName);
    }

    @Override
    public String toString(){
        return "$"+varName;
    }
}
