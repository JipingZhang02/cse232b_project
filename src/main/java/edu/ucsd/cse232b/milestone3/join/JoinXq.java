package edu.ucsd.cse232b.milestone3.join;

import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class JoinXq implements XQuery {
    private final XQuery leftTableGenerator, rightTableGenerator;
    private final List<String> joinOnColumnL,joinOnColumnR;

    public JoinXq(XQuery leftTableGenerator, XQuery rightTableGenerator){
        this(leftTableGenerator,rightTableGenerator,new ArrayList<>(),new ArrayList<>());
    }

    public JoinXq(XQuery leftTableGenerator, XQuery rightTableGenerator, List<String> joinOnColumnL, List<String> joinOnColumnR) {
        this.leftTableGenerator = leftTableGenerator;
        this.rightTableGenerator = rightTableGenerator;
        this.joinOnColumnL = joinOnColumnL;
        this.joinOnColumnR = joinOnColumnR;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        Table leftTable = new Table(leftTableGenerator.evaluate(input, variables).nodes);
        Table rightTable = new Table(rightTableGenerator.evaluate(input, variables).nodes);
        Table joinedTable = Table.join2Tables(leftTable,rightTable,joinOnColumnL,joinOnColumnR);
        return new EvalResult(joinedTable.toNodes(), SlashStatus.NONE);
    }

    @Override
    public XQuery substitute(XQuery originXQuery, XQuery newXQuery) {
        return this;
    }

    @Override
    public String toString(){
        return String.format("join(\n%s,\n%s,\n    %s\n)", Util.insertTabBeforeEachLine(leftTableGenerator.toString()),Util.insertTabBeforeEachLine(rightTableGenerator.toString()),joinOnColumnL.toString()+","+joinOnColumnR.toString());
    }
}
