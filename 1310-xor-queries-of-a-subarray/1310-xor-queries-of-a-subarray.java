class Solution {
    
    // TC : O(n + m)
    // SC : O(n)
    
    // Using the concept of "prefixSum"
    // Using the property of XOR ->  reverse of XOR is XOR
    // whereas reverse of + is -
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        
        int[] prefixXOR = new int[n];
        prefixXOR[0] = arr[0];
        
        for(int i=1; i < n; i++) {
            prefixXOR[i] = prefixXOR[i-1] ^ arr[i];
        }
        
        int m = queries.length;
        int[] res = new int[m];
        
        for(int i=0; i < m; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            
            if(x == 0) {
                res[i] = prefixXOR[y];
            }
            else {
                res[i] = prefixXOR[y] ^ prefixXOR[x-1];
            }
        }
        
        return res;
    }
    
}

