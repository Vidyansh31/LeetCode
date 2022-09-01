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
    public int goodNodes(TreeNode root) {
        return helper(root,Integer.MIN_VALUE);
    }
    
    public int helper(TreeNode node, int prev){
        if(node == null){
            return 0;
        }
        
        int count = 0;
        if(node.val >= prev){
            count++;
        }
        
        prev = Math.max(prev,node.val);
        count += helper(node.left,prev);
        count += helper(node.right,prev);
        
        return count;
    }
}