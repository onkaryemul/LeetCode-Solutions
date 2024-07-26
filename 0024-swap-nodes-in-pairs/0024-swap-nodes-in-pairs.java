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
    
    // TC : O(n)
    // SC : O(1)
    
    // Simple recursion approach
    public ListNode swapPairs(ListNode head) {
        // Base case
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode nextNode = head.next;
        
        head.next = swapPairs(head.next.next);
        
        nextNode.next = head;
        
        return nextNode;
    }
    
}

