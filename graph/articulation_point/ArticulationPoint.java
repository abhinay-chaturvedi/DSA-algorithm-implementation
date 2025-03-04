package graph.articulation_point;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

public class ArticulationPoint {
    private List<Integer> adj[];
    private int timer;
    private boolean vis[];
    private int tin[];
    private int low[];
    List<Integer> ans;
    @SuppressWarnings("unchecked")
    public ArticulationPoint(int n, List<List<Integer>> edges) {
        this.timer = 0;
        vis = new boolean[n];
        tin = new int[n];
        low = new int[n];
        adj = new List[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(List<Integer> edge: edges) {
            int u = edge.get(0), v = edge.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }
    }
    public List<Integer> getArticulationPoints() {
        ans = new ArrayList<>();
        dfs(0, -1);
        return ans;
    }
    private void dfs(int u, int par) {
        vis[u] = true;
        tin[u] = low[u] = timer++;
        int children = 0;
        for(int v: adj[u]) {
            if(v == par) continue;
            if(vis[v]) {
                low[u] = Math.min(low[u], tin[v]);
            } else {
                dfs(v, u);
                children++;
                low[u] = Math.min(low[u], low[v]);
                if(low[v] >= tin[u] && par != -1) {
                    ans.add(u);
                }
            }
        }
        if(par == -1 && children > 1) ans.add(u);
    }

}
