class Solution {
    
    // TC : O(log(n)) ~ O(log32) ~ O(1)
    // SC : O(1)
    
    // Bit Manipulation
    public int bitwiseComplement(int n) {
        // num + complement(num) = all 1's
        // therefore, complement(num) = all 1's - num
        
        // Edge case
        if(n == 0) {
            return 1;
        }
        
        int temp = n;
        int ones = 0;
        
        while(temp > 0) {
            ones = ones << 1;
            ones += 1;
            temp = temp >> 1; // divide by 2
        }
        
        return ones - n;
    }
    
}

