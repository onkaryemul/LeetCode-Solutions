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
    
    // BFS Approach :
    // TC : O(n)
    // SC : O(n)
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int level = 0;  
        
        while(!queue.isEmpty()) {
            TreeNode prevNode = null;
            
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                TreeNode currNode = queue.poll();
                
                if(level % 2 == 0) { // even-level
                    if(currNode.val % 2 == 0) {
                        return false; // return false if it is even  -> it should be odd
                    }
                    
                    if(prevNode != null && prevNode.val >= currNode.val) {
                        return false; // return false if it is descreasing --> it should strictly increase
                    }
                } 
                else { // odd-level
                    if(currNode.val % 2 == 1) {
                        return false; // return false if it is odd --> it should be even
                    }
                    
                    if(prevNode != null && prevNode.val <= currNode.val) {
                        return false; // return false if it is ascending --> it should strictly descrease
                    }
                }
                
                prevNode = currNode;
                
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            
            level++;
        }
        
        
        return true;
    }
    
}


