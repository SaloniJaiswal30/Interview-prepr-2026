package graph;

import java.util.*;

public class UndirectedGraphCycle {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(adj, i, -1, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int index, int parent,
                       boolean[] visited) {
        ArrayList<Integer> list = adj.get(index);
        for (int i = 0; i < list.size(); i++) {
            if (!visited[list.get(i)]) {
                visited[list.get(i)] = true;
                if (dfs(adj, list.get(i), index, visited))
                    return true;
            } else if (list.get(i) != parent)
                return true;
        }
        return false;
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int index,
                       boolean[] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(index, -1));
        while (!q.isEmpty()) {
            Pair top = q.poll();
            for (int node : adj.get(top.x)) {
                if (!visited[node]) {
                    visited[node] = true;
                    q.offer(new Pair(node, top.x));
                } else if (top.y != node) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UndirectedGraphCycle solution = new UndirectedGraphCycle();
        int V = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println("Has Cycle: " + solution.isCycle(V, edges));

        int V2 = 3;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Has Cycle: " + solution.isCycle(V2, edges2));
    }
}

