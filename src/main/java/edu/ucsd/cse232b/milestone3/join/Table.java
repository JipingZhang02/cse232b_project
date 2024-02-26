package edu.ucsd.cse232b.milestone3.join;

import edu.ucsd.cse232b.common.Util;
import org.w3c.dom.Node;

import java.util.*;

// This class is made default, not public, because only JoinXq in the same folder is expected to use this class
class Table {
    static class DataRow {
        final List<String> values = new ArrayList<>();
        final Node w3cNode;

        DataRow(Node w3cNode) {
            this.w3cNode = w3cNode;
        }
    }

    Map<String, Integer> schema = new HashMap<>();
    List<DataRow> data = new ArrayList<>();

    private Table() {

    }

    Table(List<Node> w3cNodeList) {
        if (w3cNodeList.isEmpty()) {
            return;
        }

        Node firstNode = w3cNodeList.get(0); // use first node to build schema
        int i = 0;
        for (Node child : Util.toJavaBuiltinList(firstNode.getChildNodes())) {
            String columnName = child.getNodeName();
            schema.put(columnName, i);
            i++;
        }

        for (Node node : w3cNodeList) {
            DataRow row = new DataRow(node);
            List<String> rowValues = row.values;
            for (int j = 0; j < i; j++) {
                rowValues.add("");
            }
            for (Node child : Util.toJavaBuiltinList(node.getChildNodes())) {
                String columnName = child.getNodeName();
                String columnValue = child.getTextContent();
                if (!schema.containsKey(columnName)) {
                    throw new RuntimeException(String.format("column name: %s  not in schema", columnName));
                }
                rowValues.set(schema.get(columnName), columnValue); // maybe columns appear in different order
            }
            data.add(row);
        }
    }

    private ArrayList<DataRow>[] putIntoBuckets(List<String> joinOnColumns, int bucketsCnt) {
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
                hashCode = hashCode * 1009 + dataRow.values.get(schema.get(joinOnColumn)).hashCode(); // 1009 is just the first prime come to my mind hhh
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
            res.add(row.w3cNode);
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

                    List<Node> allColumnNodes = Util.toJavaBuiltinList(rowL.w3cNode.getChildNodes());
                    allColumnNodes.addAll(Util.toJavaBuiltinList(rowR.w3cNode.getChildNodes()));
                    Node joinedRowNode = Util.assembleNode("tuple",allColumnNodes);
                    DataRow joinedRow = new DataRow(joinedRowNode);
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
}
