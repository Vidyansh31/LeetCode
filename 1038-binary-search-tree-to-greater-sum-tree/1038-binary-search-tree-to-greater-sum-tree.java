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
    
    public TreeNode bstToGst(TreeNode root) {
        return helper(root,new TreeNode(0));
    }
    
    public TreeNode helper(TreeNode root, TreeNode sum){
        if(root == null){
            return null;
        }
        
        
        
        root.right = helper(root.right,sum);
        
        root.val += sum.val;
        sum.val = root.val;
        
        root.left = helper(root.left,sum);
        
        return root;
    }
}