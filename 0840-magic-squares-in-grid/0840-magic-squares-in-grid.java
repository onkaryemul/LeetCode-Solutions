class Solution {
    
    // TC : O(rows * cols)
    // SC : O(1)
    
    // Using maths and simple simulation
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length; // no. of rows
        int cols = grid[0].length; // no. of columns
        
        int cnt = 0; // store no. of 3*3 contiguous magic square subgrids
        
        // 3*3 Magic square grid -> Distinct numbers from 1 to 9
        // Each row, col, and both diagonals have the same sum => 15
        
        for(int r=0; r < rows-2; r++) {
            for(int c=0; c < cols-2; c++) {
                // Check if we have a 3*3 magical square grid starting from (r, c)
                if(isValidSquare(grid, r, c)) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    
    private boolean isValidSquare(int[][] grid, int x, int y) {
        // Check if mid pf 3*3 matrix is 5 or not  --> Since 5 can form 15 in 4 ways
        // If it is not 5, then return false
        if(grid[x+1][y+1] != 5) {
            return false;
        }
        
        int sum = 15; // sum of 1..9 = 45 --> 45/3 = 15 --> required sum of each row, each column, and both the diagonals
        boolean[] isVisited = new boolean[10]; 
        
        // Check rowwise sum 
        for(int r=0; r < 3; r++) {
            int rowSum = 0;
            
            for(int c=0; c < 3; c++) {
                int val = grid[x+r][y+c];
                
                // Check if current val is out of range and if it is visited already  
                if(val < 1 || val > 9 || isVisited[val]) {
                    return false;
                }
                
                // Mark the current val as visited
                isVisited[val] = true;
                
                rowSum += val;
            }
            
            if(rowSum != sum) {
                return false;
            }
        }
        
        // Check column wise sum
        for(int c=0; c < 3; c++) {
            int colSum = 0;
            
            for(int r=0; r < 3; r++) {
                colSum += grid[x+r][y+c];
            }
            
            if(colSum != sum) {
                return false;
            }
        }
        
        // Calculate the sum of both diagonals
        int diag1 = grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2];
        int diag2 = grid[x][y+2] + grid[x+1][y+1] + grid[x+2][y];
        
        return diag1 == sum && diag2 == sum;
    }
    
}

