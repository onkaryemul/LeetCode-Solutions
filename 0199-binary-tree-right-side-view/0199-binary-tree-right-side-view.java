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
    // SC : O(n) ~ O(Height of the tree), indicating that we can use iterative approach ie. level-order traversal
    
    // Using recursive approach 
    
    // Function to return the right view of the binary tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideViewNodes = new ArrayList<>(); // list to store the result
        
        recursiveRightView(root, 0, rightSideViewNodes); // call the recursive function to populate the right-side view -> Using reverse of Preorder traversal : Root - Right - left
        
        return rightSideViewNodes;
    }
    
    
    // Recursive function to traverse the binary tree and populate the right-side view
    private void recursiveRightView(TreeNode root, int level, List<Integer> rightSideViewNodes) {
        // Base case: Check if the current node is null
        if(root == null) {
            return;
        }
        
        // Check if the size of the rightSideViewNodes list is equal to the current level
        if(rightSideViewNodes.size() == level) { // If yes, add the value of current node data to the list
            rightSideViewNodes.add(root.val);
        }
        
        recursiveRightView(root.right, level + 1, rightSideViewNodes); // right child with an increased level
        
        recursiveRightView(root.left, level + 1, rightSideViewNodes); // left child with an increased level
    } 
    
}

