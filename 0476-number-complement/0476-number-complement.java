class Solution {
    
    // TC : O(log(num)) ~ O(log(32)) ~ O(1)
    // SC : O(1)
    
    // Bit Manipulation
    public int findComplement(int num) {
        // num + complement(num) = all 1's
        // therefore, complement(num) = all 1's - num
        int temp = num;
        int ones = 0;
        
        while(temp > 0) {
            ones = ones << 1;
            ones += 1;
            temp = temp >> 1; // divide by 2
        }
        
        return ones - num;
    }
    
}

