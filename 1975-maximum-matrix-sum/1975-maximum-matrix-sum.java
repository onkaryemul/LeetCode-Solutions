class Solution {
    
    // TC : O(n*n)
    // SC : O(1)
    
    // Using Simple Observation
    
    // Check count of negatives in the given matrix
    // if even count of -ves ==> then return the computed absolute sum
    // if odd count of -ves ==> then return the computed absolute sum - 2*(minimum absolute number)
    
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length; // n*n matrix
        
        long sum = 0;
        
        int countNegatives = 0;
        int smallestAbsoluteValue = Integer.MAX_VALUE;
        
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                sum += Math.abs(matrix[i][j]);
                
                if(matrix[i][j] < 0) {
                    countNegatives++;
                }
                
                smallestAbsoluteValue = Math.min(smallestAbsoluteValue, Math.abs(matrix[i][j]));
            }
        }
        
        // If even no.of negatives => then return computed absolute sum
        if(countNegatives % 2 == 0) {
            return sum;
        }
        
        // if odd no. of -negatives, then return sum - 2*smallestAbsoluteValue
        return sum - 2L * smallestAbsoluteValue;
    }
    
}

