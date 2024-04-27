class Solution {
    
    // Dynamic Programming --> Memoization
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        int ptr = 0; // tracks pointer on ring
        int index = 0; // tracks pointer on key
        
        return solve(ring, key, n, m, ptr, index, dp);
    }
    
    
    // Memoization
    private int solve(String ring, String key, int n, int m, int ptr, int index, int[][] dp) {
        // Base case
        if(index >= m) {
            return 0;
        }
        
        if(dp[ptr][index] != -1) {
            return dp[ptr][index];
        }
        
        // Choice
        int steps = Integer.MAX_VALUE;
        for(int i=0; i < n; i++) {
            if(ring.charAt(i) == key.charAt(index)) {
                steps = Math.min(steps, 
                                 Math.min(Math.abs(i-ptr), n-Math.abs(i-ptr)) 
                                    + 1  
                                    + solve(ring, key, n, m, i, index+1, dp));
            }
        }
        
        
        return dp[ptr][index] = steps;
    }
    
    
}

