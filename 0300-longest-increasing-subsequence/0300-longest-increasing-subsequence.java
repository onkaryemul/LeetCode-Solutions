// TC : O(n*logn)
class Solution {
    
    // Longest Increasing Subsequence
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> bst = new TreeSet<>();
        
        for(int num : nums) {
            Integer higherOrEqual = bst.ceiling(num);
            if(higherOrEqual == null) {
                bst.add(num);
            } else {
                bst.remove(higherOrEqual);
                bst.add(num);
            }
        }
        
        return bst.size();
    }
    
}
