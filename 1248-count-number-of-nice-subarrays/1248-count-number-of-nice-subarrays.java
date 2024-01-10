class Solution {
    
    // helper function
    private int atmostKSubarrays(int[] nums, int n, int k) {
        int ans = 0;
        
        int count = 0;
        int start = 0;
        
        for(int end=0; end<n; end++) {
            // Check if odd
            if(nums[end]%2 != 0) {
                count++;
            }
            
            while(start<=end && count > k) {
                if(nums[start++]%2 != 0) {
                    count--;
                }
            }
            
            ans += (end-start+1);
        }
        
        return ans;
    }
    
    
    // Main algorithm code    
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        
        return atmostKSubarrays(nums, n, k) - atmostKSubarrays(nums, n, k-1); // return exactly k number of subarrays which are nice subarrys
    }
    
}

