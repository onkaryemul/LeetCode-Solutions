class Solution {
    
    // TC : O(m*n)
    // SC : O(m*n), for storing spiral order of matrix
    
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns
        
        // Base case
        if(m == 0 || n == 0) {
            return new ArrayList<>(){};
        }
        
        List<Integer> result = new ArrayList<>();
        
        int top = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;
        
        int dir = 0;
        // dir = 0 : Left to right (constant = top)
        // dir = 1 : Top to down (constant = right)
        // dir = 2 : Right to left (constant = down)
        // dir = 3 : Down to top (constant = left)
        
        while(top <= down && left <= right) {
            if(dir == 0) { // left to right, Row(top) = constant
                for(int i=left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            }
            
            if(dir == 1) { // top to down, column(right) = constant
                for(int i=top; i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }
            
            if(dir == 2) { // right to left, Row(down) = constant
                for(int i=right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            }
            
            if(dir == 3) { // down to top, column(left) = constant
                for(int i=down; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
            
            dir = (dir + 1)%4;
        }
        
        return result;
    }
    
}

