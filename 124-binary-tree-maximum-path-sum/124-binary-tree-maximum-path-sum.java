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
    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
       int ans =  helper(root);
        return max;
    }
    
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int left_dash = Math.max(0,left);
        int right_dash = Math.max(0,right);
            
        int sumFromLeftToRight = left_dash + root.val + right_dash;
        if(sumFromLeftToRight > max){
            max = sumFromLeftToRight;
        }
        
        
        return Math.max(left_dash,right_dash)+root.val;
    }
}