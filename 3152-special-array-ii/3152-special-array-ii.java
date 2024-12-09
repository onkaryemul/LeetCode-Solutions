class Solution {
    
    // TC : O(n + m)
    // SC : O(n) => prefix sum array
    
    // Using Prefix Sum approach
    
    // prefix[i] = Length of longest alterating substring ending at index i
    
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        
        // prefix[i] = Length of longest alterating substring ending at index i
        int[] prefixSum = new int[n];
        prefixSum[0] = 1;
        
        for(int i=1; i < n; i++) {
            if((nums[i] & 1) == (nums[i-1] & 1)) {
                prefixSum[i] = 1;
            }
            else {
                prefixSum[i] = 1 + prefixSum[i-1];
            }
        }
        
        // Build the result boolean[] to be return
        boolean[] ans = new boolean[m]; // m = queries.length
        
        int i = 0;
        
        for(int[] query : queries) {
            int start = query[0];
            int end = query[1];
            
            int size = end - start + 1;
            
            if(prefixSum[end] >= size) {
                ans[i] = true;
            } 
            else {
                ans[i] = false;
            }
            
            i++;
        }
        
        return ans;
    }
    
}

