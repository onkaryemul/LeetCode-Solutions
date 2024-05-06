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
    
    public ListNode removeNodes(ListNode head) {
        // 1. Reverse the given linked list
        ListNode newHead = reverse(head);
        
        ListNode curr = newHead;
        
        ListNode maxNode = curr;
        ListNode temp = null;
        
        while(curr.next != null) {
            if(curr.next.val < maxNode.val) {
                temp = curr.next;
                curr.next = temp.next;
            }
            else {
                curr = curr.next;
                maxNode = curr;
            }
        }
        
        // 3. Again reverse the linked list to get the answer required
        return reverse(newHead);
    }
    
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

}

