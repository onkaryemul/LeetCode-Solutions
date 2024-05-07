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
    
    public ListNode doubleIt(ListNode head) {
        // 1. Reverse the given linked list
        head = reverse(head);
        
        ListNode curr = head;
        int carry = 0;
        
        while(curr != null) {
            int x = curr.val;
            int s = (2*x) + carry;
            carry = s/10;
            
            curr.val = s%10;
            
            curr = curr.next;
        }
        
        // 3. Again reverse the updated linked list to get required answer
        head = reverse(head);
        
        if(carry == 1) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }
        
        // return the head of the linked list after doubling it
        return head;
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

