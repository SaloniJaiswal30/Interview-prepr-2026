package dsa.Tree;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root,Long min, Long max) {
        if(root==null)
            return true;

        if(root.val<=min || root.val>=max){
            return false;
        }
        return isValid(root.left,min,(long)root.val) && isValid(root.right,(long)root.val,max);
    }
}
