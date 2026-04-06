package Tree;

import java.util.ArrayList;
import java.util.List;


class PreOrder {
    public List<Integer> inorderTraversal(TreeNodeEx root) {
        List<Integer> list=new ArrayList<>();
        traversal(root,list);
        return list;
    }

    public void traversal(TreeNodeEx root, List<Integer>  list){
        if(root==null)
            return;
        list.add(root.val);
        if(root.left!=null)
            traversal(root.left,list);
        if(root.right!=null)
            traversal(root.right,list);
    }

}
