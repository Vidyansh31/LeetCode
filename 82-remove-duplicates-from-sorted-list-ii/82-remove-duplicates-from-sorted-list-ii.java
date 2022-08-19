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
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ListNode curr = head;
        while(curr != null){
            map.put(curr.val, map.getOrDefault(curr.val,0)+1);
            curr = curr.next;
        }
        
        curr = head;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        
        while(curr != null){
            if(map.get(curr.val) == 1){
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            }
            else{
                int count = map.get(curr.val);
                while(count-- > 0){
                    curr = curr.next;
                }
            }
        }
        prev.next = null;
        
        return dummy.next;
    }
}