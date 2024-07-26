class Solution {
    
    // TC : O(m*n)
    // SC : O(m*n)

    // Dynamic Programming : Recursion & Memoization
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] memo = new int[m][n];
        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        
        return MPS(grid, 0, 0, m, n, memo);
    }
    
    
    private int MPS(int[][] grid, int i, int j, int m, int n, int[][] memo) {
        // Base case
        if(i == m-1 && j == n-1) {
            return memo[i][j] = grid[i][j];
        }
        
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        
        if(i == m-1) { // we can only go to right
            return memo[i][j] = grid[i][j] + MPS(grid, i, j+1, m, n, memo);
        }
        else if(j == n-1) { // we can only go down
            return memo[i][j] = grid[i][j] + MPS(grid, i+1, j, m, n, memo);
        }
        else {
            return memo[i][j] = grid[i][j] + Math.min(MPS(grid, i+1, j, m, n, memo), MPS(grid, i, j+1, m, n, memo));
        }
    }
    
}

