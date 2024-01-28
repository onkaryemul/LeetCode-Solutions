class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // key: prefixSum
        // Value: frequency
        
        map.put(0, 1);
        
        int cnt = 0; // stores count of subarrays whose sum equals k
        int currSum = 0;
        
        for(int i=0; i<nums.length; i++) {
            currSum += nums[i];
            
            if(map.containsKey(currSum - k)) {
                cnt += map.get(currSum - k);   
            }
            
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        
        return cnt;
    }
    
}

