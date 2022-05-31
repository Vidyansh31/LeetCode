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
    
    int count = 0;
    final int CAMERA = 1;
    final int MONITERED = 2;
    final int NOT_MONITERED = 3;
    
    public int minCameraCover(TreeNode root) {
        int val = helper(root);
        
        if(val == NOT_MONITERED){
            count++;
        }
        
        return count;
    }
    
    public int helper(TreeNode node){
        if(node == null){
            return MONITERED;
        }
        
        int left = helper(node.left);
        int right = helper(node.right);
        
        if(left == NOT_MONITERED || right == NOT_MONITERED){
            count++;
            return CAMERA;
        }
        else if(left == CAMERA || right == CAMERA){
            return MONITERED;
        }
        else{
            return NOT_MONITERED;
        }
    }
}