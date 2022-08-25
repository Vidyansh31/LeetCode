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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-5001);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val >= prev.val){
                prev = curr;
                curr = curr.next;
            }
            else{
                ListNode pos = dummy;
                while(pos.next.val < curr.val){
                    pos = pos.next;
                }
                
                prev.next = prev.next.next;
                curr.next= pos.next;
                pos.next = curr;
                
                
                curr = prev.next;
            }
        }
        
        return dummy.next;
    }
}