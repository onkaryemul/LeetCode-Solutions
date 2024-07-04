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
    
    public ListNode mergeNodes(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyItr = dummyNode;
        
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            int sumOfNodes = 0;
            
            while(curr != null && curr.val != 0) {
                sumOfNodes += curr.val;
                curr = curr.next;
            }
            
            if(sumOfNodes != 0) {
                dummyItr.next = new ListNode(sumOfNodes);
                dummyItr = dummyItr.next;
            }
        }
        
        return dummyNode.next;
    }
    
}

