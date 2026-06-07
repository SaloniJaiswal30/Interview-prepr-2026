package dsa.Tree;
import java.util.*;
class NodePointer {
    public int val;
    public NodePointer left;
    public NodePointer right;
    public NodePointer next;

    public NodePointer() {}

    public NodePointer(int _val) {
        val = _val;
    }

    public NodePointer(int _val, NodePointer _left, NodePointer _right, NodePointer _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class ConnectLeftToRight {
    public NodePointer connect(NodePointer root) {
        if(root==null)
            return root;
        Queue<NodePointer> q = new ArrayDeque<>();
        q.offer(root);
        root.next= null;
        while(!q.isEmpty()){
            int size= q.size();
            NodePointer tmp=null;
            while(size>0){
                NodePointer top = q.poll();
                if(tmp!=null)
                    tmp.next = top.left;
                if(top.left!=null){
                    q.offer(top.left);
                }
                if(top.right!=null){
                    q.offer(top.right);
                    tmp=top.right;
                }
                if(top.left!=null && top.right!=null){
                    top.left.next=top.right;
                }
                size--;
            }
        }
        return root;
    }
}
