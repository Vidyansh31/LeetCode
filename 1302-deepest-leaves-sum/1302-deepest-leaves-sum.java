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
  
    public int deepestLeavesSum(TreeNode root) {    
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int ans = 0;
        while(qu.size() > 0){
            int size = qu.size();
            ans = 0;
            while(size-- > 0){
                TreeNode rem = qu.remove();
                
                
                    ans += rem.val;
             
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            
        }
        
        return ans;
    }
}