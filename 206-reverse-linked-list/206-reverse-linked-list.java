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
    
    public int sizeofLL(ListNode head){
        int size = 0;
        while(head.next != null){
            size++;
            head = head.next;
        }
            
        return size;
    }
    
    public ListNode getNodeAtIdx(ListNode head,int idx){
        ListNode curr = head;
        
        for(int i = 0; i < idx; i++){
            curr = curr.next;
        }
        return curr;
    }
    
    public ListNode reverseList(ListNode head) {
        // Approach 1: Data iterative
        if(head == null){
            return null;
        }
        int size = sizeofLL(head);
        
        int i = 0;
        int j = size;
        
        while(i < j){
            ListNode left = getNodeAtIdx(head,i);
            ListNode right = getNodeAtIdx(head,j);
            
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
            
            i++;
            j--;
        }
        
        return head;
    }
}