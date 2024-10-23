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
    
    // TC : O(n), since visiting each node of the tree exactly once
    // SC : O(n), for Queue => to perform level order traversal
    
    // Using BFS (Breadth First Search) ===> Level order traversal
    
    // function to check if two nodes with values x and y are cousins or not 
    public boolean isCousins(TreeNode root, int x, int y) {
        // Two nodes of a binary tree are cousins ==>
        // if they have the" same depth" with "different parents"
        
        // Since using BFS (ie. level order traversal) => we don't need to keep track of depth
        // as we traverse all nodes at that level ==> in same iteration
        // hence, all nodes in that level ==> have same depth
        
        // Base case / Edge case ==> If tree is empty, then return false
        if(root == null) {
            return false;
        }
        
        // Apply BFS (level order traversal) using queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        TreeNode xParent = null, yParent = null;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            // Process nodes in the current level
            while(size-- > 0) {
                TreeNode curr = queue.poll();
                
                // Check if curr node left child exists
                if(curr.left != null) { // if yes, then insert its left node in to the queue for next level
                    queue.offer(curr.left);
                    
                    if(curr.left.val == x) {
                        xParent = curr;
                    } 
                    else if(curr.left.val == y) {
                        yParent = curr;
                    }
                }
                
                // Check if curr node right child exists
                if(curr.right != null) { // if yes, then inser its right node in to the queue for next level
                    queue.offer(curr.right);
                    
                    if(curr.right.val == x) {
                        xParent = curr;
                    }
                    else if(curr.right.val == y) {
                        yParent = curr;
                    }
                }
                
                // Check if both xParent & yParent are not null
                if(xParent != null && yParent != null) {// if yes, then check if parents are not same
                    if(xParent != yParent) { // if both parents of nodes with values x and y are not same,==> it means that they are cousins
                        return true;
                    }
                    else { // otherwise, if parents of both nodes with values x and y are same, then they are siblings ==> and hence not cousines
                        return false; 
                    }
                }
            }
            
            // After processing current level, if we found parent of one of the nodes but not the parent of other node ==> which means that they are not at same depth ==> hence not cousins
            if((xParent != null && yParent == null) || (xParent == null && yParent != null)) {
                return false;
            }
        }    
        
        return false;
    }
    
}


/*

// Using DFS

class Solution {

    private int xDepth = -1;
    private int yDepth = -2;

    private TreeNode xParent = null;
    private TreeNode yParent = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return true;
        }

        isCousinsHelper(root, x, y, 0,  null);
        
        return xDepth==yDepth && xParent !=yParent;
    }

    private  void isCousinsHelper(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if(root == null){
            return ;
        }
        else if(root.val == x){
            xParent = parent;
            xDepth = depth;
        } else if(root.val == y){
            yParent = parent;
            yDepth = depth;
        } else {
            isCousinsHelper(root.left, x, y, depth+1, root);
            isCousinsHelper(root.right, x, y, depth+1, root);
        }
    }
}
*/

