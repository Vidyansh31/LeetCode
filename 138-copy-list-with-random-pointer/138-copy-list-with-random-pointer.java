/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        
        //Making duplicates node
        Node h1 = head;
        while(h1 != null){
            Node nNode = new Node(h1.val);
            nNode.next = h1.next;
            h1.next = nNode;
            
            h1 = nNode.next;
        }
        
        //Assign Random Pointer
        h1 = head;
        while(h1 != null){
            if(h1.random != null){
                h1.next.random = h1.random.next;
            }
            h1 = h1.next.next;
        }
        
        //Splitting the list
        h1 = head;
        Node nHead = h1.next;
        Node h2 = nHead;
        
        while(h1 != null && h2.next != null){
           h1.next = h2.next;
            h2.next = h1.next.next;
            h1 = h1.next;
            h2 = h2.next;
        }
        
        h1.next = null;
        
        
        return nHead;
    }
}