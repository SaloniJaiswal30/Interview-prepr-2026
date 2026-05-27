package dsa.Tree;
import javax.swing.tree.TreeNode;
import java.util.*;

class PairVertical{
    TreeNode node;
    int depth;
    int height;
    PairVertical(TreeNode node, int depth, int height){
        this.node = node;
        this.depth=depth;
        this.height= height;
    }
}

class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,TreeMap<Integer,ArrayList<Integer>>> map = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root,0,0));
        int minval=Integer.MAX_VALUE;
        int maxval=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            Pair top = q.poll();
            minval = top.depth<minval? top.depth:minval;
            maxval = top.depth>maxval? top.depth:maxval;

            map
                    .computeIfAbsent(top.depth,k->new TreeMap<>())
                    .computeIfAbsent(top.height,k->new ArrayList<>())
                    .add(top.node.val);

            if(top.node.left!=null){
                q.offer(new Pair(top.node.left,top.depth-1,top.height+1));
            }
            if(top.node.right!=null){
                q.offer(new Pair(top.node.right,top.depth+1,top.height+1));
            }
        }

        for(int i=minval;i<=maxval;i++){
            List<Integer> row = new ArrayList<>();
            for(List<Integer> arr:map.get(i).values()){
                Collections.sort(arr);
                row.addAll(arr);
            }
            result.add(row);
        }
        return result;
    }
}

