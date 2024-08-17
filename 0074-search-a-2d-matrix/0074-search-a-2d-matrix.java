class Solution {
    
    // TC : O(log(m*n))
    // SC : O(1)
    
    // Using "Binary Search"
    public boolean searchMatrix(int[][] matrix, int target) {
        // Edge cases
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        
        int m = matrix.length; // no. of rows
        int n = matrix[0].length; // no. of columns
        
        // Total no. of elements in 2D matrix of size m*n --->  m*n
        // Using imaginary index of low & high
        int low = 0;
        int high = (m*n)-1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            // getting actual (row, col) indices from imaginary index mid
            // row = mid/n
            // col = mid%n
            if(matrix[mid/n][mid%n] == target) {
                return true;
            }
            else if(matrix[mid/n][mid%n] < target) {
                low = mid + 1; // eliminate the left half & move towards right
            }
            else { // matrix[mid/n][mid%n] > target
                high = mid - 1; // eliminate the right half & move towards left
            }
            
        }
        
        return false;
    }
    
}

