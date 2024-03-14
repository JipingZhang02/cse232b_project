package edu.ucsd.cse232b.common;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
   A slightly modified pat h compression UnionFindSet,
   Where the represent of a disjoint part is always the smallest index node in that part
 */
public class UnionFindSet {
    private final int[] parent;

    public UnionFindSet(int size) {
        this.parent = new int[size];
        Arrays.fill(parent,-1);
    }

    public int findRepresent(int i){
        List<Integer> path = new ArrayList<>();
        while (parent[i]!=-1){
            path.add(i);
            i=parent[i];
        }
        for (int node:path){
            parent[node]=i;
        }
        return i;
    }

    public void union(int i,int j){
        int repI = findRepresent(i);
        int repJ = findRepresent(j);
        if (repI==repJ){
            return;
        }
        if (repI>repJ){
            repJ+=repI;
            repI=repJ-repI;
            repJ-=repI;
        }
        parent[repJ]=repI;
    }
}
