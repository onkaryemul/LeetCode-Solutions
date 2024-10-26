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
    
    // TC : O(n + m), where n = no. of nodes in the tree & m = no. of queries
    // SC : O(n + m), for using HashMap to store heights and precomputional results & also to return an array of size m indicating height of tree after performing the ith query
    
    // Using DFS approach => to compute and store results in 2nd hashmap => so that to get the results of ith query in O(1)
    
    // Using two hashmap 
    // 1st hashmap => to store height at that node
    private HashMap<Integer, Integer> heights = new HashMap<>();
    
    // 2nd hashmap => to store max height at that node => after removing that node
    private HashMap<Integer, Integer> preComputeResults = new HashMap<>();
    
    // function to return an array ans[] of size m => where ans[i] = height of the tree after performing ith query i.e height of the tree after removing subtree rooted at queries[i]
    public int[] treeQueries(TreeNode root, int[] queries) {
        dfs(root, 0, 0);
        
        int m = queries.length;
        int[] ans = new int[m];
        
        for(int i=0; i < m; i++) {
            ans[i] = preComputeResults.get(queries[i]);
        }
        
        return ans;
    }
    
    
    // Helper function => applying DFS(Depth First Search)
    private void dfs(TreeNode root, int currHeight, int maxHeight) { 
        // Base case
        if(root == null) {
            return;
        }
        
        preComputeResults.put(root.val, maxHeight);
        
        dfs(root.left, currHeight + 1, Math.max(maxHeight, currHeight + 1 + height(root.right)));
        
        dfs(root.right, currHeight + 1, Math.max(maxHeight, currHeight + 1 + height(root.left)));
    }
    
    
    // Helper function => to calculate the height of the subtree/Tree rooted at given TreeNode
    private int height(TreeNode root) {
        // Base case
        if(root == null) {
            return -1;
        }
        
        // Check if height is already precomputed for current TreeNode value
        if(heights.containsKey(root.val)) {
            return heights.get(root.val);
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        heights.put(root.val, 1 + Math.max(leftHeight, rightHeight));
        
        return heights.get(root.val);
    }
    
}

