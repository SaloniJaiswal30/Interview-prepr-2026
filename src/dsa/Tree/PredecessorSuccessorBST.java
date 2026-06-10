package dsa.Tree;
import java.util.*;

public class PredecessorSuccessorBST {
    Node suc = null;
    Node pre = null;
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> result = new ArrayList<>();
        findPre(root, key);
        findSuc(root, key);
        result.add(pre);
        result.add(suc);
        return result;
    }
    public void findPre(Node root, int key) {
        if(root==null)
            return;
        if(root.data<key && (pre==null || pre.data<root.data)){
            pre=root;
        }
        if(root.data<key)
            findPre(root.right,key);
        else
            findPre(root.left,key);
        return;
    }

    public void findSuc(Node root, int key) {
        if(root==null)
            return;
        if(root.data>key && (suc==null ||suc.data>root.data)){
            suc=root;
        }
        if(root.data<=key)
            findSuc(root.right,key);
        else
            findSuc(root.left,key);
        return;
    }

}
