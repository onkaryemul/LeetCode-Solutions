class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // In-place implementation
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        // Edge case
        if(n == 0) {
            return 0;
        }
        
        int i = 0, j = 1;
        
        while(j < n) {
            if(nums[i] != nums[j]) {
                nums[++i] = nums[j];   
            }
            j++;
        }
        
        return i+1;
    }
    
}

