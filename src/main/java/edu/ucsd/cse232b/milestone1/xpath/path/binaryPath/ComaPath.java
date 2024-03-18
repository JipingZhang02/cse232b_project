package edu.ucsd.cse232b.milestone1.xpath.path.binaryPath;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class ComaPath extends BinaryPath {

    public ComaPath(XPath left, XPath right) {
        super(left, right);
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        EvalResult leftResult = left.evaluate(input);
        EvalResult rightResult = right.evaluate(input);
        if (leftResult.slashStatus!=rightResult.slashStatus){
            throw new RuntimeException();
        }
        List<Node> resNodes = new ArrayList<>();
        resNodes.addAll(leftResult.nodes);
        resNodes.addAll(rightResult.nodes);
        return new EvalResult(resNodes, leftResult.slashStatus);
    }

    @Override
    public XPath removeLeftmostSelfExpr() {
        this.left = this.left.removeLeftmostSelfExpr();
        this.right = this.right.removeLeftmostSelfExpr();
        return this;
    }

    @Override
    public String toString(){
        return left.toString()+","+right.toString();
    }
}
