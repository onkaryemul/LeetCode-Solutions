class Solution {
    
    // TC : O(n^3)
    // SC : O(total no. of characters in dictionary words  +  n for memoization array)
    
    // Using Recursion + Memoization
    
    // function to return the "minimum no. of characters left over" if you break up s optimally
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        
        HashSet<String> set = new HashSet<>();
        for(String word : dictionary) {
            set.add(word);
        }
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return solve(0, n, s, set, dp); // calling helper function
    }
    
    
    // helper function -> recursion + memoization 
    // Dynamic Programming (DP) --> Take - Not take
    private int solve(int i, int n, String s, HashSet<String> set, int[] dp) {
        // Base case
        if(i >= n) {
            return 0;
        }
        
        // Check if it is already computed
        if(dp[i] != -1) {
            return dp[i];
        }
        
        // Not Take --> means adding 1 extra character(left over)
        int result = 1 + solve(i+1, n, s, set, dp); // skippping the ith character
        
        // Take --> means adding 0 extra characters(left over)
        // taking substring starting from i to j which is present in set
        for(int j=i; j < n; j++) {
            String curr = s.substring(i, j+1);
            
            if(set.contains(curr)) {
                // valid substring
                result = Math.min(result, solve(j+1, n, s, set, dp));
            }
        }
        
        return dp[i] = result;
    }
    
}

