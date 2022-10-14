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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null){
           if(curr.val == val){
               curr = curr.next;
           }
            else{
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        prev.next = null;
        
        return dummy.next;
    }
}