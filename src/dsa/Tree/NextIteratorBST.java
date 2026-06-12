package dsa.Tree;
import java.util.*;

public class NextIteratorBST {
    Stack<TreeNode> s;
    public NextIteratorBST(TreeNode root) {
        s = new Stack<>();
        iterator(root);
    }
    public void iterator(TreeNode root){
        while(root!=null){
            s.push(root);
            root=root.left;
        }
    }

    public int next() {
        TreeNode top = s.pop();
        if(top.right!=null){
            iterator(top.right);
        }
        return top.val;
    }

    public boolean hasNext() {
        if(s.isEmpty()){
            return false;
        }
        return true;
    }
}
