package graph;

import java.util.*;

public class BFSTraversal {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int index = q.poll();
            list.add(index);
            for (int i : adj.get(index)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).addAll(Arrays.asList(0, 3));
        adj.get(2).addAll(Arrays.asList(0, 4));
        adj.get(3).addAll(Arrays.asList(1));
        adj.get(4).addAll(Arrays.asList(2));

        ArrayList<Integer> result = bfs(adj);
        System.out.println("BFS Traversal: " + result);
    }
}

