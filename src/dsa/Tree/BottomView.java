package dsa.Tree;
import java.util.*;
class Pair{
    Node node;
    int depth;
    Pair(Node node, int depth){
        this.node = node;
        this.depth=depth;
    }
}

public class BottomView {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer,Node> map= new TreeMap<>();
        Queue<Pair> q= new ArrayDeque<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node top = p.node;
            int depth = p.depth;
            map.put(depth,top);
            if(top.left!=null){
                q.offer(new Pair(top.left,depth-1));
            }
            if(top.right!=null){
                q.offer(new Pair(top.right,depth+1));
            }
        }

        for(Node node: map.values()){
            result.add(node.data);
        }
        return result;
    }
}

