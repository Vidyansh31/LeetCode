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
        

        int j  = 1;
        
        while(j < lists.length){
            ListNode one = lists[0];
            ListNode two = lists[j];
            helper(lists,one, two);
            j++;
        }
        
        
        return lists[0];
    }
    
    public void helper(ListNode[] lists, ListNode one , ListNode two){
        if(one == null || two == null){
            lists[0] = one == null ? two : one;
            return;
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
        
        lists[0] = dummy.next;
    }
}