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
    public ListNode reverseList(ListNode head) {
        left = head;
        helper(head);
        
        return head;
    }
    
    boolean flag = true;
    ListNode left;
    
    public void helper(ListNode right){
        if(right == null){
            return;
        }
        
        helper(right.next);
        
        if(flag == true){
            if(left == right || left.next == right){
                flag = false;
            }
            
                
                
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
                
                
                left = left.next;
            
        }
    }
}