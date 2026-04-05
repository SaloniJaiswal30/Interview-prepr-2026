package graph;

import java.util.*;

public class DFSTraversal {
    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        set.add(0);
        dfsHelper(0, adj, result, set);
        return result;
    }

    public static void dfsHelper(int index, ArrayList<ArrayList<Integer>> adj,
                                 ArrayList<Integer> result, Set<Integer> set) {
        ArrayList<Integer> list = adj.get(index);
        for (int i = 0; i < list.size(); i++) {
            if (!set.contains(list.get(i))) {
                result.add(list.get(i));
                set.add(list.get(i));
                dfsHelper(list.get(i), adj, result, set);
            }
        }
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

        ArrayList<Integer> result = dfs(adj);
        System.out.println("DFS Traversal: " + result);
    }
}

