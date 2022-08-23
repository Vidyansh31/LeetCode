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
    public ListNode middleofLL(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode tempHead){
        ListNode prev = null;
        ListNode curr = tempHead;
        
        while(curr != null){
            ListNode forward = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = forward;
        }
        
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode middle = middleofLL(head);
        
        ListNode tempHead = middle.next;
        
        middle.next = null;
        
       ListNode reverseTempHead = reverse(tempHead);
        
        while(head != null && reverseTempHead != null){
            if(head.val != reverseTempHead.val){
                return false;
            }
            head = head.next;
            reverseTempHead = reverseTempHead.next;
        }
        
        return true;
    }
}