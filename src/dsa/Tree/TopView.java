package dsa.Tree;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
   TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
        this.left = left;
        this.right = right;
     }
}
class PairTop {
    Node n;
    int d;
    PairTop(Node n, int d){
        this.n= n;
        this.d = d;
    }
}
class TopView {
    public ArrayList<Integer> topView(Node root) {
        if(root==null)
            return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<PairTop> q = new ArrayDeque<>();
        q.offer(new PairTop(root,0));
        Map<Integer,Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            PairTop top = q.poll();
            if(!map.containsKey(top.d)){
                map.put(top.d, top.n.data);
            }
            if(top.n.left!= null){
                q.offer(new PairTop(top.n.left,top.d-1));
            }
            if(top.n.right!= null){
                q.offer(new PairTop(top.n.right,top.d+1));
            }
        }

        for(int val : map.values()){
            result.add(val);
        }
        return result;
    }
}

