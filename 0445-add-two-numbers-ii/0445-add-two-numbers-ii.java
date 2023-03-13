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
    
    public ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        
        ListNode prev = null;
        ListNode curr = node;
        ListNode forw = node.next;
        
        while(forw != null){
            curr.next = prev;
            prev = curr;
            curr = forw;
            
            forw = forw.next;
        }
        
        curr.next = prev;
        prev = curr;
        
        return prev;
        
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        
        ListNode t1 = reverse(l1);
        ListNode t2 = reverse(l2);
        
        ListNode res = sum(t1,t2);
        
        return reverse(res);
    }
    
    
    public ListNode sum(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0){
            int s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = 0;
            if(s >= 10){
                carry = 1;
                s = s%10;
            }
            
            ListNode nNode = new ListNode(s);
            prev.next = nNode;
            prev = nNode;
            
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        
        return dummy.next;
    }
}