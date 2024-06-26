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
    
    
    // Simple Approach using Inorder Tree Traversal
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        inorder(root, list);
        
        return constructBalanceBST(0, list.size()-1, list);
    }

    
    private void inorder(TreeNode root, List<Integer> list) {
        // Base case
        if(root == null) {
            return;
        }
        
        inorder(root.left, list); // left
        
        list.add(root.val); // root
        
        inorder(root.right, list); // right
    }
    
    
    private TreeNode constructBalanceBST(int l, int r, List<Integer> list) {
        // Base case
        if(l > r) {
            return null;
        }
        
        int mid = l + (r-l)/2;
        
        TreeNode root = new TreeNode(list.get(mid));
        
        root.left = constructBalanceBST(l, mid-1, list);
        root.right = constructBalanceBST(mid+1, r, list);
        
        return root;
    }
    
}

