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
        Stack<Node> st = new Stack<>();
        List<Integer> post = new LinkedList<>();
        if(root == null){
            return post;
        } 
        
        st.push(root);
        
        while(st.size() > 0){
            //Add Children in reverse
           Node top = st.peek();
            if(top.children != null && top.children.size() > 0){
                for(int i = top.children.size()-1; i>=0; i--){
                    st.push(top.children.get(i));
                }
                //after adding make children null so that it will not added again
                top.children = null;
            }
            else{
                post.add(st.pop().val);
            }
        }
        
        return post;
    }
}