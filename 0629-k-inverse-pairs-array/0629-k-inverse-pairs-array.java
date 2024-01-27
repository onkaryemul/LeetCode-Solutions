class Solution {
    
    int mod = 1000000007;
    
    // Bottom Up Approach: Dynamic Programming
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=k; j++) {
                if(j==0) {
                    dp[i][j] = 1;
                }
                else {
                    for(int p=0; p<= Math.min(j, i-1); p++) {
                        dp[i][j] = (dp[i][j] + dp[i-1][j-p]) % mod;
                    }
                }
            }
        }
        
        return dp[n][k];
    }
    
}