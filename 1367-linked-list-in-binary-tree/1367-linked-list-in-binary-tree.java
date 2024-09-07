/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

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
    
    // Using Simple Recursion -> Depth First Search(DFS)
    
    // TC : O(n * m), n = no. of nodes in tree, m = no. of nodes in linkedlist
    // For every node in tree(n) as starting node we will try matching with m nodes in the list -> O(n*m)
    
    // SC : O(n + m), since we are running recursion, we will take system recursion stack => O(n + m)
    
    // Main function to check if the linked list is a subpath of the binary tree
    public boolean isSubPath(ListNode head, TreeNode root) {
        // Base case: If the tree is empty, there is 'no' path to check
        if(root == null) {
            return false;
        }
        
        // Check the current root, and recursively check the left and right subtrees
        return check(head, root) ||
               isSubPath(head, root.left) ||
               isSubPath(head, root.right);
    }
    
    
    // Helper function that checks if the linked list starting from 'head' is a subpath of the binary tree starting from 'root' 
    private boolean check(ListNode head, TreeNode root) {
        // Base case: If we have reached the end of the linked list, it means we have found a valid path
        if(head == null) {
            return true;
        }
        
        // Base case: If the tree node is null or the values don't match, the path is not valid
        if(root == null || root.val != head.val) {
            return false;
        }
        
        // recursively check the left and right subtrees
        return check(head.next, root.left) ||
               check(head.next, root.right);
    }
    
}

