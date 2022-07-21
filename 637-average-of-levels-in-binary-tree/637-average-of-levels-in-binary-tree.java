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
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        
        while(qu.size() > 0){
            int size = qu.size();
            Double totalEle = (double)size;
            Double sum = 0.0;
            while(size-- > 0){
                TreeNode rem = qu.remove();
                
                sum += rem.val;
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            
            ans.add(sum/totalEle);
        }
        
        return ans;
    }
}