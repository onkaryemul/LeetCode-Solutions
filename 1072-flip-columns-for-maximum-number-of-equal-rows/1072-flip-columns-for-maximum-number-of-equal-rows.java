class Solution {
    
    // TC : O(m*n)
    // SC : O(m+n)
    
    // Using Greedy approach 
    
    // function to return the maximum no. of rows that have all values equal after some number of flips
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // key : Group (row + flipped_row)
        // value : no. of members in that group
        Map<String, Integer> map = new HashMap<>();
        
        for(int[] row : matrix) {
            StringBuilder values = new StringBuilder();
            StringBuilder flipped = new StringBuilder();
            
            for(int r : row) {
                // create a string representation of a row
                values.append(r);
                
                // create a string representation of a flipped row
                flipped.append(1-r);
            }
            
            String vs = values.toString();
            String fs = flipped.toString();
            
            // put string representation of a row with count = prev + 1
            map.put(vs, map.getOrDefault(vs, 0) + 1);
            
            // put string representation of a flipped row with count = prev + 1
            map.put(fs, map.getOrDefault(fs, 0) + 1);
        }
        
        int ans = 0;
        
        // Get the max value in map
        // it represents the max no. of rows which match or totally different i.e. flipped version
        for(int v : map.values()) {
            ans = Math.max(ans, v);
        }
        
        return ans;
    }
    
}

