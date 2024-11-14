class Solution {
    
    // TC : O(m * log(max(quantities)))
    // SC : O(1)
    
    // Using Binary Search on answers approach
    
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        
        int maxi = quantities[0];
        for(int i=1; i < m; i++) {
            maxi = Math.max(maxi, quantities[i]);
        }
        
        // Apply binary search on answers
        int ans = -1;
        
        int low = 1, high = maxi;
        
        // TC : O(log(maxi)) => for binary search
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(isPossibleToDistribute(mid, quantities, n)) { // TC : O(m)
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
    
        return ans;
    }
    
    
    // Helper function
    private boolean isPossibleToDistribute(int x, int[] quantities, int shops) {
        for(int product : quantities) {
            // To calculate ceil :  (product + x - 1) / x
            // (int)Math.ceil(product/x) 
            shops -= (product + x - 1) / x;
            
            if(shops < 0) {
                return false;
            }
        }
        
        return true;
    }
    
}

