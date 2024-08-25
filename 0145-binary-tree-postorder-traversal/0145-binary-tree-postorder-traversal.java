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
    
    // Using stack --> iterative approach
    // PostOrder traversal :-->  Left - Right - Root
    // So, we insert root noode at first, then left node and then right node in order to access right node first
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        
        // Base case
        if(root == null) {
            return postOrder;
        }
        
        // Use ArrayDeque as Stack
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pollLast();
            
            postOrder.add(curr.val);
            
            if(curr.left != null) {
                stack.add(curr.left);
            }
            
            if(curr.right != null) {
                stack.add(curr.right);
            }
        }
        
        Collections.reverse(postOrder);
        
        return postOrder;
    }
    
}


/* 
    List<Integer> postOrder = new ArrayList<>();
    
    // Recursive approach
    // Left - Right - Root
    public List<Integer> postOrderTraversal(TreeNode root) {
       // Base case
       if(root == null) {
          return null;
       }
       
       postOrderTraversal(root.left);
       
       postOrderTraversal(root.right);
       
       postOrder.add(root.val);
       
       return postOrder;
    }

*/
    
