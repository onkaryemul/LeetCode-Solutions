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
    
    // TC : O(k*logk)
    // SC : O(recursive stack space)
    
    // Similar to Merge sort
    // Using technique of merge 2 sorted lists
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case / Corner case
        if(lists == null || lists.length == 0) {
            return null;
        }
        
        int k = lists.length;
        
        return helper(lists, 0, k-1);
    }
    
    
    private ListNode helper(ListNode[] lists, int low, int high) {
        // Base case
        if(low > high) {
            return null;
        }
        
        // Edge case
        if(low == high) {
            return lists[low]; // or lists[high]
        }
        
        // Applying merge sort technique
        int mid = low + (high - low)/2;
        
        ListNode left = helper(lists, low, mid);
        ListNode right = helper(lists, mid+1, high);
        
        return merge(left, right);
    }
    
    
    private ListNode merge(ListNode list1, ListNode list2) {
        // Edge cases
        if(list1 == null) {
            return list2;
        }
        
        if(list2 == null) {
            return list1;
        }
        
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        
        while(temp1 != null && temp2 != null) {
            if(temp1.val < temp2.val) {
                curr.next = temp1;
                temp1 = temp1.next;
            }
            else {
                curr.next = temp2;
                temp2 = temp2.next;
            }
            curr = curr.next;
        }
        
        if(temp1 != null) {
            curr.next = temp1;
        }
        
        if(temp2 != null) {
            curr.next = temp2;
        }
        
        return dummyNode.next;
    }
    
}


/*  
    // TC:  Klogk
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0){
            return null;
        }

        Comparator<ListNode> customCompare = new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val -b.val;
            }
        };

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode> (customCompare);

        for(ListNode list : lists){
            if(list !=null){
                pq.offer(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;

        while(!pq.isEmpty()){
            ListNode lowesetValNode = pq.poll();
            t.next = lowesetValNode;
            t   =   t.next;

            if(lowesetValNode.next!=null){
                pq.offer(lowesetValNode.next);
            }
        }

        return dummy.next;
    }
*/

