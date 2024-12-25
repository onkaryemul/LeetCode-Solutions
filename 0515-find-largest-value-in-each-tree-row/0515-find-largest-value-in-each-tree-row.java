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
    // SC : O(Height of tree) => due to recursive stack space
    
    // Using DFS (depth first search) traversal ==> optimal technique for non-skewed tree
    
    private List<Integer> result = new ArrayList<>();
    
    
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0); // dfs(root, depth)
        
        return result;
    }
    
    // Helper function => DFS
    private void dfs(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
        
        if(depth == result.size()) {
            result.add(root.val);
        }
        else {
            // result[depth] = Math.max(result[depth], root.val);
            result.set(depth, Math.max(result.get(depth), root.val));
        }
        
        dfs(root.left, depth + 1);
        
        dfs(root.right, depth + 1);
    }
    
}


/*
// Approach-1 (Using BFS)
// T.C : O(n) we visit each node once.
// S.C : O(n) taken by quque

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxEl = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                maxEl = Math.max(maxEl, node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(maxEl);
        }

        return result;
    }
*/

