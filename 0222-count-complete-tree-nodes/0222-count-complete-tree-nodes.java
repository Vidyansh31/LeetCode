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
    public int countNodes(TreeNode root) {
        if(root== null){
            return 0;
        }
        
        TreeNode node = root.left;
        int lh = 0;
        while(node != null){
            node = node.left;
            lh++;
        }
        
        node = root.right;
        int rh = 0;
        while(node != null){
            node = node.right;
            rh++;
        }
        
        if(lh == rh){
            int ht = lh+1;
            return (1<<ht) -1;
        }
        else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
}