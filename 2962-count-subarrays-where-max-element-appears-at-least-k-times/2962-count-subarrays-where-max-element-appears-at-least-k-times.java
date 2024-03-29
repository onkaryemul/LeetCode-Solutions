class Solution {
    
    // TC : O(n)
    // SC : O(n) -> for hashmap
    public long countSubarrays(int[] nums, int k) {
        // 2 pointer & sliding window approach
        long cnt = 0;
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int maxi = 0; // since 1 <= nums[i] <= 10^6
        for(int num : nums) {
            maxi = Math.max(maxi, num);
        }
        
        int i = 0, j = 0;
        
        while(j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            
            while(map.getOrDefault(maxi, 0) >= k) {
                cnt += (n-j);
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            
            j++;
        }
        
        return cnt;
    }
    
}

