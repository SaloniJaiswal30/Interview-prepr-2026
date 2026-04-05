package graph;

import java.util.*;

public class BipartiteDFS {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        for (int k = 0; k < v; k++) {
            if (color[k] == 0) {
                color[k] = -1;
                if (!dfs(k, graph, color))
                    return false;
            }
        }
        return true;
    }

    public boolean dfs(int index, int[][] graph, int[] color) {
        int[] list = graph[index];
        for (int i : list) {
            int toggle = color[index] * -1;
            if (color[i] == 0) {
                color[i] = toggle;
                if (!dfs(i, graph, color))
                    return false;
            } else if (color[i] != toggle)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteDFS solution = new BipartiteDFS();
        int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println("Is Bipartite: " + solution.isBipartite(graph1));

        int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println("Is Bipartite: " + solution.isBipartite(graph2));
    }
}

