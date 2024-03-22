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
    public boolean isPalindrome(ListNode head) {
        // Base case
        if(head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // for odd number of nodes in a linked list
        if(fast != null) {
            slow = slow.next;
        }
        
        ListNode head1 = head;
        ListNode head2 = reverse(slow);
        
        while(head1 != null && head2 != null) {
            if(head1.val != head2.val) {
                return false;
            }
            
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return true;
    }
    
    
    private ListNode reverse(ListNode head) {
        // Base case
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        
        while(curr != null) {
            next = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            
            curr = next;
        }
        
        return prev;
    }
    
}

