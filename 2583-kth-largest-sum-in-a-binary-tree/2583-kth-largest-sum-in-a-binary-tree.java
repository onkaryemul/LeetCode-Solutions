/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    
    // TC : O(n*logk)
    // SC : O(k)
    
    // Using PriorityQueue (Min-Heap) ==> to get the Kth largest sum
    // Using Queue ==> to perform level order traversal in tree (Breadth first search)
    
    
    // Using Min-Heap ==> Optimal approach ==> hence TC : O(n*logk)
    public long kthLargestLevelSum(TreeNode root, int k) {
        // Min-Heap ==> to store "sum of each level" 
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        // Queue ==> to perform level order traversal of tree
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        // Perform level order traversal until queue is empty
        while(!q.isEmpty()) {
            int size = q.size(); // no. of nodes in the current level
            
            long sum = 0;
            // traverse all nodes in the current level & compute sum of each node val
            while(size-- > 0) {
                TreeNode currNode = q.poll();
                
                sum += currNode.val;
                
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        
            // add the current level sum to the priority queue
            pq.add(sum);
            
            if(pq.size() > k) {
                pq.poll(); 
            }
        }
        
        if(pq.size() < k) {
            return -1;
        }
        
        return pq.peek();
    }
    
}

