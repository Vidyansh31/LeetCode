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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        
        while(qu.size() > 0){
            int size = qu.size();
            int max = Integer.MIN_VALUE;
            while(size-- > 0){
                TreeNode rem = qu.remove();
                
                max = Math.max(rem.val,max);
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                
                 if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            
            ans.add(max);
        }
        
        return ans;
    }
}