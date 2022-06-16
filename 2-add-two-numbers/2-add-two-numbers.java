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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curr = new ListNode(0);
        ListNode ans = curr;
        
        int carry = 0;
        
        while(p1 != null || p2 != null){
            int x = p1 != null ? p1.val : 0;
            int y = p2 != null ? p2.val : 0;
            int sum = x+y+carry;
            carry = 0;
            if(sum >= 10){
                carry = 1;
                sum %= 10;
            }
            
            curr.next = new ListNode(sum);
            curr = curr.next;
             if (p1 != null) p1 = p1.next;
             if (p2 != null) p2 = p2.next;
        }
        
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        
        return ans.next;
    }
}