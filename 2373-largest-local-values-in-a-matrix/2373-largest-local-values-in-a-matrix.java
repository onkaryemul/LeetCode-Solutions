class Solution {
    
    // TC: O(n^2)
    
    public int[][] largestLocal(int[][] grid) {
        int[][] maxLocal = new int[grid.length-2][grid.length-2];
        
        for(int i=0; i < maxLocal.length; i++) {
            for(int j=0; j < maxLocal[0].length; j++) {
                maxLocal[i][j] = getMaxValueAcross3X3Grid(grid, i, j);
            }
        }
        
        return maxLocal;
    }
    
    
    private int getMaxValueAcross3X3Grid(int[][] grid, int row, int col) {
        int max = Integer.MIN_VALUE;
        
        for(int i=row; i < row+3; i++) {
            for(int j=col; j < col+3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        
        return max;
    }
    
}

