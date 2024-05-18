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
    
    private int ans;
    
    public int distributeCoins(TreeNode root) {
        ans = 0;
        
        helper(root);
        
        return ans;
    }
    
    // helper function => recursive function
    private int helper(TreeNode root) {
        // Base case
        if(root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        ans += Math.abs(left) + Math.abs(right);
        
        return root.val + left + right - 1;
    }
    
}

