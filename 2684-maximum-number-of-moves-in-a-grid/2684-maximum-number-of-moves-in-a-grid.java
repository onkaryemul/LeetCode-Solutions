class Solution {
    
    // TC : O(m*n)
    // SC : O(m*n)
    
    // Using Dynamic Programming(DP)
    // Recursion + Memoization
    
    private int m, n;

    // function to return the maximum no. of moves that you can perform
    public int maxMoves(int[][] grid) {
        m = grid.length; // no. of rows
        n = grid[0].length; // no. of columns
        
        int[][] dp = new int[m][n];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        int max = 0; 
        // For each row, move from 0th column (1st column)
        for(int row = 0; row < m; row++) {
            max = Math.max(max, getMax(row, 0, grid, dp));
        }
        
        return max;
    }
    
    // Helper function
    private int getMax(int i, int j, int[][] grid, int[][] dp) {
        // If we're out of bounds, return 0
        if (i < 0 || i >= m || j >= n) {
            return 0;
        }

        // If we have already computed the value, return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int max = 0;
        
        // Check diagonally upwards
        if (i - 1 >= 0 && j + 1 < n && grid[i - 1][j + 1] > grid[i][j]) {
            max = Math.max(max, 1 + getMax(i - 1, j + 1, grid, dp));
        }
        
        // Check to the right
        if (j + 1 < n && grid[i][j + 1] > grid[i][j]) {
            max = Math.max(max, 1 + getMax(i, j + 1, grid, dp));
        }
        
        // Check diagonally downwards
        if (i + 1 < m && j + 1 < n && grid[i + 1][j + 1] > grid[i][j]) {
            max = Math.max(max, 1 + getMax(i + 1, j + 1, grid, dp));
        }
        
        // Store the computed value
        return dp[i][j] = max;
    }
    
}

