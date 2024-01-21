class Solution {
    
    // Bottom Up - Dynamic Programming
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i=2; i <= nums.length; i++) {
            int skipped = dp[i-1];
            int robbed = nums[i-1] + dp[i-2];
            dp[i] = Math.max(skipped, robbed);
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    
}

