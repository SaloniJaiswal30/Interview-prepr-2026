package dsa.Tree;

public class TreeToLinkList {
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left!=null){
                TreeNode curr = root.left;
                while(curr.right!=null){
                    curr=curr.right;
                }
                curr.right= root.right;
                root.right = root.left;
                root.left=null;
            }
            root=root.right;
        }
    }
}
