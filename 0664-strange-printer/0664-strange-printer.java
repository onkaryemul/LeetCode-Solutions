class Solution {
    
    // TC : O(n^3)
    // SC : O(n^2)
    
    private int n;
    private int[][] dp;
    
    // Dynamic Programming -->  Recursion + Memoization
    public int strangePrinter(String s) {
        n = s.length();
        
        dp = new int[n+1][n+1];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        return solve(0, n-1, s);
    }
    
    
    // function to find the minimum no. of turns the printer needed to print string s
    private int solve(int l, int r, String s) {
        // Base case
        if(l == r) {
            return 1;
        }
        else if (l > r) {
            return 0;
        }
        
        if(dp[l][r] != -1) {
            return dp[l][r];
        }
        
        int i = l + 1;
        while(i <= r && s.charAt(i) == s.charAt(l)) {
            i++;
        }
        
        if(i == r+1) {
            return 1;
        }
        
        int normal = 1 + solve(i, r, s);
        
        int aage_ka = Integer.MAX_VALUE;
        for(int j=i; j <= r; j++) {
            if(s.charAt(j) == s.charAt(l)) { // greedy
                int x = solve(i, j-1, s) + solve(j, r, s);
                aage_ka = Math.min(aage_ka, x);
            }
        }
        
        return dp[l][r] = Math.min(normal, aage_ka);
    }
    
}


