package graph.topo_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TopoSort {

    // Here we implement the kahns' algorithm
    public void kahnsAlgo(List<Integer> adj[]) {
        int n = adj.length;
        // 
        int inDegree[] = new int[n];
        for(int i = 0; i < n; i++) {
            for(int node: adj[i]) inDegree[node]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(q.size() > 0) {
            int node = q.poll();
            ans.add(node);
            for(int nextNode: adj[node]) {
                if(--inDegree[nextNode] == 0) {
                    q.add(nextNode);
                }
            }
        }
        System.out.println(ans);
    }
    
}
