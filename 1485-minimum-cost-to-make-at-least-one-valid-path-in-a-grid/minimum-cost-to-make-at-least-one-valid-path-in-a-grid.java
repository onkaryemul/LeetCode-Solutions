class Solution {

    // TC : O((m*n) * log(m*n))
    // SC : O(m*n)

    // Using Dijkstra's Algorithm

    private final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Min-Heap (Priority Queue)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        int[][] result = new int[m][n];
        // result[i][j] = Minimum cost to reach (i, j) from source (0, 0)

        for(int[] arr : result) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        result[0][0] = 0; // 0 cost to reach (0, 0) from source (0, 0)

        // apply Dijkstra's algorithm 
        pq.add(new int[]{0, 0, 0}); // 0 = cost, next (0, 0) => grid cell coordinates

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int currCost = curr[0];
            int i = curr[1];
            int j = curr[2];

            if(result[i][j] < currCost) {
                continue;
            }
            
            for(int dir_i = 0; dir_i < 4; dir_i++) {
                int i_ = i + dir[dir_i][0];
                int j_ = j + dir[dir_i][1];

                if(i_ >= 0 && j_ >= 0 && i_ < m && j_ < n) {
                    int gridDir = grid[i][j];

                    int dirCost = ((gridDir-1 != dir_i) ? 1 : 0);

                    int newCost = currCost + dirCost;

                    if(newCost < result[i_][j_]) {
                        result[i_][j_] = newCost;
                        pq.add(new int[]{newCost, i_, j_});
                    }
                }
            }
        }

        return result[m-1][n-1]; // minimum cost to reach (m-1, n-1)
    }

}

