/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode res;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
         inorder(original,cloned,target);
        return res;
    }
    
    public void inorder(TreeNode org, TreeNode cloned, TreeNode target){
        if(org == null || cloned == null){
            return ;
        }
        
        
        
      inorder(org.left, cloned.left,target);
        
        if(org.val == target.val){
            res = cloned;
            return;
        }
        
        inorder(org.right, cloned.right,target);
        
        
    }
}