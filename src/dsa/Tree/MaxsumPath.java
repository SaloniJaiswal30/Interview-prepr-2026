package dsa.Tree;

public class MaxsumPath {
    int max=Integer.MIN_VALUE;;
    public int maxPathSum(TreeNode root) {
        getSum(root);
        return max;

    }
    public int getSum(TreeNode root) {
        if(root==null)
            return 0;
        int left = Math.max(0,getSum(root.left));
        int right = Math.max(0,getSum(root.right));
        max = Math.max(max, left+right+root.val);
        return root.val+Math.max(left,right);

    }
}
