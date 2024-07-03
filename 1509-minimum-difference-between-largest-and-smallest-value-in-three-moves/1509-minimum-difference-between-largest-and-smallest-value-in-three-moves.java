class Solution {
    
    // TC : O(n*logn)
    // SC : O(1)
    
    // Simply Sorting & Greedy Approach
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        
        // Base case
        if(n <= 3) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        // Check all 4 cases
        for(int i=1; i <= 4; i++) {
            min = Math.min(min, Math.abs(nums[n-i] - nums[4-i]));
        }
        
        return min;
    }
    
}

