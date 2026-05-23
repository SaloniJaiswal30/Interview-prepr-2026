package dsa.Tree;
import java.util.ArrayList;

public class PreOrderTraversalMorris {
    public ArrayList<Integer> preOrder(Node root) {
        Node curr = root;
        ArrayList<Integer> result = new ArrayList<>();

        while(curr!=null){
            if(curr.left == null){
                result.add(curr.data);
                curr=curr.right;

            }
            else{
                Node prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right == null){
                    result.add(curr.data);
                    prev.right= curr;
                    curr=curr.left;

                }
                else{
                    curr= prev.right;
                    prev.right = null;
                    curr=curr.right;

                }
            }
        }
        return result;

    }
}

