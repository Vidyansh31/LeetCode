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
        return construct(preorder,Integer.MAX_VALUE);
    }
    
    public TreeNode construct(int[] pre , int max){
        if(idx == pre.length){
            return null;
        }
        else if(pre[idx] < max){
            int val = pre[idx++];
            TreeNode node = new TreeNode(val);
            
            node.left = construct(pre,val);
            node.right = construct(pre,max);
            
            return node;
        }
        else{
            return null;
        }
    }
}