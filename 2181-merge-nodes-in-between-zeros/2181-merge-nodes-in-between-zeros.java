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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        while(temp != null){
            temp.val += temp.next.val;
            if(temp.next.val == 0){
                temp.next = temp.next.next;
                temp = temp.next;
            }
            else{
                 temp.next = temp.next.next;
            }
          
        }
        return head;
    }
}