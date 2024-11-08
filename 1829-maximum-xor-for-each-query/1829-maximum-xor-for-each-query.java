class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using Bit-Manipulation
    // Using XOR Properties
    
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        
        int[] result = new int[n];
        
        // Step 1 : Calculate the total XOR of all elements in nums
        int XOR = 0;
        for(int num : nums) {
            XOR ^= num;
        }
        
        // Step 2 : Create a mask with all bits set to 1, based on maximumBit
        
        // to create a mask of n bits with all bits set to 1:
        // mask = 2^n  - 1
        // mask = (1 << n) - 1
        
        // Here, we want a mask of maximumBit size with all bits set to 1 
        int mask = (1 << maximumBit) - 1;
        
        // Step 3 : Calculate the result by finding the maximum XOR for each element
        for(int i=0; i < n; i++) {
            // current element ==> XOR
            // In order to get maximum XOR => we need to do xor of current element with its flip
            int k = XOR ^ mask; // XOR ^ mask => will give the flipped value of XOR, which is the best K
            result[i] = k;
            
            // update XOR => by removing the last element in the reversed order
            XOR ^= nums[n-1-i];
        }
        
        
        return result;
    }
    
}

