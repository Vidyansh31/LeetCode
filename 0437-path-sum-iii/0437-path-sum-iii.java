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
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        HashMap<Long, Integer> preSum = new HashMap();
        preSum.put(0L,1);
        helper(root, root.val, sum, preSum);
        return count;
    }
    int count = 0;
    public void helper(TreeNode node, long currSum, long target, HashMap<Long, Integer> map) {
        if (node == null) {
            return;
        }
        
        if(map.containsKey(currSum - target)){
            count += map.get(currSum - target);
        }
        
        if(map.containsKey(currSum) == false){
            map.put(currSum,1);
        }
        else{
            map.put(currSum, map.get(currSum)+1);
        }
        
        if(node.left != null){
            helper(node.left,currSum+node.left.val,target,map);
        }
        
        if(node.right != null){
            helper(node.right,currSum+node.right.val,target,map);
        }
        
        if(map.get(currSum) == 1){
            map.remove(currSum);
        }
        else{
            map.put(currSum, map.get(currSum)-1);
        }
    }
}