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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        
        while(qu.size() > 0){
            int size = qu.size();
            int numOfELe = size;
            Double avg = 0.0;
            
            while(size -- > 0){
                TreeNode rem = qu.remove();
                
                avg += rem.val;
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                
                 if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            
            ans.add(avg/numOfELe);
        }
        
        return ans;
    }
}