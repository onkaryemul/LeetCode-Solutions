class Solution {
    
    // TC : O(m*n)  i.e. O(ROWS * COLS)
    // SC : O(n)  i.e  O(COLS)
    
    // Dynamic Programming -> Bottom up approach
    public long maxPoints(int[][] points) {
        int ROWS = points.length; // m -> no. of rows
        int COLS = points[0].length; // n -> no. of columns
        
        long[] prevRow = new long[COLS];
        for(int i=0; i < COLS; i++) {
            prevRow[i] = points[0][i];
        }
        
        for(int i=1; i < ROWS; i++) {
            long[] currRow = new long[COLS];
            
            long left = 0;
            for(int j=0; j < COLS; j++) {
                left = Math.max(left-1, prevRow[j]);
                currRow[j] = left + points[i][j];
            }
            
            long right = 0;
            for(int j=COLS-1; j >= 0; j--) {
                right = Math.max(right-1, prevRow[j]);
                currRow[j] = Math.max(currRow[j], right + points[i][j]);
            }
            
            prevRow = currRow;
        }
        
        // maximum no. of points that we can achieve
        long maxPoints = 0;
        for(int j=0; j < COLS; j++) {
            maxPoints = Math.max(maxPoints, prevRow[j]);
        }
        
        return maxPoints;
    }
    
}

