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
    public int rangeSumBST(TreeNode root, int low, int high) {
         int sum  = 0;
        Stack<TreeNode> st = new Stack<>();
        while(root != null || st.size() > 0){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(root.val >= low && root.val <= high) sum += root.val;
            root = root.right;
        }
        
        return sum;
    }
}