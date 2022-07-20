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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> in = new ArrayList<>();
        inorder(root1,in);
        inorder(root2,in);
        Collections.sort(in);
        return in;
    }
    
    public void inorder(TreeNode node, List<Integer> in){
        if(node == null){
            return;
        } 
        
        inorder(node.left,in);
        
        in.add(node.val);
        
        inorder(node.right,in);
    }

}