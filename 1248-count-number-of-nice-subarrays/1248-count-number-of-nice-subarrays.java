class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    
    // Sliding Window & Two pointer Approach
    public int numberOfSubarrays(int[] nums, int k) {
        // Number of subarrays with atmost k odd numbers 
        // -
        // Number of subarrays with atmost k-1 odd numbers
        // = Number of subarrays with exactly k odd numbers
        
        return atmostKSubarrays(nums, k) - atmostKSubarrays(nums, k-1);
    }  
    
    
    private int atmostKSubarrays(int[] nums, int k) {
        int ans = 0;
        
        int count = 0;
        int start = 0;
        
        for(int end=0; end < nums.length; end++) {
            // Check if odd
            if(nums[end]%2 != 0) {
                count++;
            }
            
            while(start <= end && count > k) { 
                if(nums[start++]%2 != 0) {
                    count--;
                }
            }
            
            ans += (end - start + 1); // add window size 
        }
        
        return ans;
    }
    
}

