package dsa.Tree;

public class MaxDiameter {
    int max =0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return max;
    }

    public int getDiameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int lefty= getDiameter(root.left);
        int righty= getDiameter(root.right);
        max= Math.max(lefty+righty, max);
        return 1+Math.max(lefty,righty);
    }
}
