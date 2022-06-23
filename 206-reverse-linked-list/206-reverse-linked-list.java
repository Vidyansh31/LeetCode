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
    public ListNode reverseList(ListNode head) {
        // Approach 2 : Pointer Iteratively
        if(head == null){
            return null;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode forw = head.next;
        
        while(forw != null){
            //move pointer
            curr.next = prev;
            
            //updation
            prev = curr;
            curr = forw;
            forw = forw.next;
        }
        
        curr.next = prev;
        prev = curr;
        
        
        return prev;
         
    }
}