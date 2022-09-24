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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        helper(root,targetSum, list,path,0);
        return list;
    }
    
    public void helper(TreeNode node, int tar, List<List<Integer>> list, List<Integer> path, int sum){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            if(sum+node.val == tar){
                path.add(node.val);
                list.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        
       
        
        path.add(node.val);
        helper(node.left,tar,list,path,sum+node.val);
        helper(node.right,tar,list,path,sum+node.val);
        path.remove(path.size() - 1);
    }
}