class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros
    
    public void moveZeroes(int[] nums) {
        // Edge case
        if(nums == null || nums.length == 0) {
            return;
        }
        
        int n = nums.length;
        
        int insertPos = 0; // Start with the first position
        
        for(int i=0; i < n; i++) {
            // Fill all non-zero numbers
            if(nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        
        while(insertPos < n) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }
    
}

