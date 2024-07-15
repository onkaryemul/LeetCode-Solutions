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
    
    // TC : O(n), where n is the size of description
    // SC : O(n), size of map and set
    
    // Simple Approach using map and set
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();
        
        // Create nodes and set up parent-child relationships
        for(int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;
            
            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));
            
            if(isLeft) {
                map.get(parent).left = map.get(child);
            }
            else {
                map.get(parent).right = map.get(child);
            }
            
            childSet.add(child);
        }
        
        // Find the root node (which is not any child)
        for(int[] description : descriptions) {
            int parent = description[0];
            if(!childSet.contains(parent)) {
                return map.get(parent);
            }
        }
        
        return null;
    }
    
}

