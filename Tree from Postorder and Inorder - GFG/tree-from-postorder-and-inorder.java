//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i < n; i++){
            map.put(in[i],i);
        }
        Node root = construct(0,n-1,0,n-1,post,map);
        return root;
    }
    
    public static Node construct(int post_lo, int post_hi, int in_lo, int in_hi, int[] post, Map<Integer,Integer> map){
        if(post_lo > post_hi || in_lo > in_hi){
            return null;
        }
        
        Node node = new Node(post[post_hi]);
        
        int index = map.get(post[post_hi]);
        int rhs = index - in_lo;
        
        node.left = construct(post_lo,post_lo+rhs-1, in_lo, index-1, post,map);
        node.right = construct(post_lo+rhs, post_hi-1, index+1, in_hi,post,map);
        
        return node;
    }
}
