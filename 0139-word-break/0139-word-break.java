class Solution {

    // helper function -> recursion & DP
    private boolean solve(int start, int end, String s, Set<String> wd, int[][] dp) {
        // Memoization
        if(dp[start][end] != -1) {
            return dp[start][end] == 1 ? true : false;
        }
        
        // Base case
        if(end == s.length()-1) {
            if(wd.contains(s.substring(start, end+1))) {
                return true;
            }
            return false;
        }
        
        
        if(wd.contains(s.substring(start, end+1))) {
            if(solve(end+1, end+1, s, wd, dp)) {
                dp[start][end] = 1;
                return true;
            }
        }
        
        
        dp[start][end] = solve(start, end+1, s, wd, dp) ? 1 : 0;
        
        return dp[start][end] == 1 ? true : false;
    }
    
    
    // Main algorithm code
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        
        int[][] dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, s, new HashSet<>(wordDict), dp);
    }
    
}

