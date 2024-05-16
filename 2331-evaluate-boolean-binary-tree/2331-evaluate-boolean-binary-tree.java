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
    
    private int calc(TreeNode root, int value) {
        // Base case
        if (root == null) {
            return value;
        }
        
        if (root.val == 1) {
            value = 1;
        } else if (root.val == 0) {
            value = 0;
        }
        
        int left = calc(root.left, value);
        int right = calc(root.right, value);
        
        if (root.val == 2) {
            value = left | right;
        } else {
            value = left & right;
        }
        
        return value;
    }

    
    public boolean evaluateTree(TreeNode root) {
        // code here
        int x = calc(root, 0);
        return x == 1;
    }
    
}

