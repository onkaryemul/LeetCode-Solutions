class Solution {
    // Longest Increasing Subsequence
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        
        for(int i=1; i<len; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        
        int longest = 0;
        
        for(int num : dp) {
            longest = Math.max(longest, num);
        }
        
        return longest;
    }
    
}
