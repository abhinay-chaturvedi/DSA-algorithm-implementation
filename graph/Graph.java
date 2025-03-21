package graph;

import java.util.ArrayList;
import java.util.List;

import graph.articulation_point.ArticulationPoint;
import graph.bridges_in_graph.BridgesInGraph;
import graph.topo_sort.TopoSort;

public class Graph {
    private void runTopoSort() {
        System.out.println("hi");
        int n = 5;
        @SuppressWarnings("unchecked")
        List<Integer> adj[] = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        int edges[][] = new int[][]{{2, 1},{2, 0}, {2, 3}, {3, 4}, {0,1}};
        for(int edge[]: edges) {
            adj[edge[0]].add(edge[1]);
        }
        TopoSort topoSort = new TopoSort();
        topoSort.kahnsAlgo(adj);

    }
    private void runBridgeAlgo() {
        int n = 4;
        List<List<Integer>> list= new ArrayList<>();
        list.add(new ArrayList<>(List.of(0, 1)));
        list.add(new ArrayList<>(List.of(1, 2)));
        list.add(new ArrayList<>(List.of(2, 0)));
        list.add(new ArrayList<>(List.of(1, 3)));
        BridgesInGraph bridgesInGraph = new BridgesInGraph(n, list);
        System.out.println(bridgesInGraph.getBridges());
    }
    private void runArticulationPointAlgo() {
        int n = 4;
        List<List<Integer>> list= new ArrayList<>();
        list.add(new ArrayList<>(List.of(0, 1)));
        list.add(new ArrayList<>(List.of(1, 2)));
        list.add(new ArrayList<>(List.of(2, 0)));
        list.add(new ArrayList<>(List.of(1, 3)));
        ArticulationPoint articulationPoint = new ArticulationPoint(n, list);
        System.out.println(articulationPoint.getArticulationPoints());
    }
    public static void main(String[] args) {
        // n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
        Graph graph = new Graph();
        // graph.runBridgeAlgo();
        // graph.runArticulationPointAlgo();
        graph.runTopoSort();
    }
}
