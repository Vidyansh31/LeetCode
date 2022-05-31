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
    public int max(TreeNode node){
        if(node == null){
            return 0;
        }
        
        while(node.right != null){
            node = node.right;
        }
        
        return node.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        else{
            //0 || 1 child
            if(root.left == null || root.right == null){
                return root.left != null ? root.left : root.right;
            }
            
            int maxEle = max(root.left);
            root.val = maxEle;
            root.left = deleteNode(root.left,maxEle);
            
        }
        
        return root;
    }
}