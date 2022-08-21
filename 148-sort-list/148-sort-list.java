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
    public ListNode middleOfLL(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                prev = l1;
                l1 = l1.next;
            }
            else{
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }
        
        if(l1 != null){
            prev.next = l1;
        }
        
        if(l2 != null){
            prev.next = l2;
        }
        
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode mid = middleOfLL(head);
        ListNode newHead = mid.next;
        mid.next = null;
        
        ListNode lh = sortList(head);
        ListNode rh = sortList(newHead);
        
        return merge(lh,rh);
    }
}