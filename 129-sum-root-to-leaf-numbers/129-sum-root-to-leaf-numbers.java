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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        helper(root,0);
        
        return sum;
    }
    
    public void helper(TreeNode node, int val){
        if(node == null){
            return;
        }
        
        helper(node.left,10 * val + node.val);
        helper(node.right,10* val + node.val);
        
        if(node.left == null && node.right == null ){
            sum += 10 * val + node.val;
        }
    }
}