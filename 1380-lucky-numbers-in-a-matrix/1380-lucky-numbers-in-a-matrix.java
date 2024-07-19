class Solution {
    
    // TC : O(m*n)
    // SC : O(1)
    
    // Only one Lucky number is possible - Find it greedily
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns
        
        int rMinMax = Integer.MIN_VALUE;
        for(int row=0; row < m; row++) {
            int rMin = Integer.MAX_VALUE;
            
            for(int col=0; col < n; col++) {
                rMin = Math.min(rMin, matrix[row][col]);
            }
            
            rMinMax = Math.max(rMinMax, rMin);
        }
        
        int cMaxMin = Integer.MAX_VALUE;
        for(int col=0; col < n; col++) {
            int cMax = Integer.MIN_VALUE;
            
            for(int row=0; row < m; row++) {
                cMax = Math.max(cMax, matrix[row][col]);
            }
            
            cMaxMin = Math.min(cMaxMin, cMax);
        }
        
        List<Integer> result = new ArrayList<>();
        if(rMinMax == cMaxMin) {
            result.add(rMinMax); // {cMaxMin}
        }
        
        return result;
    }
    
}

