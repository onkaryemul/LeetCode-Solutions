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
    // SC : O(logH)
    
    private int greaterNodeSum = 0;
    
    // Reverse Inorder Traversal -->  Right - Root - Left
    public TreeNode bstToGst(TreeNode root) {
        // Base case
        if(root == null) {
            return null;
        }
        
        bstToGst(root.right); // right 
        
        // root
        root.val = root.val + greaterNodeSum;
        greaterNodeSum = root.val;
        
        bstToGst(root.left); // left
        
        return root;
    }
    
}

