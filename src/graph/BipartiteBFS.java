package graph;

import java.util.*;

public class BipartiteBFS {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];

        for (int k = 0; k < v; k++) {
            Queue<Integer> q = new ArrayDeque<>();
            if (color[k] == 0) {
                q.offer(k);
                color[k] = -1;
                while (!q.isEmpty()) {
                    int top = q.poll();
                    for (int i : graph[top]) {
                        int toggle = color[top] * -1;
                        if (color[i] == 0) {
                            q.offer(i);
                            color[i] = toggle;
                        } else if (color[i] != toggle)
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteBFS solution = new BipartiteBFS();
        int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println("Is Bipartite: " + solution.isBipartite(graph1));

        int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println("Is Bipartite: " + solution.isBipartite(graph2));
    }
}

