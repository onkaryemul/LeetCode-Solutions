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
    // SC : O(height of tree)
    
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    
    private boolean isValidBSTHelper(TreeNode root, long minVal, long maxVal) {
        // Base case
        if(root == null) {
            return true;
        }
        
        if(root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        
        return isValidBSTHelper(root.left, minVal, root.val) && isValidBSTHelper(root.right, root.val, maxVal);
    }
    
}

