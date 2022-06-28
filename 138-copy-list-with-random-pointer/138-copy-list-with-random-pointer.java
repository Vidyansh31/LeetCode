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
        
        //Step 1 : Create Copy
        Node curr = head;
        while(curr != null){
            Node chead = new Node(curr.val);
            chead.next = curr.next;
            
            curr.next = chead;
            curr = curr.next.next;
        }
        
        //Step 2 : assign random
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        //Step3 : Restore List
        Node nHead = head.next;
        Node temp = nHead;
        curr = head;
        
        while(curr!= null && temp.next != null){
            curr.next = temp.next;
            temp.next = temp.next.next;
            curr = curr.next;
            temp = temp.next;
        }
        
        curr.next = null;
        
        return nHead;
    }
}