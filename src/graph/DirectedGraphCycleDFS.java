package graph;

import java.util.*;

public class DirectedGraphCycleDFS {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[V];
        boolean[] dfsvisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfsvisited[i] = true;
                if (dfs(adj, i, visited, dfsvisited))
                    return true;
                dfsvisited[i] = false;
            }
        }
        return false;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int index,
                       boolean[] visited, boolean[] dfsvisited) {
        ArrayList<Integer> list = adj.get(index);
        for (int node : list) {
            if (!visited[node]) {
                visited[node] = true;
                dfsvisited[node] = true;
                if (dfs(adj, node, visited, dfsvisited))
                    return true;
                dfsvisited[node] = false;
            } else if (dfsvisited[node]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DirectedGraphCycleDFS solution = new DirectedGraphCycleDFS();
        int V = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println("Has Cycle: " + solution.isCyclic(V, edges));

        int V2 = 3;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Has Cycle: " + solution.isCyclic(V2, edges2));
    }
}

