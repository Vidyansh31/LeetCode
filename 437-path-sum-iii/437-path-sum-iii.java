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
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        travel1(root,targetSum);
        return count;
    }
    
    public void travel1(TreeNode node, int target){
        if(node == null){
            return;
        }
        
        travel2(node,0,target);
        
        travel1(node.left,target);
        travel1(node.right,target);
    }
    
    public void travel2(TreeNode node, int csum, int tar){
        if(node == null){
            return;
        }
        
        if(csum+node.val == tar){
            count++;
        }
        
        travel2(node.left,csum+node.val,tar);
        travel2(node.right,csum+node.val,tar);
        
    }
}