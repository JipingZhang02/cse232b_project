package edu.ucsd.cse232b.expression;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class EvalResult {
    public List<Node> nodes=new ArrayList<>();
    public int slashStatus;

    public EvalResult() {
    }

    public EvalResult(List<Node> nodes, int slashStatus) {
        this.nodes = nodes;
        this.slashStatus = slashStatus;
    }
}
