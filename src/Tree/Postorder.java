package Tree;

import java.util.ArrayList;
import java.util.List;


class PostOrder {
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
        if(root.right!=null)
            traverse(root.right,list);
        list.add(root.val);
    }

}
