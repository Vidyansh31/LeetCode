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
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0){
            int sum = (l1 != null ? l1.val : 0 ) + (l2 != null ? l2.val : 0) + carry;
            carry = 0;
            
            if(sum >= 10){
                carry = 1;
                sum %= 10;
            }
            
            ListNode nNode = new ListNode(sum);
            curr.next = nNode;
            curr = curr.next;
            
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        
        return ans.next;
        
    }
}