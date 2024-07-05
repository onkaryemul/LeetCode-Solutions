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
    
    private int minDistance = Integer.MAX_VALUE;
    private int initialPoint = -1;
    private int prevCriticalPoint = -1;
    
    
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int index = 1;
        ListNode prev = head; // index 0
        ListNode curr = head.next; // index 1
        
        while(curr.next !=  null) {
            // Check if current node is local maxima or local minima
            if(curr.val > prev.val && curr.val > curr.next.val || curr.val < prev.val && curr.val < curr.next.val) {
                if(initialPoint == -1) { // run only once
                    initialPoint = index;
                }
                
                if(prevCriticalPoint != -1) {
                    minDistance = Math.min(minDistance, index - prevCriticalPoint);
                }
                
                prevCriticalPoint = index;
            }
            
            prev = curr;
            curr = curr.next;
            
            index++;
        }
        
        if(minDistance == Integer.MAX_VALUE) {
            return new int[] {-1, -1};    
        }
        
        return new int[] { minDistance, prevCriticalPoint - initialPoint };
    }
    
}

