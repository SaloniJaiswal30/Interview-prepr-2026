package graph;

import java.util.*;

public class TopologicalSortBFS {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
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
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
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
        return result;
    }

    public static void main(String[] args) {
        TopologicalSortBFS solution = new TopologicalSortBFS();
        int V = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        ArrayList<Integer> result = solution.topoSort(V, edges);
        System.out.println("Topological Sort (BFS): " + result);
    }
}

