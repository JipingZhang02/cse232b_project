package edu.ucsd.cse232b.milestone3.join;

import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.common.myNode.MyElementNode;
import edu.ucsd.cse232b.common.myNode.MyNode;
import org.w3c.dom.Node;

import java.util.*;

/*
    This class is made default, not public,
        because only JoinXq in the same folder is expected to use this class.

    The word or variable "table" mentioned in any other place of the project
        probably does not refer to this class
 */
class Table {
    private static class DataRow {
        final List<MyNode> values = new ArrayList<>();


        @Override
        public String toString(){
            return values.toString();
        }
    }

    Map<String, Integer> schema = new LinkedHashMap<>();
    List<DataRow> data = new ArrayList<>();


    private Table() {

    }

    Table(List<Node> w3cNodeList) {
        System.out.print("");
        if (w3cNodeList.isEmpty()) {
            return;
        }

        Node firstNode = w3cNodeList.get(0); // use first node to build schema
//        MyNode fordebug = MyNode.toMyNode(firstNode);
        int i = 0;
        for (Node child : Util.toJavaBuiltinList(firstNode.getChildNodes())) {
            String columnName = child.getNodeName();
            schema.put(columnName, i);
            i++;
        }

        for (Node node : w3cNodeList) {
            DataRow row = new DataRow();
            List<MyNode> rowValues = row.values;
            for (int j = 0; j < i; j++) {
                rowValues.add(MyNode.toMyNode(Util.createTextNode("")));
            }
            for (Node child : Util.toJavaBuiltinList(node.getChildNodes())) {
                String columnName = child.getNodeName();
                MyNode wholeChildValue = MyNode.toMyNode(child);
                List<MyNode> singleValue = ((MyElementNode)wholeChildValue).getChildren();
                if (singleValue.size()>1){
                    throw new IllegalArgumentException(String.format(
                            "The %s which is interpreted as a column should contain exactly 1 child or no child, but actually has %d",
                            wholeChildValue.toString(),
                            singleValue.size()
                            ));
                }
                if (!schema.containsKey(columnName)) {
                    throw new RuntimeException(String.format("column name: %s  not in schema", columnName));
                }
                if (!singleValue.isEmpty()) {
                    rowValues.set(schema.get(columnName), singleValue.get(0)); // maybe columns appear in different order
                }
            }
            data.add(row);
        }
    }

    private ArrayList<DataRow>[] putIntoBuckets(List<String> joinOnColumns, int bucketsCnt) {
        System.out.print("");

        for (String joinOnColumn : joinOnColumns) {
            if (!schema.containsKey(joinOnColumn)) {
                throw new IllegalArgumentException(String.format("column name: %s  not in schema", joinOnColumn));
            }
        }

        ArrayList<DataRow>[] res = new ArrayList[bucketsCnt];
        for (int i = 0; i < bucketsCnt; i++) {
            res[i] = new ArrayList<>();
        }

        for (DataRow dataRow : data) {
            int hashCode = 1;
            for (String joinOnColumn : joinOnColumns) {
                hashCode = hashCode * 1009 + dataRow.values.get(schema.get(joinOnColumn)).hashCode(); // 1009 is just the first prime number come to my mind hhh
            }
            int bucketI = hashCode % bucketsCnt;
            if (bucketI < 0) {
                bucketI += bucketsCnt;
            }
            res[bucketI].add(dataRow);
        }

        return res;
    }

    List<Node> toNodes(){
        List<Node> res = new ArrayList<>();
        for (DataRow row:data){
            List<Node> rowInnerNodes = new ArrayList<>();
            for (Map.Entry<String,Integer> entry:schema.entrySet()){
                rowInnerNodes.add(Util.assembleNode(entry.getKey(), Arrays.asList(row.values.get(entry.getValue()).toW3cNode())));
            }
            res.add(Util.assembleNode("tuple",rowInnerNodes));
        }
        return res;
    }

    static Table join2Tables(Table tableL, Table tableR, List<String> joinOnColumnL, List<String> joinOnColumnR, int bucketsCnt) {
        Table res = new Table();
        res.schema.putAll(tableL.schema);
        int lColCnt = res.schema.size();
        for (Map.Entry<String, Integer> rEntry : tableR.schema.entrySet()) {
            res.schema.put(rEntry.getKey(), rEntry.getValue() + lColCnt);
        }

        int joinCondCnt = joinOnColumnL.size();
        if (joinOnColumnR.size()!=joinCondCnt){
            throw new IllegalArgumentException();
        }

        Map<String,Integer> schemaL = tableL.schema;
        Map<String,Integer> schemaR = tableR.schema;
        ArrayList<DataRow>[] bucketsL = tableL.putIntoBuckets(joinOnColumnL, bucketsCnt);
        ArrayList<DataRow>[] bucketsR = tableR.putIntoBuckets(joinOnColumnR, bucketsCnt);
        for (int i = 0; i < bucketsCnt; i++) {
            for (DataRow rowL : bucketsL[i]) {
                for (DataRow rowR : bucketsR[i]) {
                    boolean canJoin = true;
                    for (int j = 0; j < joinCondCnt; j++) {
                        if (!Objects.equals(rowL.values.get(schemaL.get(joinOnColumnL.get(j))), rowR.values.get(schemaR.get(joinOnColumnR.get(j))))){
                            canJoin = false;
                            break;
                        }
                    }

                    if (!canJoin){
                        continue;
                    }

                    DataRow joinedRow = new DataRow();
                    joinedRow.values.addAll(rowL.values);
                    joinedRow.values.addAll(rowR.values);
                    res.data.add(joinedRow);
                }
            }
        }

        return res;
    }

    static Table join2Tables(Table tableL, Table tableR, List<String> joinOnColumnL, List<String> joinOnColumnR){
        int bucketsCnt = Math.min(tableL.data.size(),tableR.data.size());
        return join2Tables(tableL,tableR,joinOnColumnL,joinOnColumnR,bucketsCnt);
    }

    @Override
    public String toString(){
        return  "Table{ schema:"+schema.toString()+" , linesCount: "+data.size()+" }";
    }
}
