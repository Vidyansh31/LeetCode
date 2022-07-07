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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public ListNode middleofLL(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        
        if(head.next==null){
            TreeNode treeNode=new TreeNode(head.val);
            return treeNode;
        }
        
        ListNode middle = middleofLL(head);
        TreeNode root = new TreeNode(middle.val);
        
        //left subtree
        ListNode l1 = head;
        while(l1.next != middle){
            l1 = l1.next;
        }
        l1.next = null;
        
        ListNode left = head;
        
        //right subtree
        ListNode right = middle.next;
        
        
        root.left = sortedListToBST(left);
        root.right = sortedListToBST(right);
        
        return root;
        
    }
}