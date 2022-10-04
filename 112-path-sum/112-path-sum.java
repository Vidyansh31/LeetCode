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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,targetSum,0);
    }
    
    public boolean helper(TreeNode node, int t,int sum){ 
        if(node == null){
            return false;
        }
        
         if(node.left == null && node.right == null){
            if(sum+node.val == t){
                return true;
            }
        }
        
        boolean left = helper(node.left,t,sum+node.val);
        if(left == true){
            return true;
        }
        boolean right = helper(node.right,t,sum+node.val);
        if(right == true){
            return true;
        }
        
        return false;
    }
}