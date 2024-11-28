class Solution {
    
    //T.C : O(m*n log(m*n))
    //S.C : O(m*n)
    
    //Approach (Using Dijkstra's Algorothm - Assuming obstacle with edge weight 1 and empty with 0)

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m][n];
        
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        result[0][0] = 0;

        // Min-heap to store {obstacleCount, {i, j}}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});  // {obstacleCount, i, j}

        // Directions for moving up, down, left, and right
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            
            int obstacleCount = current[0];
            
            int i = current[1];
            int j = current[2];

            for (int[] dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];

                // Check if (x, y) is within bounds
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int wt = (grid[x][y] == 1) ? 1 : 0;

                    if (obstacleCount + wt < result[x][y]) {
                        result[x][y] = obstacleCount + wt;
                        pq.offer(new int[]{obstacleCount + wt, x, y});
                    }
                }
            }
        }

        return result[m - 1][n - 1];
    }
    
}

