package dsa.Tree;

public class CheckChildSum {
    public boolean checkTree(TreeNode root) {
        return isChildSum(root);
    }

    public boolean isChildSum(TreeNode root){
        if(root==null || (root.left==null && root.right==null))
            return true;
        int left= root.left==null?0:root.left.val;
        int right= root.right==null?0:root.right.val;
        if(root.val!=(left+right))
            return false;
        return isChildSum(root.left) && isChildSum(root.right);

    }
}
