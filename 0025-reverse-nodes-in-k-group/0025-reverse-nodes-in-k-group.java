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
    
    // TC : O(2N), reversing segment of k & finding the kth node which operates in linear time
    // SC : O(1)
    
    
    // Function to reverse nodes in groups of k
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head; // initialize a temporary node to traverse the list
        ListNode prevLast = null; // pointer to track the last node of the previous group
        
        // traverse through the linked list
        while(temp != null) {
            // Get the kth node of the current group
            ListNode kthNode = getKthNode(temp, k);
            
            // If the kth node is NULL (not a complete group)
            if(kthNode == null) {
                // If there was a previous group, link the last node of the previous group t o the current temp node
                if(prevLast != null) {
                    prevLast.next = temp;
                }
                
                break; // exit the loop
            }
            
            ListNode nextNode = kthNode.next; // store the next node after the kth node
            
            kthNode.next = null; // disconnect the kth node to prepare for reversal
            
            reverse(temp); // reverse the nodes from temp to the kth node
            
            // Adjust the head if the reversal starts from the head
            if(temp == head) {
                head = kthNode;
            } else {
                // Link the last node of the previous group to the reversed group
                prevLast.next = kthNode;
            }
            
            prevLast = temp; // update the pointer to the last node of the previous group
             
            temp = nextNode; /// move to the next group
        }
        
        return head; // return the head of the modified linked list
    }
    

    // Function to reverse a linked list using the 3-pointer approach
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next;
        
        while(curr != null) {
            next = curr.next; // store the next node of curr node to preserve the reference
            curr.next = prev; // reverse the direction of the curr node's next pointer to 'prev'
            prev = curr; // move 'prev' to the current node for the next iteration
            curr = next; // move 'curr' to the 'next' advancing the traversal
        }
        
        return prev; // return the new head of the reversed linked list
    }

    
    // Function to get Kth node from a given position in the linked list
    private ListNode getKthNode(ListNode curr, int k) {
        k -= 1; // decrement k as we already start from the 1st node
        
        // Decrement K until its reaches the desired position
        while(curr != null && k > 0) {
            curr = curr.next; // move curr to the next node
            k -= 1; // decrement k as curr progresses
        }
        
        return curr; // return kth node
    }
    
}

