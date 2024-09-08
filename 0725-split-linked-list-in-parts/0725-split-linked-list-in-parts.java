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
    
    // TC : O(L + k) - We are traversing the input linkedlist only once and the array of size k only once
    // SC : O(1), we are not including the result ListNode[]
    
    // Using simple Maths 
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1 : Find the length of the list
        ListNode curr = head;
        int len = 0;
        
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        
        // Step 2 : Calculate the base size of each part and the remainder
        int eachBucketNodes = len / k;
        int remainderNodes = len % k;
        
        // Step 3 : Create an array to hold the resulting ListNode parts
        ListNode[] result = new ListNode[k];
        
        // Step 4 : Reinitialize 'curr' to the head of the list
        curr = head;
        ListNode prev = null;
        
        // Step 5 : Loop over k parts
        for(int i=0; i < k && curr != null; i++) {
            result[i] = curr;
            
            // Step 6 : Loop over the nodes in the current part
            for(int count=1; count <= eachBucketNodes + (remainderNodes > 0 ? 1 : 0); count++) {
                prev = curr;
                curr = curr.next;
            }
            
            // Step 7 : Break the connection after the current part
            if(prev != null) {
                prev.next = null;
            }
            
            // Step 8 : Decrease the remainder count
            remainderNodes--;
        }
        
        return result;
    }
    
}

