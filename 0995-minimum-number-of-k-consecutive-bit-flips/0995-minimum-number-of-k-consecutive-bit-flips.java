class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Bit manipulation 
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        
        int res = 0;
        int flipped = 0;
        
        int[] isFlipped = new int[n]; // initialized with 0
        
        for(int i=0; i < n; i++) {
            if(i >= k) {
               flipped ^= isFlipped[i - k]; 
            }
            
            if(flipped == nums[i]) {
                if(i+k > n) {
                    return -1;
                }
                
                isFlipped[i] = 1;
                flipped ^= 1;
                
                res++;
            }
        }
        
        return res;
    }
    
}

