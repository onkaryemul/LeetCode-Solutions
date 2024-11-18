class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Range Sum Query approach
    // R(i, j) = PrefixSum(j) - PrefixSum(i)  ==> will give sum of elements between i and j
    
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        
        if(k == 0) {
            return new int[n]; // initialized with 0
        }
        
        // Build the prefix array with duplicated code values
        int[] prefix = new int[2*n];
        
        prefix[0] = code[0];
        
        for(int i=1; i < 2*n; i++) {
            prefix[i] = prefix[i-1] + code[i % n];
        }
        
        int[] res = new int[n];
        
        calculateSum(res, k, prefix);
        
        return res;
    }
    
    
    // Helper function
    private void calculateSum(int[] res, int k, int[] prefix) {
        int n = res.length;
        
        if(k > 0) {
            // Right sum
            for(int i=0; i < n; i++) {
                res[i] = prefix[i + k] - prefix[i];
            }
        }
        else {
            // Left sum
            k = Math.abs(k);
            
            for(int i = n; i < 2*n; i++) {
                res[i - n] = prefix[i - 1] - prefix[i - k - 1];
            }
        }
    }
    
}

