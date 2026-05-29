package dsa.Tree;
import java.util.*;

class PairMaxWidth{
    TreeNode node;
    int pos;
    PairMaxWidth(TreeNode node, int pos){
        this.node = node;
        this.pos= pos;
    }
}
class MaxWidth {
    public int widthOfBinaryTree(TreeNode root) {
        int maxcount =0;
        Queue<PairMaxWidth> q = new ArrayDeque<>();
        q.offer(new PairMaxWidth(root,1));
        while(!q.isEmpty()){
            PairMaxWidth top = q.peek();
            int left = top.pos;
            int right =top.pos;
            int size = q.size();
            while(size>0){
                top = q.poll();
                right = top.pos;
                size--;
                if(top.node.left!=null){
                    int tmp= 2*Math.abs(top.pos-1)+1;
                    q.offer(new PairMaxWidth(top.node.left,tmp));
                }
                if(top.node.right!=null){
                    int tmp= 2*Math.abs(top.pos-1)+2;
                    q.offer(new PairMaxWidth(top.node.right,tmp));
                }
            }
            maxcount= Math.max(maxcount, right-left+1);
        }
        return maxcount;
    }
}

