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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = Size(head);
        
        int extra = size%k;
        int mPg = size/k;
        
        // System.out.println(extra + " " + mPg);
        
        ListNode[] res = new ListNode[k];
        
        for(int i = 0; i < k; i++){
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prev = dummy;
            ListNode curr = head;
            
            for(int j = 0; j < mPg ; j++){
                prev = prev.next;
                curr = curr.next;
            }
            
            if(extra > 0){
                prev = prev.next;
                curr = curr.next;
                extra--;
            }
            
            prev.next = null;
            head = curr;
            res[i] = dummy.next;
        }
        
        return res;
        
    }
    
    public int Size(ListNode head){
        int count = 0;
        
        ListNode curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        
        return count;
    }
}