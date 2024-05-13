class Solution {
    
    //Approach (Without Modifying the input)
    //T.C : O(m*n)
    //S.C : O(1)
    
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // MSB -> 2^(n-1)
        int score = (int) Math.pow(2, n - 1) * m;

        for (int j = 1; j < n; j++) {
            int countSameBits = 0; // count of 1s
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == grid[i][0]) {
                    countSameBits++;
                }
            }

            int countOnes = countSameBits;
            int countZeros = m - countOnes;

            int ones = Math.max(countOnes, countZeros);

            score += (int) Math.pow(2, n - j - 1) * ones;
        }

        return score;
    }
    
}


