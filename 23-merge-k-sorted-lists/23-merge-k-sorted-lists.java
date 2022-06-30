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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        
        if(lists.length == 1){
            return lists[0];
        }
        

       return helper1(lists,0,lists.length-1);
    }
    
    public ListNode helper1(ListNode[] lists, int st, int end){
        if(st > end) return null;
        if(st == end) return lists[st];
        int mid = (st+end)/2;
        ListNode l1 = helper1(lists,st,mid);
        ListNode l2 = helper1(lists,mid+1,end);
        
        return merge(l1,l2);
    }
    
    public ListNode merge( ListNode one , ListNode two){
        if(one == null || two == null){
            return one == null ? two : one;
            
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        while(one != null && two != null){
            if(one.val <= two.val){
                prev.next = one;
                prev = one;
                one = one.next;
            }
            else{
                 prev.next = two;
                prev = two;
                two = two.next;
            }
        }
        
        if(one == null){
            prev.next = two;
        }
        
        if(two == null){
            prev.next = one;
        }
        
        return dummy.next;
    }
}