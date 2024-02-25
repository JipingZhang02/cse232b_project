package edu.ucsd.cse232b.query.singleQuery;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Map;

public class VarXq implements Query {
    private final String varName;

    public VarXq(String varName) {
        if (varName.startsWith("$")){
            System.out.printf("Warning: got an unremoved '$' when constructing variable query: %s\n",varName);
            varName = varName.substring(1);
            System.out.println("    the $is auto removed");
        }
        this.varName = varName;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) {
        if (variables.containsKey(varName)){
            return new EvalResult(Arrays.asList(variables.get(varName)), SlashStatus.NONE);
        }
        throw new RuntimeException("variable '"+varName+"' has not been defined!");
        
    }

    @Override
    public String toString(){
        return "$"+varName;
    }
}
