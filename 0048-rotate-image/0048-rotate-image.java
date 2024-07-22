class Solution {
    
    // TC : O(n^2)
    // SC : O(1)
    
    // In-place rotation of matrix by 90 degrees
    public void rotate(int[][] matrix) {
        int n = matrix.length; // n*n matrix
        
        // 1. Transpose of matrix
        for(int i=0; i < n; i++) {
            for(int j=i+1; j < n; j++) {
                // swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // 2. Reverse each row of matrix
        for(int i=0; i < n; i++) {
            int j = 0, k = n-1;
            
            while(j < k) {
                // swap matrix[i][j] and matrix[i][k]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                
                j++;
                k--;
            }
        }
    }
    
}

