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
    public ListNode partition(ListNode head, int x) {
        ListNode d1 = new ListNode();
        ListNode d2 = new ListNode();
        
        ListNode l1 = d1;
        ListNode l2 = d2;
        
        ListNode curr = head;
        while(curr != null){
            if(curr.val < x){
                l1.next = curr;
                l1 = curr;
                curr = curr.next;
                l1.next = null;
            }
            else{
                l2.next = curr;
                l2 = curr;
                curr = curr.next;
                l2.next = null;
            }
        }
        
        l1.next = d2.next;
        
        return d1.next;
    }
}