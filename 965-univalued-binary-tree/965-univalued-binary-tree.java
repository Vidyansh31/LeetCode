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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return false;
        }
        
        boolean ans = travel(root,root.val);
        return ans;
    }
    
    public boolean travel(TreeNode node , int key){
        if(node == null){
            return true;
        }
        
        boolean left = travel(node.left, key);
        if(left == false){
            return false;
        }
        
        if(node.val != key){
            return false;
        }
        
        boolean right = travel(node.right, key);
        if(right == false){
            return false;
        }
        
        return true;
    }
}