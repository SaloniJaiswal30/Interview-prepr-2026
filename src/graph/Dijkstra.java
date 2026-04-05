package graph;

import java.util.*;

public class Dijkstra {
    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> arr = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            arr.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            arr.get(e[0]).add(new Pair(e[1], e[2]));
            arr.get(e[1]).add(new Pair(e[0], e[2]));
        }

        int[] resultdist = new int[V];
        Arrays.fill(resultdist, Integer.MAX_VALUE);
        resultdist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for (Pair list : arr.get(p.node)) {
                if (resultdist[list.node] > (resultdist[p.node] + list.dist)) {
                    resultdist[list.node] = resultdist[p.node] + list.dist;
                    pq.add(new Pair(list.node, resultdist[list.node]));
                }
            }
        }
        return resultdist;
    }

    public static void main(String[] args) {
        Dijkstra solution = new Dijkstra();
        int V = 4;
        int[][] edges = {{0, 1, 4}, {0, 2, 1}, {2, 1, 2}, {1, 3, 1}, {2, 3, 5}};
        int[] result = solution.dijkstra(V, edges, 0);
        System.out.println("Shortest distances from source 0: " + Arrays.toString(result));
    }
}

