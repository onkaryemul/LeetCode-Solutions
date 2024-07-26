class Solution {
    
    // TC : O(m*n)
    // SC : O(m*n)
    
    // Using map and list
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // key : i+j,  Value : List of values at (i, j)
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        // Fill the map using [i+j]
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(!map.containsKey(i+j)) {
                    map.put(i+j, new ArrayList<Integer>());
                }
                map.get(i+j).add(mat[i][j]);
            }
        }
        
        boolean flip = true;
        
        // Sum of (i+j) ranges from (0, 0) ie. 0 to (m-1, n-1) ie. m-n-2 
        for(int k=0; k < m+n-1; k++) {
            List<Integer> list = map.get(k);
            
            if(flip) {
                Collections.reverse(list);
            }
            
            result.addAll(list);
            
            flip = !flip;
        }
        
        // Convert List<Integer> to int[]
        int[] resArray = new int[result.size()];
        for(int i=0; i < resArray.length; i++) {
            resArray[i] = result.get(i);
        }
        
        return resArray;
    }
    
}

