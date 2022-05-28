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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        
       TreeNode root =  helper(nums,0,nums.length-1);
        return root;
    }
    
    public TreeNode helper(int[] nums, int st , int end){
        if(st > end){
            return null;
        }
        int idx = find(nums,st,end);
        
        TreeNode root = new TreeNode(nums[idx]);
        
        root.left = helper(nums,st,idx-1);
        root.right = helper(nums,idx+1,end);
        
        return root;
    }
    
    public int find(int[] nums, int st, int end){
        int idx = st;
        for(int i = st; i <= end; i++){
            if(nums[idx] < nums[i]){
                idx = i;
            }
        }
        
        return idx;
    }
}