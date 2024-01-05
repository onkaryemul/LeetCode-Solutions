class Solution {
    
    int mod = 1000000007;
    
    // helper function -> recursive and memoization function
    private int helper(int source, int destination, int curr, int k, int[][] dp) {
        // Base case
        if(k==0) {
            if(curr == destination) {
                return 1;
            }
            return 0;
        }
        
        // Memoization 
        if(dp[curr+1001][k] != -1) {
            return dp[curr+1001][k];
        }
        
        // Move right 
        int rightMove = helper(source, destination, curr+1, k-1, dp)%mod;
        // Move left
        int leftMove = helper(source, destination, curr-1, k-1, dp)%mod;
        
        return dp[curr+1001][k] = (rightMove + leftMove)%mod;
    }
    
    
    // Main algorithm code
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3002][1001];
        
        for(int[] item : dp) {
            Arrays.fill(item, -1);
        }
        
        return helper(startPos, endPos, startPos, k, dp);
    }
    
}

