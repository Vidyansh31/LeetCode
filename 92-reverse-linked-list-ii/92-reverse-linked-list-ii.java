/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }
        
        //Creating a dummyNode;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prevIt = null;
        ListNode currIt = dummy;
        
        for(int i = 0; i < left; i++){
            prevIt = currIt;
            currIt = currIt.next;
            
        }
        
        ListNode prev = prevIt;
        ListNode curr = currIt;
        
        
        for(int i = left; i<= right; i++) {
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
            
        }
        
        currIt.next = curr;
        prevIt.next = prev;
        
        return dummy.next;
    }
}