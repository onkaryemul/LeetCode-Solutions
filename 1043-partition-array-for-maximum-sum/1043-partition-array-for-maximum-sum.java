class Solution {
    
    // Bottom-up Approach: Dynamic Programming
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        
        int[] dp = new int[len + 1]; // SC : O(n)
        Arrays.fill(dp, 0);
        
        // TC : O(n*k)
        for(int start = len-1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(len, start + k);
            
            for(int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                dp[start] = Math.max(dp[start], currMax * (i - start + 1) + dp[i+1]);
            }
        }
        
        return dp[0];
    }
    
}


