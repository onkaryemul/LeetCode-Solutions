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
    
    // TC : O(n + n*logn)
    // SC : O(n)
    
    // Using BFS + Cyclic sort
    
    // Using Cyclic sort ==> to calculate minimum number of swaps required to sort array
    
    public int minimumOperations(TreeNode root) {
        // Apply BFS (level order) traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int minSwaps = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            List<Integer> values = new ArrayList<>();
            
            for(int i=0; i < size; i++) {
                TreeNode curr = queue.poll();
                
                values.add(curr.val);
                
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            
            minSwaps += findMinSwaps(values);
        }
        
        return minSwaps;
    }
    
    
    // Helper function => to find minimum swaps required to sort the array
    // Using cyclic sort
    private int findMinSwaps(List<Integer> values) {
        int n = values.size();
        
        int minSwaps = 0;
        
        // Step 1 : Map to store the value -> original index
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        
        for(int i=0; i < n; i++) {
            valueIndexMap.put(values.get(i), i);
        }
        
        // Step 2 : Sort the values to get the expected positions
        List<Integer> sortedValues = new ArrayList<>(values);
        Collections.sort(sortedValues);
        
        boolean[] visited = new boolean[n];
        
        for(int i=0; i < n; i++) {
            if(visited[i] || valueIndexMap.get(sortedValues.get(i)) == i) {
                continue;
            }
            
            // Find cycle length
            int cycleLength = 0;
            int j = i;
            
            while(!visited[j]) {
                visited[j] = true;
                
                j = valueIndexMap.get(sortedValues.get(j));
                
                cycleLength++;
            }
            
            minSwaps += (cycleLength - 1);
        }
        
        return minSwaps;
    }
    
    
}

