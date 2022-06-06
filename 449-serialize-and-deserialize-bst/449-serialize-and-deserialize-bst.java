/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        
        helperSer(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    public void helperSer(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(".");
            sb.append(" ");
            return;
        }
        
        sb.append(root.val);
        sb.append(" ");
        
        helperSer(root.left,sb);
        helperSer(root.right,sb);
    }

    public class pair{
        TreeNode node;
        int state;
        
        pair(){}
        
        pair(TreeNode node, int state){
            this.node = node;
            this.state = state;
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        Stack<pair> st = new Stack<>();
        
        String[] darray = data.split(" "); 
        pair root = new pair();
        root.node = new TreeNode(Integer.parseInt(darray[0]));;
        root.state = 0;
        st.push(root);
        int idx = 1;
        while(st.size() != 0){
            pair top = st.peek();
            
            if(top.state == 0){
                if(darray[idx].equals(".") == false){
                    TreeNode l = new TreeNode(Integer.parseInt(darray[idx]));
                    pair left = new pair(l,0);
                    top.node.left = l;
                    st.push(left);
                }
                idx++;
                top.state++;
            }
            else if(top.state == 1){
                if(darray[idx].equals(".")== false){
                    TreeNode rt = new TreeNode(Integer.parseInt(darray[idx]));
                    pair right = new pair(rt,0);
                    top.node.right = rt;
                    st.push(right);
                }
                idx++;
                top.state++;
            }
            else{
                st.pop();
                
            }
        }
        
        return root.node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;