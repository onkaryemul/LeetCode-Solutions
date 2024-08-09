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
    
    // TC : O(n)
    // SC : O(n)
    
    // Using BFS(Breadth First Search)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: Check if the root is null, then return an empty result list
        if(root == null) {
            return result;
        }
        
        // Queue to perform the level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean isLeftToRight = true; // flag to determine the direction of traversal (i.e. left to right or right to left)
        
        
        while(!queue.isEmpty()) {
            int size = queue.size(); // get the no. of nodes at the current level
            
            List<Integer> row = new ArrayList<>(); // list to store the values of nodes at the current level
            
            // traversing nodes at the current level
            for(int i=0; i < size; i++) { 
                TreeNode currNode = queue.poll(); // get the front node from the queue
                
                int index = isLeftToRight ? i : (size-1-i); // determine the index to insert the node's value based on the traversal direction
                
                
                if(isLeftToRight) {
                    row.add(currNode.val); // append to the end of the list
                } else {
                    row.add(0, currNode.val); // insert at the beginnig of the list
                }
             
                
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            
            // Switch the traversal direction for the next level
            isLeftToRight = ! isLeftToRight;
            
            result.add(row); // add the current level's values to the result list
        } 
        
        return result;
    }
    
}


