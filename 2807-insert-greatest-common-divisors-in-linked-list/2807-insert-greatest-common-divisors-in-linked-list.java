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
    
    // Using Iterative approach
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // Base case/Edge cases/Corner cases
        // If the list is empty or has only one element, return the head as is
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode currNode = head;
        ListNode nextNode = head.next;
        
        while(nextNode != null) {
            // Create a new node with the GCD of current and next node values
            ListNode temp = new ListNode(gcd(currNode.val, nextNode.val));
            
            // Insert the new node between currNode and nextNode
            currNode.next = temp;
            temp.next = nextNode;
            
            // Move to the next pair of nodes
            currNode = nextNode;
            nextNode = nextNode.next;
        }
        
        return head;
    }
    

    // Helper method to calculate GCD of two numbers
    private int gcd(int a, int b) {
        // Base case
        if(b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }

}

