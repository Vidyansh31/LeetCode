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
        Stack<Node> st = new Stack<>();
        List<Integer> pre = new ArrayList<>();
        if(root == null){
            return pre;
        }
        
        st.push(root);
        
        while(st.size() > 0){
            //rem
            Node rem = st.pop();
            
            //add to list
            pre.add(rem.val);
            
            //add children in reverse
            for(int i = rem.children.size()-1; i >= 0; i--){
                st.push(rem.children.get(i));
            }
        }
        
        return pre;
    }
}