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
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        Queue<TreeNode> qu = new LinkedList<>();
        Stack<List<Integer>> st = new Stack<>();
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
            
            st.push(temp);
        }
        
        while(st.size()> 0){
            ans.add(st.pop());
        }
        
        return ans;
    }
}