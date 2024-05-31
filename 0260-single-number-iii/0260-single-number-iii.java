class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Bit Manipulation Approach
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        
        // Perform XOR for all elements to find xor
        for(int num : nums) {
            xor ^= num;
        }
        
        // Find the rightmost set bit (mask)
        long mask = xor & (-xor);
        
        int groupA = 0;
        int groupB = 0;
        
        // Divide the numbers into two groups and perform XOR in each group
        for(int num : nums) {
            // check if bit is set
            if((num & mask) != 0) {
                groupA ^= num;
            }
            else {
                // bit is unset
                groupB ^= num;
            }
        }
        
        // Return the unique numbers
        return new int[]{groupA, groupB};
    }

}

