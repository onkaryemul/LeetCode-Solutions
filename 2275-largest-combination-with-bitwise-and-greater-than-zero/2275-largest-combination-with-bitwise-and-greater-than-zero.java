class Solution {
    
    // TC : O(24*n) ~ O(n)
    // SC : O(1)
    
    // Optimal approach ==> withou using counter array
    
    // Constraints:  1 <= candidates[i] <= 10^7
    // Hence, in order to represent largest number in the range ie. 10^7, we need 24 bits
    
    // Minimum no. of bits required to represent a number n = floor(log(n) to the base 2) + 1
    
    public int largestCombination(int[] candidates) {
        int maxSize = 0;
        
        // Check for first 24 bits => since larget number possible is 10^7 => which require 24 bits
        for(int i=0; i < 24; i++) { // O(24)
            int countIth = 0; // count the no. of integers in candidates[] whose ith bit set
            
            for(int num : candidates) { // O(n)
                // Check if ith bit is set in num
                if((num & (1<<i)) != 0) {
                    countIth++;
                }
            }
            
            maxSize = Math.max(maxSize, countIth);
        }
        
        return maxSize;
    }
    
}

