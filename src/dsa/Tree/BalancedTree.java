package dsa.Tree;

public class BalancedTree {
    boolean bal=true;
    public boolean isBalanced(TreeNode root) {
        checkBalance(root);
        return bal;
    }
    public int checkBalance(TreeNode root){
        if(root==null)
            return 0;
        int lefty= checkBalance(root.left);
        int righty= checkBalance(root.right);
        if(Math.abs(lefty-righty)>1){
            bal= false;
        }
        return 1+Math.max(lefty,righty);
    }
}
