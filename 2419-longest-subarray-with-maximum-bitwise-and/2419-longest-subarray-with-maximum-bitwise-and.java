class Solution {
    
    // TC : O(n)
    // SC : O(1)
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

