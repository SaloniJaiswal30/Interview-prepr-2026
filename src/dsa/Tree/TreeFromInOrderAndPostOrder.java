package dsa.Tree;
import java.util.*;

public class TreeFromInOrderAndPostOrder {
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index=0;
        Map<Integer, Integer> mp= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return build(preorder, mp,0,inorder.length );
    }
    public TreeNode build(int[] preorder,Map<Integer, Integer> mp, int left, int right){
        if(right<left || index>=preorder.length)
            return null;
        int inorder_index=mp.get(preorder[index]);
        TreeNode node = new TreeNode(preorder[index]);
        index++;
        node.left= build(preorder, mp,left,inorder_index-1);
        node.right = build(preorder, mp,inorder_index+1,right);
        return node;
    }
}
