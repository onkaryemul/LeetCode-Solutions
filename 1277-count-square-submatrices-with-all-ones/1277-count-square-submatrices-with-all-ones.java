class Solution {
    
    // TC : O(m*n)
    // SC : O(m*n) + recursive stack space
     
    // Using Dynamic Programming(DP)
    // Using Recursion + Memoization
    
    private int m, n;

    // function to find & return the no. of square submatrices having all ones in the given matrix    
    public int countSquares(int[][] matrix) {
        m = matrix.length; // no. of rows
        n = matrix[0].length; // no. of columns
        
        int cnt = 0; // "total no. of square submatrices having all ones" in the given matrix
        
        int[][] dp = new int[m][n];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1); // Initialize the memoization table with -1
        }
        
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                // solve(i, j, matrix, dp) => will give no. of square submatrices starting at (i, j)
                cnt += solve(i, j, matrix, dp);
            }
        }
        
        return cnt;
    }
    
    
    // Helper function
    // function to find & return no. of square submatrices starting at (i, j)
    private int solve(int i, int j, int[][] matrix, int[][] dp) {
        // Base case:
        // If out-of-bound, then return 0
        if(i >= m || j >= n) { // since we are only checking in right, down, diagonal direction
            return 0;
        }
        
        // If the matrix[i][j] = 0, then return 0
        if(matrix[i][j] == 0) {
            return 0;
        }
        
        // Check if results for current (i, j) are already precomputed, then return it precomputed results
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        // Right
        int right = solve(i, j+1, matrix, dp);
        
        // Diagonal 
        int diagonal = solve(i+1, j+1, matrix, dp);
        
        // Down
        int down = solve(i+1, j, matrix, dp);
        
        return dp[i][j] = 1 + Math.min(right, Math.min(diagonal, down));
    }
    
}


/* 
//Approach - 2 (simple Bottom Up - Same as Maximal Square (Leetcode-221)
//T.C : O(m*n)
//S.C : O(m*n)

    public int countSquares(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 1) {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                }
                result += dp[i][j];
            }
        }

        return result;
    }
*/

