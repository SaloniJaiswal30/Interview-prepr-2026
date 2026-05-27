package dsa.Tree;

import java.util.ArrayList;
import java.util.List;


class RootToLeaf {
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        dfs(arr, current, root);
        return arr;
    }
    void dfs(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> current,Node root){
        if(root.left==null && root.right==null){
            current.add(root.data);
            arr.add(new ArrayList<>(current));
            current.remove(current.size()-1);
            return;
        }
        current.add(root.data);
        if(root.left!=null)
            dfs(arr, current, root.left);
        if(root.right!=null)
            dfs(arr, current, root.right);
        current.remove(current.size()-1);
        return;
    }
}
