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
    
    int maxDiff;
    
    
    // helper function
    private void helper(TreeNode root, int currMaxAncestor, int currMinAncestor) {
        // Base case
        if(root == null) {
            return;
        }
        
        int currDiff = Math.max(Math.abs(root.val - currMaxAncestor), Math.abs(root.val - currMinAncestor));
        
        maxDiff = Math.max(maxDiff, currDiff);
        
        currMaxAncestor = Math.max(currMaxAncestor, root.val);
        currMinAncestor = Math.min(currMinAncestor, root.val);
        
        // recursively call on left and right child
        helper(root.left, currMaxAncestor, currMinAncestor); // left child
        helper(root.right, currMaxAncestor, currMinAncestor); // right child
    }
    
    
    // Main algorithm code: 
    // TC : O(n) , visits each node of the tree
    // SC : O(n) , due to recursive call stack
    public int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;
        
        if(root == null) {
            return maxDiff;
        }
        
        helper(root, root.val, root.val);
        
        return maxDiff;
    }
    
}

