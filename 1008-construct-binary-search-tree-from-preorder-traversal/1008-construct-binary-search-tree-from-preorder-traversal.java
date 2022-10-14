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
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        
        return root;
    }
    
    public TreeNode helper(int[] pre, int min, int max){
        if(idx == pre.length){
            return null;
        }
        
        
        if(pre[idx] > min && pre[idx] < max){
            int val = pre[idx++];
            TreeNode node = new TreeNode(val);
            node.left = helper(pre,min,val);
            node.right = helper(pre,val,max);
            
            return node;
        }
        else{
            return null;
        }
    }
}