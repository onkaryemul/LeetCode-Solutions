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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        
        ListNode current = head;
        
        while(current != null) {
            length++;
            current = current.next;
        }
        
        if(n == length) {
            head = head.next;
            return head;
        }
        
        current = head;
        
        for(int i=0; i < length - n - 1; i++) {
            current = current.next;
        }
        
        current.next = current.next.next;
        
        return head;
    }
    
}

