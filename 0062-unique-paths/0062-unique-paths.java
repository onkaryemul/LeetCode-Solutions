class Solution {
    
    // TC : O(m*n)
    // SC : O(m*n)
    
    // Dynamic Programming: Recursion + Memoization 
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        
        return solve(0, 0, m, n, memo);
    }
    
    
    private int solve(int i, int j, int m, int n, int[][] memo) {
        // Check if is goind out-of bound
        if(i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        
        // Base case
        if(i == m-1 && j == n-1) {
            return 1;
        }
        
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        
        int right = solve(i, j+1, m, n, memo);
        int down = solve(i+1, j, m, n, memo);
        
        return memo[i][j] = right + down;
    }
    
}


/* 
// Approach-2 (using Bottom Up) - T.C : O(m*n)

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i==0 || j==0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }
        
        return grid[m-1][n-1];
    }
}

*/

