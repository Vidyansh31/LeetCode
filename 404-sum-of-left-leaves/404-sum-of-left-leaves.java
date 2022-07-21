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
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        } 
        Stack<TreeNode> st = new Stack<>();
        int ans = 0;
        st.add(root);
        
        while(st.size() > 0){
            TreeNode rem = st.pop();
            
            if(rem.left != null){
                if(rem.left.left == null && rem.left.right == null){
                    ans += rem.left.val;
                }
                else{
                    st.push(rem.left);
                }
            }
            
            if(rem.right != null){
                st.push(rem.right);
            }
        }
        
        return ans;
        
    }
}