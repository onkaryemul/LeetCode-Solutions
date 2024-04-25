class Solution {
    
    // Variant of LIS(Longest Increasing Subsequence)
    
    // TC : O(n*26) ~ O(n)
    // SC : O(26) ~ O(1)
    public int longestIdealString(String s, int k) {
        int n = s.length();
        
        int[] dp = new int[26];
        Arrays.fill(dp, 0);
        
        int ans = 0;
        
        for(int i=0; i < n; i++) {
            int ele = s.charAt(i) - 'a';
            
            // left limit
            for(int j=ele; j>=0 && j>=ele-k; j--) {
                if(j == ele && dp[j]==0) {
                    dp[j] = 1;
                    ans = Math.max(ans, dp[j]);
                    continue;
                }
                
                dp[ele] = Math.max(dp[ele], dp[j]+1);
            }
            
            // right limit
            for(int j=ele+1; j<26 && j<=ele+k; j++) {
                dp[ele] = Math.max(dp[ele], dp[j]+1);
            }
            
            ans = Math.max(ans, dp[ele]);
        }
        
        return ans;
    }

}

