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


// BFS Solution
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public int findBottomLeftValue(TreeNode root) {
        TreeNode node = root;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        
        while(!queue.isEmpty()) {
            node = queue.poll();
            
            // add right child first
            if(node.right != null) {
                queue.add(node.right);
            }
            
            // then add left child
            if(node.left != null) {
                queue.add(node.left);
            }
        }
        
        
        return node.val;
    }
    
}

