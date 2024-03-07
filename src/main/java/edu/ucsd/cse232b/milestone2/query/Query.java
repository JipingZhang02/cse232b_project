package edu.ucsd.cse232b.milestone2.query;

import edu.ucsd.cse232b.milestone1.expression.EvalResult;
import org.w3c.dom.Node;

import java.util.Map;

public interface Query{
    EvalResult evaluate(EvalResult input,Map<String,Node> variables) throws Exception;

    /*
        this method is only used in milestone3, optimizing implicit join
        because when optimizing implicit join,
            we should replace $var/rp in return clause with $tuple/var/star/rp (star is *)
     */
    Query substitute(Query originQuery,Query newQuery);

    default String serialize(){
        return toString();
    }
}
