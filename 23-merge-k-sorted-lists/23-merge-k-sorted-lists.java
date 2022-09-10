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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> {
            return a.val - b.val;
        });
        
        if(lists.length == 0 ){
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null)
                pq.add(lists[i]);
        }
        
        while(pq.size() > 0){
            ListNode rem = pq.remove();
            curr.next = rem;
            curr = rem;
            
            if(rem.next != null){
                pq.add(rem.next);
            }
        }
        
        return dummy.next;
    }
}