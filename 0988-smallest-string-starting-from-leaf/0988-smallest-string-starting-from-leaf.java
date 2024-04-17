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
    
    
    public String smallestFromLeaf(TreeNode root) {
        String smallest = ""; // stores the lexicographically smallest string that starts at a leaf of tree & ends at the root
        
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        
        // call traverse function
        traverse(root, list, output); // add all possible strings from root to leaf in output 2D list
        
        // process the paths from root to leaf to find the smallest String
        for(ArrayList<Integer> l : output) {
            StringBuilder sb = new StringBuilder(); 
            
            for(Integer n : l) {
                char ch = (char)(n + 'a');
                sb.append(ch); 
            }
            
            // StringBuilder sb will contain string starting from root to leaf
            // but we want string starting from leaf to root, hence reverse stringbuilder sb 
            String str = sb.reverse().toString();
            
            if(smallest.equals("")) {
                smallest = str;
            }
            
            if(smallest.compareTo(str) > 0) {
                smallest = str;
            }
        }
        
        return smallest;
    }
 
    // Recursion
    private void traverse(TreeNode root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> output) {
        // Base case
        if(root == null) {
            return;
        }
        
        list.add(root.val);
        
        if(root.left == null && root.right == null) {
            output.add(new ArrayList(list));
            return;
        }
        
        traverse(root.left, new ArrayList(list), output);
        traverse(root.right, new ArrayList(list), output);
    }
    
}

