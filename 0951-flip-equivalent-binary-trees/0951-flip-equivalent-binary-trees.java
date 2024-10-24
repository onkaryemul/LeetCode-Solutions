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
    
    // TC : ~O(4*n)
    // SC : O(n) i.e O(max depth of tree) ==> due to recursive stack space
    
    // Using Simple Recursion (Recursion Leap of Faith)
    
    // function to return true if the two trees are flip equivalent or false otherwise
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base case ===> If both trees are empty, then they are flip equivalent
        if(root1 == null && root2 == null) {
            return true;
        }
        
        // If one of them is empty and other is non-empty, then they are not flip equivalent
        if(root1 == null || root2 == null) {
            return false;
        }
        
        // If both are non-empty, then check if values of current nodes of both trees are identical
        if(root1.val == root2.val) {
            boolean withoutFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            boolean withFlip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            return withoutFlip || withFlip;
        }
        
        return false;
    }
    
}

