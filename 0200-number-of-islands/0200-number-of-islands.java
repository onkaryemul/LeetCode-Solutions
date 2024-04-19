class Solution {
    
    // TC : O(m*n)
    // SC : O(m*n)
    public int numIslands(char[][] grid) {
        int cnt = 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(grid[i][j] == '1') {
                    cnt++;
                    solve(grid, i, j);
                }
            }
        }
        
        return cnt;
    }
    
    
    private void solve(char[][] grid, int i, int j) {
        // Base case
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '0') {
            return;
        } 
        
        grid[i][j] = '0';
        
        // up
        solve(grid, i-1, j);
        
        // right
        solve(grid, i, j+1);
        
        // down
        solve(grid, i+1, j);
        
        // left
        solve(grid, i, j-1);
    }
    
}

