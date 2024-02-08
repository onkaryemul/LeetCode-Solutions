// Bottom-up Approach -> Dynamic Programming (DP)
class Solution {
    
    // TC : O(n * sqrt(n))
    // SC : O(n)
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++) {
            dp[i] = i;
            
            for(int j = 1; j * j <= i; j++) {
                int curr = 1 + dp[i - j * j];
                dp[i] = Math.min(dp[i], curr);
            }
        }
        
        return dp[n];
    }
    
}


