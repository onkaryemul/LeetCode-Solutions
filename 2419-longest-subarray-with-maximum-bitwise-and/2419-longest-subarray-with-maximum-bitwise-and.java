class Solution {
    
    // TC : O(n), single-pass solution
    // SC : O(1)
    
    // Simple Observation of AND property
    
    // Maximum Bitwise AND --> maximum value in the given array, since Bitwise AND of two numbers is always <= two numbers
    // ie. to find the longest length of the subarray with maximum value
     
    public int longestSubarray(int[] nums) {
        int mxm = 0;
        
        for(int i=0; i < nums.length; i++) {  // finding maximum value
            mxm = Math.max(mxm, nums[i]);
        }
        
        int cnt = 0;
        int ans = 1;
        
        for(int i=0; i < nums.length; i++) {  // finding continuous occurrences of maximum number
            if(nums[i] == mxm) {
                cnt++;
            } else {
                cnt = 0;
            }
            ans = Math.max(ans, cnt);
        }
        
        return ans;
    }
    
}

