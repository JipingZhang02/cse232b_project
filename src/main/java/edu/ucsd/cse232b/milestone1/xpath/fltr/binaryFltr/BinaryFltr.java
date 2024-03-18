package edu.ucsd.cse232b.milestone1.xpath.fltr.binaryFltr;

import edu.ucsd.cse232b.milestone1.xpath.XPath;

import java.util.Objects;

public abstract class BinaryFltr implements XPath {

    protected final XPath leftRp;
    protected final XPath rightRp;

    public BinaryFltr(XPath leftRp, XPath rightRp) {
        Objects.requireNonNull(leftRp, "leftRp is NULL!");
        this.leftRp = leftRp.removeLeftmostSelfExpr();
        if (rightRp!=null) {
            this.rightRp = rightRp.removeLeftmostSelfExpr();
        } else {
            this.rightRp = null;
        }
    }

}

