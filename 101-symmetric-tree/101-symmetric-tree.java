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
    public boolean isSymmetric(TreeNode root) {
        boolean ans = helper(root.left,root.right);
        return ans;
    }
    
    public boolean helper(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 != null){
            return false;
        }
        else if(node1 != null && node2 == null){
            return false;
        }
        else if(node1 == null && node2 == null){
            return true;
        }
        
        if(node1.val == node2.val){
            boolean res1 = helper(node1.left, node2.right);
            boolean res2 = helper(node1.right, node2.left);
            
            if(res1 == false || res2 == false){
                return false;
            }
        }
        else{
            return false;
        }
        
        return true;
    }
}