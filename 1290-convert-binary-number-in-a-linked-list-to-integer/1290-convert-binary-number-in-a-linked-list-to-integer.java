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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        
        return prev;
        
    }
    public int getDecimalValue(ListNode head) {
        ListNode rhead =  reverse(head);
        
        int p = 0;
        int x = 2;
        int res = 0;
        
        while(rhead != null){
            if(rhead.val == 1){
                res += Math.pow(x,p);
            }
            
            p++;
            rhead = rhead.next;
        }
        
        return res;
    }
}