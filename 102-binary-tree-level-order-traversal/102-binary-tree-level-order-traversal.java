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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> qu = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(root.val);
        ans.add(a);
        qu.add(root);
        
        while(qu.size() > 0){
            List<Integer> child = new ArrayList<>();
            int size = qu.size();
            while(size-- > 0){
                TreeNode rem = qu.remove();
                
                
                if(rem.left != null){
                    qu.add(rem.left);
                    child.add(rem.left.val);
                }
                
                if(rem.right != null){
                    qu.add(rem.right);
                    child.add(rem.right.val);
                }  
                
                
            }
            if(child.size() > 0){
                ans.add(child);
            }
        }
        
        return ans;
    }
}