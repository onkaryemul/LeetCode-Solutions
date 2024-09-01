class Solution {
    
    // TC : O(m*n)
    // SC : O(1)
    
    /* 
        1D -> 2D :  row = 1d-index / COLS
                    col = 1d-index % COLS
                    
        2D -> 1D :  1d-index = row * COLS + col
    */
    
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Base case
        if(m*n != original.length) {
            return new int[][]{};
        }
        
        int[][] res = new int[m][n];
        
        for(int r=0; r < m; r++) {
            for(int c=0; c < n; c++) {
                res[r][c] = original[r * n + c];
            }
        }
        
        return res;
    }
    
}

