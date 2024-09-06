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
    // SC : O(n)
    
    // Using simple straight forward approach
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Convert the nums[] to a set for O(1) lookup
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);
        }
        
        // Skip the nodes at the start of the list that are present in the set
        while(head != null && set.contains(head.val)) {
            head = head.next;
        }
        
        // Now we process the rest of the list
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null) {
            if(!set.contains(curr.val)) {
                // Move the prev and curr forward
                prev = curr;
                curr = curr.next;
            }
            else { // skip the current node
                if(prev != null) {
                    prev.next = curr.next;
                }
                curr = curr.next;
            }
        }
        
        return head; // return the head of the modified linked list
    }
    
}

