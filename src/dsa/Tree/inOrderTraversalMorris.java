package dsa.Tree;
import java.util.ArrayList;

class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
public class inOrderTraversalMorris {
    public ArrayList<Integer> inOrder(Node root) {
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
                    prev.right= curr;
                    curr=curr.left;

                }
                else{
                    result.add(curr.data);
                    curr= prev.right;
                    prev.right = null;
                    curr=curr.right;
                }
            }
        }
        return result;
    }
}

