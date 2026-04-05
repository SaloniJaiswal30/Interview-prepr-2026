package graph;

import java.util.*;

public class DirectedGraphCycleBFS {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        int[] indegree = new int[V];
        for (int[] edge : edges) {
            indegree[edge[1]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        ArrayList<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int top = q.poll();
            result.add(top);
            for (int i : adj.get(top)) {
                indegree[i]--;
                if (indegree[i] == 0)
                    q.offer(i);
            }
        }

        return result.size() < V ? true : false;
    }

    public static void main(String[] args) {
        DirectedGraphCycleBFS solution = new DirectedGraphCycleBFS();
        int V = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println("Has Cycle: " + solution.isCyclic(V, edges));

        int V2 = 3;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Has Cycle: " + solution.isCyclic(V2, edges2));
    }
}

