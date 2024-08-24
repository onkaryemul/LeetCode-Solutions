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
    // SC : O(n) (recurive stack space)
    
    // Using simple recursion 
    public boolean isSymmetric(TreeNode root) {
        // Base case
        if(root == null) {
            return true;
        }
        
        return checkIfSymmetric(root.left, root.right);
    }
    
    
    // Helper function
    private boolean checkIfSymmetric(TreeNode left, TreeNode right) {
        // Base case
        if(left == null && right == null) {
            return true;
        }
        
        // Check if only one of them is null and other is not-null, then return false
        if((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        
        // Check if current left.val == right.val 
        if(left.val == right.val && checkIfSymmetric(left.left, right.right) && checkIfSymmetric(left.right, right.left)) {
            return true;
        }
        
        return false;
    }
 
}

