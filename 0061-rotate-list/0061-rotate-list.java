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
    
    // TC : O(n+k)
    // SC : O(1)
    
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Compute the length
        ListNode curr = head;
        int len = 1;
        while(curr.next != null) {
            len++;
            curr = curr.next;
        }
        // curr now points to last node in the linkedlist
        
        // Go till that node
        curr.next = head;
        
        k = k % len; // so that k lies in 0 to len-1
        k = len - k; // gives number of places to travel to right 
            
        while(k-- > 0) {
            curr = curr.next;
        }
        
        // Make the node head and break connection
        head = curr.next;
        curr.next = null;
        
        return head;
    }
    
}

