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
    public int sizeof(ListNode node){
        int size = 0;
        while(node != null){
            size++;
            node = node.next;
        }
        
        return size;
    }
    
    public ListNode getNodeAtIdx(ListNode node, int idx){
        ListNode curr = node;
        for(int i = 0; i < idx; i++){
            curr = curr.next;
        }
        
        return curr;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = sizeof(head);
        // System.out.println(size);
        int numOfReversing = size/k;
        if(numOfReversing == 0){
            return head;
        }
    
        int idx = 0;
        
        while(numOfReversing > 0){
            reverse(head,idx, idx+k-1);
            idx += k;
            
            numOfReversing--;
        }
        
        return head;
        
    }
    
    public void reverse(ListNode node, int st, int end){
        while(st < end){
            ListNode left = getNodeAtIdx(node,st);
            ListNode right = getNodeAtIdx(node,end);
            
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
            st++;
            end--;
        }
    }
}