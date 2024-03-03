package edu.ucsd.cse232b.query;

import edu.ucsd.cse232b.expression.EvalResult;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Query{
    EvalResult evaluate(EvalResult input,Map<String,Node> variables) throws Exception;

    /*
        this method is only used in milestone3, optimizing implicit join
        because when optimizing implicit join,
            we should substitute $var/rp in return clause with $tuple/var/star/rp (star is *)
     */
    Query substitute(Query originQuery,Query newQuery);

    default String serialize(){
        return toString();
    }
}
