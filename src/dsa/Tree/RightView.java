package dsa.Tree;
import java.util.ArrayList;
import java.util.List;


// DFS
public class RightView {
    List<Integer> main = new ArrayList<>();
    public void dfs(TreeNodeEx root, int level){
        if(root == null) return;
        if(main.size() == level) main.add(root.val);
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }

    public List<Integer> rightSideView(TreeNodeEx root) {
        dfs(root,0);
        return main;
    }
}

        // BFS
//        public List<Integer> rightSideView(TreeNodeEx root) {
//            List<Integer>  result= new ArrayList<>();
//            if(root==null)
//                return result;
//            Queue<TreeNodeEx> q = new ArrayDeque<>();
//            q.offer(root);
//            q.offer(new TreeNodeEx(-1000));
//            result.add(root.val);
//            int temp = root.val;
//            while(!q.isEmpty()){
//                TreeNodeEx top= q.poll();
//                if(top.val==-1000){
//                    if(q.size()==0)
//                        break;
//                    result.add(temp);
//                    q.offer(new TreeNodeEx(-1000));
//                }
//                else{
//                    if(top.left!=null){
//                        q.add(top.left);
//                        temp=top.left.val;
//                    }
//                    if(top.right!=null){
//                        q.add(top.right);
//                        temp=top.right.val;
//                    }
//                }
//            }
//            return result;
//        }


