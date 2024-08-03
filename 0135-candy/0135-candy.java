class Solution {
    
    // TC : O(n)
    // SC : O(2*n) ~ O(n), but using 2 extra arrays
    
    public int candy(int[] ratings) {
        int n = ratings.length;
        
        int[] L2R = new int[n];
        int[] R2L = new int[n];
        // Each student must have at least one candy
        Arrays.fill(L2R, 1);  
        Arrays.fill(R2L, 1);
        
        // First comparing with only left neighbor
        for(int i=1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) {
                L2R[i] = L2R[i-1] + 1;
            }
        }
        
        // Then comparing with only right neighbor
        for(int i=n-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                R2L[i] = R2L[i+1] + 1;
            }
        }
        
        // We need to return minimum no. of candies required to distribute it to the children
        int minCandies = 0;
        for(int i=0; i < n; i++) {
            minCandies += Math.max(L2R[i], R2L[i]);
        }
        
        return minCandies;
    }
    
}


/*     
//Approach-2 
//T.C : O(n)
//S.C : O(n) - Using only 1 Extra Array

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n];
        Arrays.fill(count, 1);
        
        // First comparing with only left neighbor
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        
        // Then comparing with only right neighbor
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i], count[i + 1] + 1);
            }
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += count[i];
        }
        
        return result;
    }


//Approach-3
//T.C : O(n)
//S.C : O(1)

    public int candy(int[] ratings) {
        int n = ratings.length;
        int candy = n; // Each person given one candy initially
        
        int i = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }
            
            // For increasing slope
            int peak = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                candy += peak;
                i++;
                if (i == n) return candy;
            }
            
            // For decreasing slope
            int valley = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                valley++;
                candy += valley;
                i++;
            }
            
            // Subtract the minimum of peak and valley as we've added it twice
            candy -= Math.min(peak, valley);
        }
        
        return candy;
    }
*/

