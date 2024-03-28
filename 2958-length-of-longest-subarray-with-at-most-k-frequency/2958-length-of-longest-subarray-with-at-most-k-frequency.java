class Solution {
    
    // TC : O(n)
    // SC : O(1)
    public int maxSubarrayLength(int[] nums, int k) {
        // 2 pointer approach
        int maxi = 1; // since k is minimum 1, so atmost we can take 1 element as subarray
        
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        
        int left = 0;
        int right = 1;
        
        for(left=0, right=1; right < nums.length; right++) {
            if(map.getOrDefault(nums[right], 0) + 1 <= k) {
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                maxi = Math.max(maxi, right - left + 1);
            }
            else {
                while(map.getOrDefault(nums[right], 0) + 1 > k) {
                    map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                    left++;
                }
                
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            }
        }
        
        return maxi;
    }
    
}

