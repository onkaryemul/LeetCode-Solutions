class Solution {
    
    // TC : O(m*n)
    // SC : O(m*n)
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0; // store the maximum length of repeated subarray
        
        int m = nums1.length;
        int n = nums2.length;
        
        int[][] dp = new int[m+1][n+1];
        
        // O(m*n)
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        
        return max;
    }
    
}

