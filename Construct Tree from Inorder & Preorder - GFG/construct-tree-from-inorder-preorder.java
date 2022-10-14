//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i < n; i++){
            map.put(inorder[i],i);
        }
        Node root = construct(0,n-1,0,n-1,preorder,map);
        return root;
    }
    
    public static Node construct(int pre_lo, int pre_hi, int in_lo, int in_hi, int[] pre, Map<Integer,Integer> map){
        if(pre_lo > pre_hi || in_lo > in_hi){
            return null;
        }
        
        Node node = new Node(pre[pre_lo]);
        
        int index = map.get(pre[pre_lo]);
        int lhs = index - in_lo;
        
        node.left = construct(pre_lo+1,pre_lo + lhs, in_lo, index-1, pre,map);
        node.right = construct(pre_lo+lhs+1, pre_hi, index+1, in_hi,pre,map);
        
        return node;
    }
}
