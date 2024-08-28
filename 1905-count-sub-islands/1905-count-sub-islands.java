class Solution {
    
    //T.C : O(m*n)
    //S.C : O(m*n) //Queue

    // Using BFS

    private final int[][] directions = {
                                          {1, 0},  // down
                                          {-1, 0}, // up
                                          {0, 1},  // right
                                          {0, -1}  // left
                                       }; 

    
    // function to return no. of SubIslands in grid2 
    // i.e. islands in grid2 such that an island in grid1 contains all the cells that make up this land
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        
        int m = grid2.length; // rows
        int n = grid2[0].length; // cols

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && checkSubIsland(grid1, grid2, i, j)) { 
                    // Found an island
                    subIslands++;
                }
            }
        }

        return subIslands;
    }
    
    
    // BFS
    private boolean checkSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;

        boolean result = true;

        // Queue to perform BFS
        Queue<int[]> queue = new LinkedList<>(); 
        queue.offer(new int[]{i, j});
        
        grid2[i][j] = -1; // mark visited

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (grid1[x][y] != 1) { // grid1 must have 1 at the same coordinate
                result = false;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid2[newX][newY] == 1) {
                    grid2[newX][newY] = -1; // mark visited
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return result;
    }

    
}

