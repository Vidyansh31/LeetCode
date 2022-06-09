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
    public ArrayList<Integer> inorder = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        helper(root);
        
        int low = 0;
        int high = inorder.size()-1;
        while(low < high){
            if(inorder.get(low)+inorder.get(high) == k){
                return true;
            }
            else if(inorder.get(low)+inorder.get(high) < k){
                low++;
            }
            else{
                high--;
            }
        }
        
        return false;
    }
    
    public void helper(TreeNode node){
        if(node == null){
            return;
        }
        
        helper(node.left);
        
        inorder.add(node.val);
        
        helper(node.right);
    }
}