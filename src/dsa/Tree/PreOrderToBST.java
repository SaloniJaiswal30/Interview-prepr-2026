package dsa.Tree;

public class PreOrderToBST {
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return createBST(preorder,Integer.MAX_VALUE );
    }
    public TreeNode createBST(int[] preorder,int maxValue){
        if(index>(preorder.length-1) || preorder[index]>maxValue)
            return null;
        TreeNode node = new TreeNode(preorder[index]);
        index++;
        node.left = createBST(preorder,node.val );
        node.right = createBST(preorder,maxValue);
        return node;
    }
}
