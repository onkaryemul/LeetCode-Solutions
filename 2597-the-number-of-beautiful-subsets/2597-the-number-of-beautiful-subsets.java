class Solution {
    
    // T.C : O(2^n)
    // S.C : O(n)

    private int resultCnt;
    private int K;
    
    // Simple backtracking just like subsets
    public int beautifulSubsets(int[] nums, int k) {
        resultCnt = 0;
        
        K = k;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        dfs(0, nums, map);
        
        return resultCnt - 1; // - 1 because we don't want to count empty subset in the result
    }
    
    
    private void dfs(int idx, int[] nums, Map<Integer, Integer> map) {
        // Base case
        if(idx == nums.length) {
            resultCnt++;
            return;
        }
        
        // not take
        dfs(idx+1, nums, map);
        
        // checking if we can take it or not
        if(!map.containsKey(nums[idx]-K) && !map.containsKey(nums[idx]+K)) {
            // take it
            map.put(nums[idx], map.getOrDefault(nums[idx], 0) + 1); // do
            
            dfs(idx+1, nums, map); // explore
            
            map.put(nums[idx], map.get(nums[idx])-1); // undo
            
            // Remove the key if its count drops to 0 
            if(map.get(nums[idx]) == 0) {
                map.remove(nums[idx]);
            }
        }
    }
    
}

