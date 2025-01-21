class Solution {

    // TC : O(n), n = no. of columns in the grid
    // SC : O(1)

    // Based on Game strategy => since both robots play optimally

    // Using cumulative sum (Prefix sum) technique

    public long gridGame(int[][] grid) {
        int n = grid[0].length; // no. of columns

        long firstRowRemainingSum = 0; // collected by robot 2
        
        // Iterate through grid[0] ie. 0th row & calculate summation of row 0 points
        for(int col = 0; col < n; col++) {
            firstRowRemainingSum += grid[0][col];
        }

        long secondRowRemainingSum = 0;

        long minimizedRobot2Sum = Long.MAX_VALUE;

        for(int Robot1Col = 0; Robot1Col < n; Robot1Col++) {
            // Robot1 took this strategy
            firstRowRemainingSum -= grid[0][Robot1Col];

            // Robot2 will try to do best after Robot1 has taken the above strategy
            long bestOfRobot2 = Math.max(firstRowRemainingSum, secondRowRemainingSum);
            
            minimizedRobot2Sum = Math.min(minimizedRobot2Sum, bestOfRobot2);

            secondRowRemainingSum += grid[1][Robot1Col];
        }

        return minimizedRobot2Sum;
    }

}

