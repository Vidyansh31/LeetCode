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
    public int height(TreeNode root){
        if(root == null){
            return -1;
        }
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        return Math.max(lh,rh)+1;
    }
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int h = height(root);
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        
        while(qu.size() > 0){
            int size = qu.size();
            for(int i = 0; i < size; i++){
                TreeNode rem = qu.remove();
                
                if(i == 0 && h ==0 ){
                    return rem.val;
                }
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                
                if(rem.right != null){
                    qu.add(rem.right);
                }
                
            }
            h--;
        }
        
        return 0;
    }
}