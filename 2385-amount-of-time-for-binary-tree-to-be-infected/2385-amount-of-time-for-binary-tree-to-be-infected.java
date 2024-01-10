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
    
    // Helper function
    private void convertTreeToGraph(TreeNode current, int parent, Map<Integer, Set<Integer>> map) {
        // Base case
        if(current == null) {
            return;
        }
        
        // current is not null
        
        // if current.val is not present in map
        if(!map.containsKey(current.val)) {
            map.put(current.val, new HashSet<Integer>());
        }
        
        Set<Integer> adjacentList = map.get(current.val);
        
        if(parent != 0) {
            adjacentList.add(parent);
        }
        
        // Check if left child is not null
        if(current.left != null) {
            adjacentList.add(current.left.val);
        }
        
        // Check if right child is not null
        if(current.right != null) {
            adjacentList.add(current.right.val);
        }
        
        // Recursively call on left and right child
        convertTreeToGraph(current.left, current.val, map); // left child
        convertTreeToGraph(current.right, current.val, map); // right child
    }
    
    
    // Main algorithm code
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        convertTreeToGraph(root, 0, map);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        
        int minutes = 0;
        
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            
            while(levelSize > 0) {
                int current = queue.poll();
                
                for(int num : map.get(current)) {
                    if(!visited.contains(num)) {
                        queue.add(num);
                        visited.add(num);
                    }
                }
                
                levelSize--;
            }
            
            minutes++;
        }
        
        // At minute 0, an infection starts from the node with value start.
        return minutes - 1; 
    }
    
}

