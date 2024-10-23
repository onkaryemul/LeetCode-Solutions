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
    
    // TC : O(n), single pass solution
    // SC : O(n)
    
    // Optimized approach
    
    // Using BFS (Breadth First Search) ie. level order traversal
    
    // In-place replacement of value in tree
    public TreeNode replaceValueInTree(TreeNode root) {
        // Base case / Edge case ==> If tree is empty, then null
        if(root == null) {
            return root;
        }
        
        // Apply BFS (level order traversal)
        // using queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int levelSum = root.val; // current level sum
        
        while(!queue.isEmpty()) {
            int size = queue.size(); // size of current level ==> no. of nodes in that level
            
            int nextLevelSum = 0; // calculate the sum of next level nodes => from this current level
            
            // Process nodes in the current level
            while(size-- > 0) {
                TreeNode curr = queue.poll();
                
                // update current node value
                curr.val = levelSum - curr.val;
                
                // Calculate current node children' sum ==> which are siblings to each other
                int siblingSum = (curr.left != null ? curr.left.val : 0) + (curr.right != null ? curr.right.val : 0);
                
                // Process left child
                if(curr.left != null) {
                    queue.offer(curr.left);
                    
                    nextLevelSum += curr.left.val;
                    
                    curr.left.val = siblingSum;
                }
                
                // Process right child
                if(curr.right != null) {
                    queue.offer(curr.right);
                    
                    nextLevelSum += curr.right.val;
                    
                    curr.right.val =  siblingSum;
                }
            }
            
            // After processing current level nodes & calculating nextlevelsum 
            // we move to the next level => with levelSum of that level = nextLevelSum
            levelSum = nextLevelSum;
        }
        
        return root; // returning root of the modified binary tree
    }
    
}

