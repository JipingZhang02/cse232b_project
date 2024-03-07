package edu.ucsd.cse232b.milestone1.expression.absPathExpr;

import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.milestone1.expression.EvalResult;
import edu.ucsd.cse232b.milestone1.expression.Expression;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;

public class AbsPath implements Expression{
    protected final Expression relPath;
    private final String fileName;
    private final int slash;

    public AbsPath(Expression relPath, String fileName) {
        this(relPath,fileName, SlashStatus.NONE);
    }

    public AbsPath(Expression relPath, String fileName, int slash) {
        this.relPath = relPath;
        this.fileName = fileName;
        this.slash = slash;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File xmlFile = new File(fileName);
        Document doc = builder.parse(xmlFile);
        Util.setDoc(doc);
        EvalResult initial = new EvalResult(Arrays.asList(doc.getDocumentElement()), slash);
        return relPath.evaluate(initial);
    }

    @Override
    public String toString(){
        return String.format("doc(\"%s\")%s%s",fileName,SlashStatus.toString(slash),relPath.toString());
    }
}
