package dsa.Tree;
import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if(root!= null)q.offer(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list = new ArrayList<>();
            while(size>0){
                if(!reverse){
                    TreeNode top = q.pollFirst();
                    list.add(top.val);
                    if(top.left!=null){
                        q.offerLast(top.left);
                    }
                    if(top.right!=null){
                        q.offerLast(top.right);
                    }
                }
                else{
                    TreeNode top = q.pollLast();
                    list.add(top.val);
                    if(top.right!=null){
                        q.offerFirst(top.right);
                    }
                    if(top.left!=null){
                        q.offerFirst(top.left);
                    }
                }
                size--;
            }
            result.add(list);
            reverse=!reverse;
        }
        return result;
    }
}
