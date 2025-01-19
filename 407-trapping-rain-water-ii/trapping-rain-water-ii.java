class Solution {

    // TC : O(m*n * log(m*n))
    // SC : O(m*n)

    // Using Min-Heap (Priority Queue)

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        // Min-Heap (Priority Queue) ==> to store { height, {i, j} }
        PriorityQueue<int[]> boundaryCellspq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
          
        boolean[][] visited = new boolean[m][n];

        // Add boundary cells (left-most & right-most columns, top-most & bottom-most rows)
        for(int row = 0; row < m; row++) {
            // add left-most column (0th column)
            boundaryCellspq.offer(new int[]{heightMap[row][0], row, 0});
            visited[row][0] = true;

            // add right-most column (n-1 th column)
            boundaryCellspq.offer(new int[]{heightMap[row][n-1], row, n-1});
            visited[row][n-1] = true;
        }

        for(int col = 0; col < n; col++) {
            // add the top-most row (0th row)
            boundaryCellspq.offer(new int[]{heightMap[0][col], 0, col});
            visited[0][col] = true;

            // add the bottom-most row (m-1 th row)
            boundaryCellspq.offer(new int[]{heightMap[m-1][col], m-1, col});
            visited[m-1][col] = true;
        }

        int water = 0;

        // Directions for moving to neighbors (left, right, up, down)
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        // Process the boundary cells in the min-heap 
        while(!boundaryCellspq.isEmpty()) {
            int[] cell = boundaryCellspq.poll();

            int height = cell[0];
            int i = cell[1];
            int j = cell[2];

            // Check all 4 directions
            for(int[] dir : directions) {
                int i_ = i + dir[0];
                int j_ = j + dir[1];

                if(i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !visited[i_][j_]) {
                    water += Math.max(height - heightMap[i_][j_], 0);

                    boundaryCellspq.offer(new int[]{Math.max(height, heightMap[i_][j_]), i_, j_});

                    visited[i_][j_] = true;
                }
            }
        }

        return water;
    }

}

