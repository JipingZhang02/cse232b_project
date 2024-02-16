package edu.ucsd.cse232b.expression;

import edu.ucsd.cse232b.common.Consts;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/*
   This is a class to hold the eval result of xpath or xquery.
   The idea is that we should store not only the nodes, but also the previous slash:
       whether it is / or // or not specified
 */
public class EvalResult {
    public List<Node> nodes=new ArrayList<>();
    public int slashStatus= Consts.NONE;

    public EvalResult() {
    }

    public EvalResult(List<Node> nodes, int slashStatus) {
        this.nodes = nodes;
        this.slashStatus = slashStatus;
    }
}
