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
    
    public boolean isCousins(TreeNode root, int x, int y) {
        List<Integer> X = nodeToRootPath(root,x);
        List<Integer> Y = nodeToRootPath(root,y);
        
        if(X.size() > 1 && Y.size() > 1 && X.get(1) == Y.get(1)){
            return false;
        }
        
        int x_depth = X.size()-1;
        int y_depth = Y.size()-1;
     
        return x_depth == y_depth ? true :false;
    }
    
    
    public List<Integer> nodeToRootPath(TreeNode root, int key){
        if(root == null){
            return new ArrayList<>();
        }
        
        if(root.val == key){
            List<Integer> base = new ArrayList<>();
            base.add(root.val);
            return base;
        }
        
        List<Integer> left = nodeToRootPath(root.left,key);
        if(left.size() > 0){
            left.add(root.val);
            return left;
        }
        
        List<Integer> right = nodeToRootPath(root.right,key);
        if(right.size() > 0){
            right.add(root.val);
            return right;
        }
        
        return new ArrayList<>();
    }
    
}