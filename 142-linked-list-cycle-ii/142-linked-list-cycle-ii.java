/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        do{
            if(slow.next != null){
                slow = slow.next;
            }
            else{
                return null;
            }
            
            if(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
            }
            else{
                return null;
            }
        }while(slow != fast);
            
        slow = head;
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }
}