class Solution {
    
    // TC : O(n*n)
    // SC : O(n*n)
    public int minFallingPathSum(int[][] grid) {
        int minSum = Integer.MAX_VALUE;
        
        int n = grid.length;
        
        // Initialize a 2D DP array to store the minimum falling path sum
        int[][] dp = new int[n][n];
        
        // Fill the first row of the DP array with values from the grid
        for(int col=0; col < n; col++) {
            dp[0][col] = grid[0][col];
        }
        
        // Iterate through the grid starting from the second row
        for(int row=1; row < n; row++) {
            // Iterate through each column in the current row
            for(int col=0; col < n; col++) {
                // Find the minimum value from the previous row that doesn't share the same column
                int minPrev = Integer.MAX_VALUE;
                for(int k=0; k < n; k++) {
                    if(k != col) {
                        minPrev = Math.min(minPrev, dp[row-1][k]);
                    }
                }
                
                // Update the current cell with the minimum falling path sum
                dp[row][col] = grid[row][col] + minPrev;
            }
        }
        
        // Find the minimum falling path sum in the last row
        for(int col=0; col < n; col++) {
            minSum = Math.min(minSum, dp[n-1][col]);
        }
        
        return minSum;
    }
    
}

