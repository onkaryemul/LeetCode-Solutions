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
    
    // TC : O(n^2)
    // SC : O(n)
    
    // Using undirected graph and DFS
    public int countPairs(TreeNode root, int distance) {
        // Make undirected graph from given tree and also store leaf nodes
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>(); // leaf nodes
        
        makeGraph(root, null, adj, leafNodes); // O(n)
        
        int count = 0; // count of good node pairs
        
        for(TreeNode leaf : leafNodes) {
            // Perform BFS and see if you can find other leaf nodes within given distance
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            
            queue.add(leaf);
            visited.add(leaf);
            
            // Only go till level <= distance
            for(int level = 0; level <= distance; level++) {
                int size = queue.size();
                // Process level
                while(size-- > 0) {
                    TreeNode curr = queue.poll();
                    
                    if(curr != leaf && leafNodes.contains(curr)) {
                        count++;
                    }
                    
                    for(TreeNode neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                        if(!visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }
        
        return count / 2;
    }
    
    
    // Make undirected graph from given tree and also store leaf nodes
    private void makeGraph(TreeNode root, TreeNode prev, Map<TreeNode, List<TreeNode>> adj, Set<TreeNode> leafNodes) {
        // Base case
        if(root == null) {
            return;
        }
        
        // Check if it is leaf node
        if(root.left == null && root.right == null) {
            leafNodes.add(root);
        }
        
        if(prev != null) {
            adj.computeIfAbsent(root, k -> new ArrayList<>()).add(prev);
            adj.computeIfAbsent(prev, k -> new ArrayList<>()).add(root);
        }
        
        makeGraph(root.left, root, adj, leafNodes);
        makeGraph(root.right, root, adj, leafNodes);
    }
    
}

