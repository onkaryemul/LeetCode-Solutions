class Solution {
    
    // TC : O(n^3)
    // SC : O(1)
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        
        int count = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                // check if nums[i...j] is increasing or not 
                if(isIncreasingSubarray(nums, n, i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    
    // helper function
    private boolean isIncreasingSubarray(int[] nums, int n, int start, int end) {
        int prev = 0;
        
        for(int i=0; i<n; i++) {
            if(i<=end && i>=start) {
                continue;
            }
            
            if(nums[i] <= prev) {
                return false;
            }
            prev = nums[i];
        }
        
        return true;
    }
    
}

