class Solution {
    
    // TC : O(m*n + G*(m+n)), where G = size of the guards[]
    // SC : O(m*n), considering the size of the grid[][] we took
    
    // Using Simple Simulation
    
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        // Mark guard positions 
        for(int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            grid[i][j] = 2; // guard
        }
        
        // Mark wall positions
        for(int[] wall : walls) {
            int i = wall[0];
            int j = wall[1];
            grid[i][j] = 3; // wall
        }
        
        // Mark cells guarded by each guard
        // TC : O(G*(m+n))
        for(int[] guard : guards) { // G
            int i = guard[0];
            int j = guard[1];
            markGuarded(i, j, grid); // (m + n) => max no. of cells visited by guard in the ith row and jth col 
        }
        
        // Count unguarded cells
        int count = 0;
        
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(grid[i][j] == 0) { // unguarded
                    count++;
                }
            }
        }
        
        return count;
    }
    
    
    // Helper function => to mark cells guarded by guard at ith row and jth col
    // TC : O(m+n) ~ O(rows + cols)
    private void markGuarded(int row, int col, int[][] grid) {
        // Up
        for(int i=row-1; i >= 0; i--) {
            if(grid[i][col] == 2 || grid[i][col] == 3) {
                break;
            }
            grid[i][col] = 1; // mark as guarded
        }
        
        // Down
        for(int i=row+1; i < grid.length; i++) {
            if(grid[i][col] == 2 || grid[i][col] == 3) {
                break;
            }
            grid[i][col] = 1; // mark as guarded
        }
        
        // Left
        for(int j=col-1; j >= 0; j--) {
            if(grid[row][j] == 2 || grid[row][j] == 3) {
                break;
            }
            grid[row][j] = 1; // marking as guarded
        }
        
        // Right 
        for(int j=col+1; j < grid[0].length; j++) {
            if(grid[row][j] == 2 || grid[row][j] == 3) {
                break;
            }
            grid[row][j] = 1; // marking as guarded
        }
    }
    
}

