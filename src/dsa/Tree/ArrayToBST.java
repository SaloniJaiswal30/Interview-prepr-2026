package dsa.Tree;

public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }
    public TreeNode createBST(int[] nums, int left, int right){
        if(right<left)
            return null;
        int index = (right+left)/2;
        TreeNode node = new TreeNode(nums[index]);
        node.left = createBST(nums,left,index-1);
        node.right = createBST(nums,index+1,right);
        return node;
    }
}
