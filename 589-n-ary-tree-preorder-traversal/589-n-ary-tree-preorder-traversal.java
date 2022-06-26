/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> pre = new ArrayList<>();
        preOrder(root,pre);
        return pre;
    }
    
    private void preOrder(Node root, List<Integer> pre){
        if(root == null){
            return;
        } 
        
        pre.add(root.val);
        
        for(Node n : root.children){
            preOrder(n,pre);
        }
    }
}