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



// TC : O(n)
// SC : log(n)
class Solution {
    
    private int sum = 0;
    
    // helper function
    private void rangeSumBSTHelper(TreeNode root, int low, int high) {
        // Base case
        if(root == null) {
            return;
        }
        
        if(low <= root.val && root.val <= high) {
            sum += root.val;
            rangeSumBSTHelper(root.left, low, root.val);
            rangeSumBSTHelper(root.right, root.val, high);
        } 
        else if (root.val < low) {
            rangeSumBSTHelper(root.right, low, high);            
        }
        else if (root.val > high) {
            rangeSumBSTHelper(root.left, low, high);
        }
    }
    
    // Main algorithm code
    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeSumBSTHelper(root, low, high);
        return sum;
    }
    
}

