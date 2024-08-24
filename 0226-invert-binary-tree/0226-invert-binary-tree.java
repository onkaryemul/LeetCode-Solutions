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
    
    // Using Level Order Traversal (BFS - Breadth First Search)
    public TreeNode invertTree(TreeNode root) {
        // Base case
        if(root == null) {
            return null;
        }
        
        // Apply BFS or level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            
            // Swap left and right child for current node
            TreeNode temp = currNode.left;
            currNode.left = currNode.right;
            currNode.right = temp;
            
            // Add the left and right child of the current node to the queue
            if(currNode.left != null) {
                queue.add(currNode.left);
            }
            
            if(currNode.right != null) {
                queue.add(currNode.right);
            }
        }
        
        return root;
    }

}


/* 
      TreeNode invertTreeRecursive(TreeNode root) {
            if (root == null)
               return null;

            TreeNode left = invertTreeRecursive(root.left);
            TreeNode right = invertTreeRecursive(root.right);
        
            root.left = right;
            root.right = left;

            return root;
      }
*/


