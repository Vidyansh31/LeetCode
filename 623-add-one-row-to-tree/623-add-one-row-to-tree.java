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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null){
            return null;
        }
        
        if(depth == 1){
            TreeNode l = new TreeNode(val);
            l.left = root;
            return l;
        }
        
        if(depth - 1 == 1){
            TreeNode l = new TreeNode(val);
            TreeNode r = new TreeNode(val);
            
            l.left = root.left;
            root.left = l;
            
            r.right = root.right;
            root.right = r;
            
            return root;
        }
        
        addOneRow(root.left,val,depth-1);
        addOneRow(root.right,val,depth-1);
        
        return root;
    }
}