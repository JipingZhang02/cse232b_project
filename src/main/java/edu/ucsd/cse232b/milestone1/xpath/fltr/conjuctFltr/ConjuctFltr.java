package edu.ucsd.cse232b.milestone1.xpath.fltr.conjuctFltr;

import edu.ucsd.cse232b.milestone1.xpath.XPath;

import java.util.Objects;

public abstract class ConjuctFltr implements XPath {
    protected final XPath leftXPath;
    protected final XPath rightXPath;

    public ConjuctFltr(XPath leftXPath, XPath rightXPath) {
        Objects.requireNonNull(leftXPath, "Left expression is null!");
        Objects.requireNonNull(rightXPath, "Right expression is null!");
        this.leftXPath = leftXPath;
        this.rightXPath = rightXPath;
    }
}

