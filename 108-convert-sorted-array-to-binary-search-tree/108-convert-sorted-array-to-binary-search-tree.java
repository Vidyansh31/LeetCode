/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBST(int[] nums, int st, int end){
        if(st > end){
            return null;
        }
        
        int mid = st + (end-st)/2;
        
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = createBST(nums,st,mid-1);
        node.right = createBST(nums,mid+1,end);
        
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums,0,nums.length-1);
    }
}