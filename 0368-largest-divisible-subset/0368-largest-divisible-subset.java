class Solution {
    
    List<Integer> result;
    int[] subsetSizeMemo;
    
    
    // Main algorithm code: TC : O(2^n) & SC : O(n)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        
        subsetSizeMemo = new int[nums.length];
        Arrays.fill(subsetSizeMemo, -1);
        
        result = new ArrayList<>();
        
        helper(nums, /* start Index */0, new ArrayList<>(), /* prev */1);
        
        return result;
    }
    
    
    private void helper(int[] nums, int index, List<Integer> currList, int prev) {
        // Base condition
        if(currList.size() > result.size()) {
            result = new ArrayList<>(currList);
        }
        
        for(int i=index; i < nums.length; i++) {
            
            if(currList.size() > subsetSizeMemo[i] && nums[i] % prev == 0) {
                subsetSizeMemo[i] = currList.size();
                
                currList.add(nums[i]);
                
                helper(nums, i+1, currList, nums[i]);  // recursive call
    
                currList.remove(currList.size() - 1); // backtracking            
            }
        }
    }
    
}

