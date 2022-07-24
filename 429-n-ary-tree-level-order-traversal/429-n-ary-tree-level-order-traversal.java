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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        
        while(qu.size() > 0){
            int size = qu.size();
            List<Integer> level = new ArrayList<>();
            while(size-- > 0){
                Node rem = qu.remove();
                
                level.add(rem.val);
                
                if(rem.children.size() > 0 ){
                    for(Node c : rem.children){
                        qu.add(c);
                    }
                }
            }
            
            ans.add(level);
        }
        
        return ans;
    }
}