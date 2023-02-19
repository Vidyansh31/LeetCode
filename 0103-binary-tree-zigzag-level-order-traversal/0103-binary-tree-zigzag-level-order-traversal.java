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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int l = 0;
        while(qu.size() > 0){
            List<Integer> level = new ArrayList<>();
            int size = qu.size();
            while(size-- > 0){
                TreeNode rem = qu.remove();
                
                if(l %2 == 0){
                    level.add(rem.val);
                }else{
                    level.add(0,rem.val);
                }
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            
            l++;
            ans.add(level);
        }
        
        return ans;
        
    }
}