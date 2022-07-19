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
    public boolean findTarget(TreeNode root, int k) {
        
       HashSet<Integer> set = new HashSet<>();
        return helper(root,k,set);
    }
    
    private boolean helper(TreeNode root, int tar, HashSet<Integer> set){
        if(root == null){
            return false;
        }
        
        if(set.contains(tar-root.val)){
            return true;
        }
        
        set.add(root.val);
        
        boolean left = helper(root.left,tar,set);
        if(left == true){
            return true;
        }
        
        boolean right = helper(root.right,tar,set);
        if(right == true){
            return true;
        }
        
        return false;
    }
}