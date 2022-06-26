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
    public List<Integer> postorder(Node root) {
     List<Integer> post = new ArrayList<>();
        postOrder(root,post);
        return post;
    }
    
    private void postOrder(Node root, List<Integer> post){
        if(root == null){
            return;
        } 
        
        for(Node n : root.children){
            postOrder(n,post);
        }
        
        post.add(root.val);
    }
}