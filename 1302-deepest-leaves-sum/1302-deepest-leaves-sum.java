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
    int level(TreeNode root){
        if(root == null){
            return -1;
        }
        
        int left =  level(root.left);
        int right =  level(root.right);
        
        return Math.max(left,right)+1;
    }
    public int deepestLeavesSum(TreeNode root) {
        int l = level(root);
        System.out.println(l);
        
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int ans = 0;
        while(qu.size() > 0){
            int size = qu.size();
            
            while(size-- > 0){
                TreeNode rem = qu.remove();
                
                if(l == 0){
                    ans += rem.val;
                }
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            l--;
        }
        
        return ans;
    }
}