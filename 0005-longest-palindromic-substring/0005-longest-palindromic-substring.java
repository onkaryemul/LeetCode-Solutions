class Solution {
    
    // TC : O(n^2)
    // SC : O(n^2)
    
    private int[][] memo;
    
    // Recursion + Memoization
    public String longestPalindrome(String s) {
        int n = s.length();
        
        memo = new int[n][n];
        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        
        int maxLen = 0;
        int startingIndex = 0;
        
        for(int i=0; i < n; i++) {
            for(int j=i; j < n; j++) {
                if(solve(s, i, j) && j-i+1 > maxLen) {
                    startingIndex = i;
                    maxLen = j-i+1;
                }
            }
        }
        
        return s.substring(startingIndex, startingIndex + maxLen);
    }
    
    
    private boolean solve(String s, int i, int j) {
        // Base case
        if(i >= j) {
            return true;
        }
        
        if(memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        
        if(s.charAt(i) == s.charAt(j)) {
            memo[i][j] = solve(s, i+1, j-1) ? 1 : 0;
        }
        else {
            memo[i][j] = 0;
        }
        
        return memo[i][j] == 1;
    }
    
}

