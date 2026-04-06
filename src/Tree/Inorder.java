package Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNodeEx {
    int val;
    TreeNodeEx left;
    TreeNodeEx right;
    TreeNodeEx() {}
    TreeNodeEx(int val) { this.val = val; }
    TreeNodeEx(int val, TreeNodeEx left, TreeNodeEx right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class InOrder {
    public List<Integer> inorderTraversal(TreeNodeEx root) {
        List<Integer> list=new ArrayList<>();
        traverse(root,list);
        return list;
    }

    public void traverse(TreeNodeEx root, List<Integer> list){
        if(root==null)
            return;
        if(root.left!=null)
            traverse(root.left,list);
        list.add(root.val);
        if(root.right!=null)
            traverse(root.right,list);
    }

}
