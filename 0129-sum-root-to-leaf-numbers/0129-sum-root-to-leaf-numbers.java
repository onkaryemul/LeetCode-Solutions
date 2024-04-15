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
    
    private int totalSum = 0;
    
    // TC : O(n)
    // SC : O(n)
    public int sumNumbers(TreeNode root) {
        sumNumbersHelper(root, 0);
        
        return totalSum;
    }
    
    
    private void sumNumbersHelper(TreeNode root, int val) {
        // Base case
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null) {
            totalSum += val*10 + root.val;
            return;
        }
        
        sumNumbersHelper(root.left, val*10 + root.val);
        sumNumbersHelper(root.right, val*10 + root.val);
    }
    
}

