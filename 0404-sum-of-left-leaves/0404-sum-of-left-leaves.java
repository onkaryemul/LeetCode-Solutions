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
    
    private int total = 0;
    
    // TC : O(n) --> for traversing each node of the tree
    // SC : O(logn) --> depth of tree or max height of recursive stack space
    public int sumOfLeftLeaves(TreeNode root) {
        // Base case
        if(root == null) {
            return 0;
        }
        
        sumOfLeftLeavesHelper(root, false);
        
        return total;
    }
    
    
    private void sumOfLeftLeavesHelper(TreeNode root, boolean isLeft) {
        // Base case
        if(root == null) {
            return;
        }
        
        if(isLeft && root.left == null && root.right == null) {
            total += root.val;
            return;
        }
        
        sumOfLeftLeavesHelper(root.left, true);
        sumOfLeftLeavesHelper(root.right, false);
        
        return;
    }
    
}

