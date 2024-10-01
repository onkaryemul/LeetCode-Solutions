class Solution {
    
    // TC : O(n + k)
    // SC : O(k)
    
    // Simple Remainder maths
    public boolean canArrange(int[] arr, int k) {
        int[] map = new int[k]; // array to store remainders frequency
        // map[rem] = freq
        
        // Calculate the remainder frequencies
        for(int num : arr) {
            // int rem = num % k; // gives the remainder of a num when divided by k
            int rem = (num % k + k) % k; // handle negative remainders
            map[rem]++;
        }
        
        // Check if the frequency of numbers with 0 remainder is even
        if(map[0] % 2 != 0) {
            return false;
        }
        
        // Check if each remainder has a complement remainder with matching frequency
        for(int rem = 1; rem <= k/2; rem++) {
            int counterHalf = k - rem;
            
            if(map[counterHalf] != map[rem]) {
                return false;
            }
        }
        
        return true;
    }
    
}

