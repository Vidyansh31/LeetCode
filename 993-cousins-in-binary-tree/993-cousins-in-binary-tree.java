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
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int depthX = -1;
        int depthY = -2;
        int level = 0;
        while(qu.size() != 0){
            int size = qu.size();
            for(int i = 0; i <size; i++){
                TreeNode rem = qu.remove();
                
                if(rem.left != null && rem.right != null){
                    if(rem.left.val == x && rem.right.val == y) return false;
                    if(rem.left.val == y && rem.right.val == x) return false;
                }
                
                if(rem.val == x) depthX = level;
                if(rem.val == y) depthY = level;
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            level++;
        }
        
         return depthX == depthY;
    } 
}