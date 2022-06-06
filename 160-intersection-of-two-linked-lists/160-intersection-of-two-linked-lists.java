/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        int delta = Math.abs(size(headA) - size(headB));
        
        if(size(headA) > size(headB)){
            for(int i = 0; i < delta; i++){
                t1 = t1.next;
            }
        }
        else{
            for(int i = 0; i < delta; i++){
                t2 = t2.next;
            }
        }
        
        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }
        
        return t1;
        
    }
    
    public int size(ListNode node){
        int s = 0;
        
        while(node != null){
            s++;
            node = node.next;
        }
        
        return s;
    }
}