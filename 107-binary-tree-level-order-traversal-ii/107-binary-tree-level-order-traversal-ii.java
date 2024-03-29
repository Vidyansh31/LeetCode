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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        
        Queue<TreeNode> qu = new LinkedList<>();
        
        qu.add(root);
        
        while(qu.size() > 0){
            int size = qu.size();
            List<Integer> temp = new ArrayList<>();
            while(size-- > 0){
                TreeNode rem = qu.remove();
                
                temp.add(rem.val);
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            
            ans.addFirst(temp);
        }
        
       
        
        return ans;
    }
}