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
    
    // BFS Traversal Technique
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // Base case
        if(depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        
        depth = depth - 1; // to reach the parent row 
        
        // Applying Breadth First Search(BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
    
        int level = 1;
        
        while(level != depth) {
            int size = queue.size();
            
            while(size-- > 0) {
                TreeNode head = queue.poll();
                if(head.left != null) {
                    queue.offer(head.left);
                }
                if(head.right != null) {
                    queue.offer(head.right);
                }
            }
            
            level++;
        }
        
        // Now the queue contains the parent row, and we have to add new row as a child to this parent row
        
        while(!queue.isEmpty()) {
            TreeNode head = queue.poll();
            
            // store current node's left and right child
            TreeNode leftChild = head.left;
            TreeNode rightChild = head.right;
            
            // Create new node's with value val
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            
            // Make current node's left and right to point to new nodes formed above
            head.left = newLeft;
            head.right = newRight;
            
            // Make new nodes point to stored leftchild and rightchild
            newLeft.left = leftChild;
            newRight.right = rightChild;
        }
        
        return root;
    }
    
}

