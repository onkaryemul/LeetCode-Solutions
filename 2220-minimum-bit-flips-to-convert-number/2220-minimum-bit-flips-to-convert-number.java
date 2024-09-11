class Solution {
    
    // TC : O(log(start ^ goal)) to the base 2
    // SC : O(1)
    
    // Using Bit-Manipulation
    public int minBitFlips(int start, int goal) {
        int bitFlips = 0;
        
        int res = start ^ goal;
        
        while(res > 0) {
            bitFlips += (res % 2);
            res /= 2;
        }
        
        return bitFlips;
    }
    
}


/*   
    // TC : O(32)
    // SC : O(1)
    
    // Using Bit-Manipulation
    public int minBitFlips(int start, int goal) {
        int bitFlips = 0;
        
        int res = start ^ goal;
        
        for(int i=0; i < 32; i++) {
            if((res & (1 << i)) != 0) {
                bitFlips++;
            }
        }
        
        return bitFlips;
    }
*/

