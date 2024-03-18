package edu.ucsd.cse232b.milestone3;

import edu.ucsd.cse232b.autogen.XQueryParser;
import edu.ucsd.cse232b.common.Pair;
import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.UnionFindSet;
import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.milestone1.xpath.path.binaryPath.SlashPath;
import edu.ucsd.cse232b.milestone1.xpath.path.singlePath.StarPath;
import edu.ucsd.cse232b.milestone1.xpath.path.singlePath.TagPath;
import edu.ucsd.cse232b.milestone3.join.JoinXq;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import edu.ucsd.cse232b.milestone2.xquery.xq.XQueryBuilderTool;
import edu.ucsd.cse232b.milestone2.xquery.xq.binaryQuery.CommaXQuery;
import edu.ucsd.cse232b.milestone2.xquery.xq.binaryQuery.XQSlashRP;
import edu.ucsd.cse232b.milestone2.xquery.condition.Condition;
import edu.ucsd.cse232b.milestone2.xquery.condition.EqCondition;
import edu.ucsd.cse232b.milestone2.xquery.condition.True;
import edu.ucsd.cse232b.milestone2.xquery.condition.conjunctCondition.AndCondition;
import edu.ucsd.cse232b.milestone2.xquery.xq.singleQuery.TagGeneratorXQuery;
import edu.ucsd.cse232b.milestone2.xquery.xq.singleQuery.VarXq;
import edu.ucsd.cse232b.milestone2.XQueryBuilder;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class Ms3XQueryBuilder extends XQueryBuilder {
    public static final Ms3XQueryBuilder INSTANCE = new Ms3XQueryBuilder();

    private Ms3XQueryBuilder(){

    }

    private static List<String> getVarNames(XQueryParser.VariableListContext ctx){
        XQueryParser.VariablesContext varsCtx = ctx.variables();
        if (varsCtx==null|| varsCtx.isEmpty()){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        for (TerminalNode varName:varsCtx.ID()){
            res.add(varName.getText());
        }
        return res;
    }

    @Override
    public Pair<XQuery, Condition> visitJoinXq(XQueryParser.JoinXqContext ctx) {
        XQuery leftTable = visit(ctx.joinClause().xq(0)).left;
        XQuery rightTable = visit(ctx.joinClause().xq(1)).left;
        List<String> joinOnColsL = getVarNames(ctx.joinClause().variableList(0));
        List<String> joinOnColsR = getVarNames(ctx.joinClause().variableList(1));
        XQuery resXq = new JoinXq(leftTable,rightTable,joinOnColsL,joinOnColsR);
        return new Pair<>(resXq,null);
    }

    @Override
    public Pair<XQuery, Condition> visitForXq(XQueryParser.ForXqContext ctx) {
        List<String> forVarNames = new ArrayList<>();
        for (TerminalNode tmNode : ctx.forClause().VAR()) {
            forVarNames.add(tmNode.getText());
        }
        List<XQuery> forAssignValXqs = new ArrayList<>();
        for (XQueryParser.XqContext xqCtx : ctx.forClause().xq()) {
            forAssignValXqs.add(visit(xqCtx).left);
        }
        List<String> letVarNames = new ArrayList<>();
        List<XQuery> letAssignValXqs = new ArrayList<>();
        if (ctx.letClause() != null) {
            for (TerminalNode tmNode : ctx.letClause().VAR()) {
                letVarNames.add(tmNode.getText());
            }
            for (XQueryParser.XqContext xqCtx : ctx.letClause().xq()) {
                letAssignValXqs.add(visit(xqCtx).left);
            }
        }
        Condition whereCondition = new True();
        if (ctx.whereClause() != null) {
            whereCondition = visit(ctx.whereClause().cond()).right;
        }
        XQuery returnClause = visit(ctx.returnClause().xq()).left;
        forVarNames = Util.removeDollarAndAtSign(forVarNames);
        letVarNames = Util.removeDollarAndAtSign(letVarNames);
        if (!letVarNames.isEmpty()) { // needn't optimize if let clauses exist
            XQuery res = XQueryBuilderTool.buildForClause(forVarNames, forAssignValXqs, letVarNames, letAssignValXqs, whereCondition, returnClause,true);
            return new Pair<>(res, null);
        }
        try {
            XQuery res = tryOptimizeImplicitJoin(forVarNames, forAssignValXqs, whereCondition, returnClause);
            return new Pair<>(res, null);
        } catch (CannotOptimizeException exception) {
            String msg = exception.getMessage();
            System.out.println();
            System.out.println("can not optimize for query to join:");
            System.out.println(ctx.getText());
            System.out.println("because:"+msg);
            System.out.println();
            XQuery res = XQueryBuilderTool.buildForClause(forVarNames, forAssignValXqs, letVarNames, letAssignValXqs, whereCondition, returnClause,true);
            return new Pair<>(res, null);
        }
    }

    private static class CannotOptimizeException extends Exception {
        public CannotOptimizeException() {
        }

        public CannotOptimizeException(String message) {
            super(message);
        }

        public CannotOptimizeException(String message, Throwable cause) {
            super(message, cause);
        }

        public CannotOptimizeException(Throwable cause) {
            super(cause);
        }

        public CannotOptimizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

    private static void getAllSubConditions(Condition condition, List<EqCondition> res) throws CannotOptimizeException {
        if (condition instanceof True) {
            return;
        }
        if (condition instanceof EqCondition) {
            res.add((EqCondition) condition);
            return;
        }
        if (condition instanceof AndCondition) {
            AndCondition andCondition = (AndCondition) condition;
            getAllSubConditions(andCondition.getLeftCondition(), res);
            getAllSubConditions(andCondition.getRightCondition(), res);
            return;
        }
        throw new CannotOptimizeException();
    }

    private static List<EqCondition> getAllSubConditions(Condition condition) throws CannotOptimizeException {
        List<EqCondition> res = new ArrayList<>();
        getAllSubConditions(condition, res);
        return res;
    }

    /*
        This function returns the variable name of left most sub expression,
            and returns null if left most is not a variable
            for example, getLeftMostVarName($var/book/title)=var
                         getLeftMostVarName(doc("bookstore.xml")/book)=null
     */
    private static String getLeftMostVarName(XQuery XQuery) {
        if (XQuery instanceof VarXq) {
            return ((VarXq) XQuery).getVarName();
        }
        if (XQuery instanceof XQSlashRP) {
            return getLeftMostVarName(((XQSlashRP) XQuery).getQuery());
        }
        return null;
    }

    private static XQuery tryOptimizeImplicitJoin(List<String> forVarNames, List<XQuery> forAssignValXqs, Condition whereCondition, XQuery returnClause) throws CannotOptimizeException {
        List<EqCondition> eqConditions = getAllSubConditions(whereCondition);
        if (eqConditions.isEmpty()) {
            throw new CannotOptimizeException("cannot optimize because no equal condition exists");
        }

        List<String> tableNames = new ArrayList<>();
        List<XQuery> tableGenerators = new ArrayList<>();
        List<List<String>> columnsInEachTable = new ArrayList<>();
        List<List<XQuery>> columnGeneratorsEachTable = new ArrayList<>();
        Map<String, Integer> colNameToTableIdx = new HashMap<>();
        List<Condition> outerConditions = new ArrayList<>();

        /*
        The following loop records the schema of each table


        for each '$var in xq' sub-expression in for clause, we should consider 3 cases:

        case 1 : xq is an absolute-path,
                 or xq start with some $var_o (e.g. $var_o/BOOK/AUTHOR) and $var_o is defined in outer scope
                    In this case we should treat $var as a table

        case 2 : xq starts with some $var_t where $var_t is treated as table t
                    In this case we should treat $var as a column of t

        case 3 : xq starts with some $var_c where $var_c is treated as column c of table t
                    In this case we should treat $var also as a column of t
                    In this case, $var_c can be interpreted as the composite attribute of a database table
                        while $var
                        for example, for $var_t in doc("books.xml")/AUTHORS,
                                         $var_c in $var_t/NAME,
                                         $var_c1 in $var_c/FIRSTNAME,
                                         $var_c2 in $var_c/LASTNAME
                        in this example, $var_c1 and $var_c2 falls in case 3
         */
        for (int i = 0; i < forVarNames.size(); i++) {
            String forVarName = forVarNames.get(i);
            XQuery forAssignValGenerator = forAssignValXqs.get(i);
            String leftMostVarNameInGenerator = getLeftMostVarName(forAssignValGenerator);
            if (leftMostVarNameInGenerator == null || (!tableNames.contains(leftMostVarNameInGenerator) && !colNameToTableIdx.containsKey(leftMostVarNameInGenerator))) {
                // treat this ($var in xq) clause as a new table
                tableNames.add(forVarName);
                tableGenerators.add(forAssignValGenerator);
                List<String> colNamesThisTable = new ArrayList<>();
                List<XQuery> colGensThisTable = new ArrayList<>();
                colNameToTableIdx.put(forVarName,colNameToTableIdx.size());
/*                colNamesThisTable.add(forVarName);
                colGensThisTable.add(new VarXq(forVarName));*/
                columnsInEachTable.add(colNamesThisTable);
                columnGeneratorsEachTable.add(colGensThisTable);
            } else if (tableNames.contains(leftMostVarNameInGenerator)) {
                int tableIdx = tableNames.indexOf(leftMostVarNameInGenerator);
                // treat this ($var in xq) clause as a column of the tableIdx-th table
                columnsInEachTable.get(tableIdx).add(forVarName);
                columnGeneratorsEachTable.get(tableIdx).add(forAssignValGenerator);
                colNameToTableIdx.put(forVarName, tableIdx);
            } else {
                // case 3, colNameToTableIdx.containsKey(leftMostVarNameInGenerator)
                int tableIdx = colNameToTableIdx.get(leftMostVarNameInGenerator);
                // treat this ($var in xq) clause as a column of the tableIdx-th table
                columnsInEachTable.get(tableIdx).add(forVarName);
                columnGeneratorsEachTable.get(tableIdx).add(forAssignValGenerator);
                colNameToTableIdx.put(forVarName, tableIdx);
            }
        }

        System.out.print("");// for debug

        int tableCnt = tableNames.size();
        if (tableCnt < 2) {
            throw new CannotOptimizeException("only 1 table can be extracted, so no need to optimize to join");
        }

        // EqCondition for each single table
        // for example, EqCondition that the "username" column of table 1 = "Tom"
        // or , EqCondition that the "username" column of table 1 = $var1 , where $var1 is defined outer of this for clause
        List<EqCondition>[] eqConditionsEachTable = new List[tableCnt];
        for (int i = 0; i < tableCnt; i++) {
            eqConditionsEachTable[i] = new ArrayList<>();
        }

        // join on conditions between each table pair
        // note: left,right of Pair<String,String> should be in same order of joinConditions[left][right]
        // that is, elements in joinConditions[l][r] should be exactly the contrary to joinConditions[r][l]
        List<Pair<String, String>>[][] joinConditions = new List[tableCnt][tableCnt];
        for (int i = 0; i < tableCnt; i++) {
            for (int j = 0; j < tableCnt; j++) {
                joinConditions[i][j] = new ArrayList<>();
            }
        }

        for (EqCondition eqCondition : eqConditions) {
            XQuery left = eqCondition.getXqLeft();
            XQuery right = eqCondition.getXqRight();
            if (eqCondition.getEqOpType() == EqCondition.EQ_STR) {
                // when the eq operator is "eq" (for example, $var1 eq $var2), try to make it a join condition
                if (!(left instanceof VarXq)) {
                    throw new CannotOptimizeException();
                }
                if (!(right instanceof VarXq)) {
                    throw new CannotOptimizeException();
                }
                String leftVarName = ((VarXq) left).getVarName();
                String rightVarName = ((VarXq) right).getVarName();
                if (!colNameToTableIdx.containsKey(leftVarName)) {
                    throw new CannotOptimizeException();
                }
                if (!colNameToTableIdx.containsKey(rightVarName)) {
                    throw new CannotOptimizeException();
                }
                int lTableIdx = colNameToTableIdx.get(leftVarName);
                int rTableIdx = colNameToTableIdx.get(rightVarName);
                if (lTableIdx == rTableIdx) {
                    eqConditionsEachTable[lTableIdx].add(eqCondition);
                    System.out.printf("warning: in condition '$%s eq $%s', two vars are from same table.\n", leftVarName, rightVarName);
                    continue;
                }
                joinConditions[lTableIdx][rTableIdx].add(new Pair<>(leftVarName, rightVarName));
                joinConditions[rTableIdx][lTableIdx].add(new Pair<>(rightVarName, leftVarName));
            } else {
                String leftVarName = getLeftMostVarName(left);
                String rightVarName = getLeftMostVarName(right);
                if (leftVarName == null && rightVarName == null) {
                    throw new CannotOptimizeException();
                }
                int leftVarTableIdx = -1;
                if (leftVarName != null) {
                    leftVarTableIdx = tableNames.indexOf(leftVarName);
                    if (leftVarTableIdx==-1){
                        if (colNameToTableIdx.containsKey(leftVarName)){
                            leftVarTableIdx = colNameToTableIdx.get(leftVarName);
                        }
                    }
                }
                int rightVarTableIdx = -1;
                if (rightVarName != null) {
                    rightVarTableIdx = tableNames.indexOf(rightVarName);
                    if (rightVarTableIdx==-1){
                        if (colNameToTableIdx.containsKey(rightVarName)){
                            rightVarTableIdx = colNameToTableIdx.get(rightVarName);
                        }
                    }
                }
                if ((leftVarTableIdx == -1) && (rightVarTableIdx == -1)) {
                    outerConditions.add(eqCondition);
                } else if((leftVarTableIdx !=-1) && (rightVarTableIdx != -1)){
                    if (!(left instanceof VarXq)){
                        throw new CannotOptimizeException();
                    }
                    if (!(right instanceof VarXq)){
                        throw new CannotOptimizeException();
                    }
                    System.out.printf("warning: in condition %s, = is treated as eq and the whole condition is treated as join condition\n",eqCondition.toString());
                    joinConditions[leftVarTableIdx][rightVarTableIdx].add(new Pair<>(leftVarName, rightVarName));
                    joinConditions[rightVarTableIdx][leftVarTableIdx].add(new Pair<>(rightVarName, leftVarName));
                } else {
                    // treat it as a where select from a table
                    eqConditionsEachTable[leftVarTableIdx + rightVarTableIdx + 1].add(eqCondition);
                }
            }
        }

        System.out.print("");// for debug


        /*
            Next, we should use dfs to decide the joining order of tables

            That is, view relations between tables as an undirected graph,
                view table as a node on the graph
                node[i] and node[j] has an edge between them if the join condition of i and j is not empty

            Starting dfs from index-0 table may not be able to cover all tables
                because the graph may not be connected
                (that is, some pair of table are not joined on any column, they are a cardination product)
                we should try starting from every node which is not covered in dfs searching previous nodes
         */
        int[] dfsParent = new int[tableCnt];
        Arrays.fill(dfsParent, -1);
        boolean[] dfsHasFound = new boolean[tableCnt];
        Stack<Integer> dfsStack = new Stack<>();
        for (int i = 0; i < tableCnt; i++) {
            if (dfsHasFound[i]) {
                continue;
            }
            dfsStack.push(i);
            dfsHasFound[i] = true;
            while (!dfsStack.isEmpty()) {
                int nodeToVisit = dfsStack.pop();
                for (int j = 0; j < tableCnt; j++) {
                    if (dfsHasFound[j]) {
                        continue;
                    }
                    if (joinConditions[nodeToVisit][j].isEmpty()) {
                        continue; // no edge between i and j, just ignore this j
                    }
                    dfsParent[j] = nodeToVisit;
                    dfsHasFound[j] = true;
                    dfsStack.push(j);
                }
            }
        }

        System.out.print("");// for debug

        /*
            Finally, build the for $tuple in join-clause with dfs search result.
            We should first initialize tableCnt numbers of ForClauses
            Then, join each of them to its representor.
            The representor of an element is the represent of it in the UnionFindSet constructed by dfsParent
            We should note that dfsParent of 0-th node is always -1
                while other nodes' parent may also be -1
                in that case, that node is in an unconnected part to part containing node 0
                    which means they can't be joined on any column
                we should join it with the part containing node 0 at last
         */
        List<Integer> lateJoinTables = new ArrayList<>();

        // initialize tables
        XQuery[] tables = new XQuery[tableCnt];
        for (int i = 0; i < tableCnt; i++) {
            String tableName = tableNames.get(i);
            XQuery tableGenerator = tableGenerators.get(i);
            List<String> columnNames = columnsInEachTable.get(i);
            List<XQuery> columnGeneratorList = columnGeneratorsEachTable.get(i);

            if (columnNames.isEmpty()){
                throw new IllegalArgumentException();
            }

            // assemble columns with ComaXq wrapped in <tuple> tag
            XQuery tableReturnClause = new TagGeneratorXQuery(tableName,new VarXq(tableName));
            for (String columnName : columnNames) {
                tableReturnClause = new CommaXQuery(tableReturnClause, new TagGeneratorXQuery(columnName, new VarXq(columnName)));
            }
            tableReturnClause = new TagGeneratorXQuery("tuple",tableReturnClause);

            List<String> forVarNamesThisTable = new ArrayList<>();
            forVarNamesThisTable.add(tableName);
            forVarNamesThisTable.addAll(columnNames);
            List<XQuery> forGeneratorsThisTable = new ArrayList<>();
            forGeneratorsThisTable.add(tableGenerator);
            forGeneratorsThisTable.addAll(columnGeneratorList);
            Condition whereConditionThisTable = new True();
            List<EqCondition> conditionList = eqConditionsEachTable[i];
            for (Condition condition:conditionList){
                whereConditionThisTable = new AndCondition(whereConditionThisTable,condition);
            }
            tables[i] = XQueryBuilderTool.buildForClause(forVarNamesThisTable,forGeneratorsThisTable,new ArrayList<>(),new ArrayList<>(),whereConditionThisTable,tableReturnClause,true);
        }

        System.out.print("");// for debug

        /*
            do join operations with optimizations, and keep those without in lateJoinTables

            Here, I used UnionFindSet, the reason is a bit complex:
                suppose we have 4 tables,
                    (and we are using array to keep track of current JoinXq representation for each table)
                where table1 and 2 have join-on conditions
                      table2 and 3 have join-on conditions
                      table2 and 4 have join-on conditions
                      other pair of tables don't have
                first, we join table1 and 2, and we should update array[1] and array[2] to this result
                next, when we join 2 and 3, we should update array[1], [2] and [3] to this result
                    or else there will be a mistake when joining 2 and 4
                as table numbers grow, this method takes O(n^2) time,
                and the code is hard to debug
            Using UnionFindSet can avoid this trouble:
                That is, we join every table with its represent,
                and then we save the join result to the array[represent]
         */
        UnionFindSet unionFindSet = new UnionFindSet(tableCnt);
        for (int i = 0; i < tableCnt; i++) {
            int pi = dfsParent[i];
            if (pi!=-1){
                unionFindSet.union(pi,i);
            }
        }
        for (int i = 1; i < tableCnt; i++) {
            int pi = dfsParent[i];
            int repI = unionFindSet.findRepresent(i);
            if (pi==-1){
                lateJoinTables.add(i);
                continue;
            }
            List<String> joinOnColsL = new ArrayList<>(),joinOnColsR = new ArrayList<>();
            for (Pair<String,String> joinOnCol:joinConditions[pi][i]){
                joinOnColsL.add(joinOnCol.left);
                joinOnColsR.add(joinOnCol.right);
            }
            XQuery joinXq = new JoinXq(tables[repI],tables[i],joinOnColsL,joinOnColsR);
            tables[repI] = joinXq;
            for (int j = 0; j < tableCnt; j++) {
                if (j!=repI&&j!=i){
                    joinConditions[j][repI].addAll(joinConditions[j][i]);
                    joinConditions[repI][j].addAll(joinConditions[i][j]);
                }
            }
        }

        System.out.print("");// for debug

        // do join operations without optimizations
        XQuery joinXq = tables[0];
        for(int iLateJoin:lateJoinTables){
            joinXq = new JoinXq(joinXq,tables[iLateJoin]);
        }

        Condition outerCondition = new True();
        for (Condition c:outerConditions){
            outerCondition = new AndCondition(outerCondition,c);
        }

        System.out.print("");// for debug

        // finally, replace all $var_c in return-clause with $tup/var_c/*
        List<String> allInTableVarNames = new ArrayList<>(tableNames);
        for (List<String> colNames:columnsInEachTable){
            allInTableVarNames.addAll(colNames);
        }
        for (String inTableVarName:allInTableVarNames){
            XQuery original = new VarXq(inTableVarName);
            // Query newQ = XQuery.biuldQuery(String.format("$tuple/%s/*",inTableVarName));
            XQuery newQ = new XQSlashRP(new VarXq("tuple"),new SlashPath(new TagPath(inTableVarName),new StarPath(),SlashStatus.SINGLE_SLASH), SlashStatus.SINGLE_SLASH);
            outerCondition = outerCondition.substitute(original,newQ);
            returnClause = returnClause.substitute(original,newQ);
        }

        System.out.print("");// for debug

        XQuery outerFor = XQueryBuilderTool.buildForClause(Arrays.asList("tuple"),Arrays.asList(joinXq),new ArrayList<>(),new ArrayList<>(),outerCondition,returnClause,true);
        return outerFor;
    }


}
