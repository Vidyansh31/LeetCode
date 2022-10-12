//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.subLinkedList(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* Structure of Linked list node

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

*/

class Solution
{
    static int getSize(Node n){
        int size = 0;
        while(n != null){
            size++;
            n = n.next;
        }
        
        return size;
    }
    
    static Node stripLeadingZero(Node n){
        while(n != null){
            if(n.data != 0){
                break;
            }
            else{
                n = n.next;
            }
        }
        
        if(n == null){
            n = new Node(0);
        }
        
        return n;
    }
    
    static Node paddingZero(Node n, int count){
        for(int i = 1; i <= count; i++){
            Node temp = new Node(0);
            temp.next = n;
            n = temp;
        }
        return n;
    }
    
    static Node subLinkedList(Node l1, Node l2)
    {
        // code here
         l1 = stripLeadingZero(l1);
         l2 = stripLeadingZero(l2);
         
         int s1 = getSize(l1);
         int s2 = getSize(l2);
         
        Node small = null;
        Node large = null;
        
        if( s1 < s2){
            small = l1;
            large = l2;
            
            small = paddingZero(small, s2-s1);
        }
        else if (s1 > s2){
            small = l2;
            large = l1;
            
            small = paddingZero(small, s1-s2);
        }
        else{
            Node t1 = l1;
            Node t2 = l2;
            
            while(t1 != null){
                if(t1.data < t2.data){
                    small = l1;
                    large = l2;
                    break;
                }
                else if(t1.data > t2.data){
                    small = l2;
                    large = l1;
                    break;
                }
                else{
                    t1 = t1.next;
                    t2 = t2.next;
                }
            }
        }
        
        borrow = false;
        Node res = helper(small,large);
        res = stripLeadingZero(res);
        return res;
    }
    
    static boolean borrow = false;
    
    
    static Node helper(Node small, Node large){
        if(small == null){
            return null;
        }
        
        Node res = helper(small.next, large.next);
        
        int data = large.data;
        
        if(borrow){
            data -= 1;
        }
        
        if(data < small.data){
            borrow = true;
            data += 10;
        }
        else{
            borrow = false;
        }
        
        data = data - small.data;
        Node node = new Node(data);
        node.next = res;
        return node;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}