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
    public void reorderList(ListNode head) {
        // Base case
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        ListNode slowPrev = null;
        
        while(fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slowPrev.next = null;
        
        // slow -> is the head of 2nd list
        ListNode reverseHead = reverse(slow);
        
        ListNode mergedHead = new ListNode(-1);
        ListNode it = mergedHead;
        
        ListNode it1 = head;
        ListNode it2 = reverseHead;
        
        while(it1 != null && it2 != null) {
            ListNode for1 = it1.next;
            ListNode for2 = it2.next;
            
            it.next = it1;
            it = it.next;
            
            it.next = it2;
            it = it.next;
            
            it1 = for1;
            it2 = for2;
        }
        
        head = mergedHead.next;
        
        return;
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

