package dsa.Tree;

public class KSmallest {
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        return smallest(root).val;
    }

    public TreeNode smallest(TreeNode root) {
        if(root==null) return null;

        TreeNode left = smallest(root.left);

        count--;
        if(count==0) return root;
        if(left!=null) return left;

        TreeNode right = smallest(root.right);

        if(right!=null) return right;

        return null;
    }
}
