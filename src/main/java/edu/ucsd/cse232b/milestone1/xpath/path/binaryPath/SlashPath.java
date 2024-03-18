package edu.ucsd.cse232b.milestone1.xpath.path.binaryPath;

import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;

public class SlashPath extends BinaryPath {
    private final int slashStatus;

    public SlashPath(XPath left, XPath right, int slashStatus) {
        super(left, right);
        this.slashStatus = slashStatus;
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        EvalResult leftRes = left.evaluate(input);
        leftRes.slashStatus = slashStatus;
        return right.evaluate(leftRes);
    }

    @Override
    public String toString(){
        return left.toString()+ SlashStatus.toString(slashStatus)+right.toString();
    }
}
