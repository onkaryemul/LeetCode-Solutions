class Solution {
    
    // TC : O((m*n)^2)
    // SC : O(m*n)
    
    
    private int m;
    private int n;
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    
    // Using "Number of Islands" concept
    public int minDays(int[][] grid) {
        m = grid.length; // no. of rows in grid matrix
        n = grid[0].length; // no. of columns in grid matrix
        
        int islands = numberOfIslandsDFS(grid);
        
        // Check if Grid already disconnected 
        // When there are 2 islands in the grid, then it is disconnected
        // or If no islands are there in the grid, then also it is disconnected
        if(islands > 1 || islands == 0) {
            return 0;
        }
        else {
            // Check for 1 move
            for(int i=0; i < m; i++) {
                for(int j=0; j < n; j++) {
                    if(grid[i][j] == 1) {
                        grid[i][j] = 0; // mark visited
                        
                        islands = numberOfIslandsDFS(grid);
                        
                        grid[i][j] = 1; // unmark visited
                        if(islands > 1 || islands == 0) {
                            return 1;
                        }
                    }
                }
            }
        }
        
        return 2; // It is always possible to break an island with 2 moves
    }
    

    // Function to get no. of islands 
    private int numberOfIslandsDFS(int[][] grid) {
        boolean[][] visited = new boolean[m][n];
        int islands = 0;
        
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                // Check if grid[i][j] is not visited and it value is 1 (land cell)
                if(!visited[i][j] && grid[i][j] == 1) { // then perform DFS starting from (i, j)
                    DFS(grid, i, j, visited);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
      
    // Depth first Search(DFS)
    private void DFS(int[][] grid, int i, int j, boolean[][] visited) {
        // Base case: Check if it is going out-of-bound or is already visited or is a water cell
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        
        visited[i][j] = true; // mark it visited
        
        for(int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            
            DFS(grid, new_i, new_j, visited);
        }
    }
    
}

