package edu.ucsd.cse232b.milestone1.xpath.path.binaryPath;

import edu.ucsd.cse232b.milestone1.xpath.XPath;
import edu.ucsd.cse232b.milestone1.xpath.path.singlePath.SelfPath;

public abstract class BinaryPath implements XPath {
    protected XPath left,right;

    public BinaryPath(XPath left, XPath right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public XPath removeLeftmostSelfExpr() {
        if (this.left instanceof SelfPath){
            return this.right;
        } else {
            this.left = this.left.removeLeftmostSelfExpr();
            return this;
        }
    }
}
