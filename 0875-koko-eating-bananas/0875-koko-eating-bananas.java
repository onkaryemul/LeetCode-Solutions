class Solution {
    
    // TC : O(N * log(max(a[])))
    // SC : O(1)
    
    // Binary search for the range [1, max(a[])],
    
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        
        int low = 1, high = getMax(piles, n);
        
        // apply binary search
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            int totalHoursRequired = calculateTotalHours(piles, n, mid);
            
            if(totalHoursRequired <= h) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    
    // Helper function => to calculate total hours required to eat all bananas at rate of 'mid' bananas/hour
    private int calculateTotalHours(int[] piles, int n, int hourly) {
        int totalH = 0;
        
        // find total hours
        for(int i=0; i < n; i++) {
            totalH += Math.ceil((double)piles[i] / (double)hourly);
        }
        
        return totalH;
    }
    
    
    // Helper function => to get maximum from piles[]
    private int getMax(int[] piles, int n) {
        int maxi = piles[0];
        
        for(int i=1; i < n; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        
        return maxi;
    }
    
}

