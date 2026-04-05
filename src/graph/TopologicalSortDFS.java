package graph;

import java.util.*;

public class TopologicalSortDFS {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(adj, i, visited, s);
                s.push(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!s.isEmpty()) {
            result.add(s.pop());
        }
        return result;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int index,
                    boolean[] visited, Stack<Integer> s) {
        ArrayList<Integer> list = adj.get(index);
        for (int i : list) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(adj, i, visited, s);
                s.push(i);
            }
        }
    }

    public static void main(String[] args) {
        TopologicalSortDFS solution = new TopologicalSortDFS();
        int V = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        ArrayList<Integer> result = solution.topoSort(V, edges);
        System.out.println("Topological Sort (DFS): " + result);
    }
}

