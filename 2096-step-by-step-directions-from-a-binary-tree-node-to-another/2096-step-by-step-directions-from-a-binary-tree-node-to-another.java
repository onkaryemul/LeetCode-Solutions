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
    // SC : O(n)
    
    // Using LCA (Lowest Common Ancestor)
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = lowestCommonAncestor(root, startValue, destValue);
        
        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();
        
        findPath(LCA, startValue, lcaToStart);
        findPath(LCA, destValue, lcaToDest);
        
        StringBuilder result = new StringBuilder();
        int n = lcaToStart.length();
        for(int i=0; i < n; i++) {
            result.append('U');
        }
        
        result.append(lcaToDest);
        
        return result.toString();
    }
    
    
    // Function to return LCA(lowest common ancestor) of two nodes
    private TreeNode lowestCommonAncestor(TreeNode root, int src, int dest) {
        // Base case
        if(root == null) {
            return null;
        }
        
        if(root.val == src || root.val == dest) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, src, dest);
        TreeNode right = lowestCommonAncestor(root.right, src, dest);
        
        if(left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
    
    
    // Function to trace path from given node to target
    private boolean findPath(TreeNode node, int target, StringBuilder path) {
        // Base case
        if(node == null) {
            return false;
        }
        
        if(node.val == target) {
            return true;
        }
        
        path.append('L');
        if(findPath(node.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        path.append('R');
        if(findPath(node.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }
    
    
}

