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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(st.size() > 0 || curr != null){
            while(curr != null){
                st.add(curr);
                list.add(0,curr.val);
                curr = curr.right;
            }
            
            curr = st.pop();
            curr = curr.left;
        }
        
        return list;
    }
}