class Solution {
    
    // TC : O(N^2)
    // SC : O(N^2)
    public int minFallingPathSum(int[][] matrix) {
        int minSum = Integer.MAX_VALUE;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // O(n^2) space
        int[][] dp = new int[rows][cols];
        
        
        for(int col=0; col < cols; col++) {
            dp[0][col] = matrix[0][col];
        }
        
        // O(n^2)
        for(int row=1; row < rows; row++) {
            for(int col=0; col < cols; col++) {
                int top = dp[row-1][col];
                int topLeft = Integer.MAX_VALUE;
                int topRight = Integer.MAX_VALUE;
                
                if(col - 1 >= 0) {
                    topLeft = dp[row-1][col-1];
                }
                
                if(col + 1 < cols) {
                    topRight = dp[row-1][col+1];
                }
                
                dp[row][col] = matrix[row][col] + Math.min(Math.min(topLeft, top), topRight);
            }
        }
        
        
        for(int col=0; col < cols; col++) {
            minSum = Math.min(minSum, dp[rows-1][col]);   
        }
        
        
        return minSum;
    }
    
}


