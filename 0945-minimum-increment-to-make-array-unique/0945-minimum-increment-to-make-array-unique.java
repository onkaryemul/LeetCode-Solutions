class Solution {
    
    // TC : O(n*logn), due to sorting
    // SC : O(1)
    
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        
        // 1. Sort the array
        Arrays.sort(nums);
        
        int moves = 0;
        
        for(int i=1; i < n; i++) {
            int prev = nums[i-1];
            int curr = nums[i];
            
            if(prev >= curr) {
                moves += (prev - curr + 1);
                nums[i] = prev + 1;
            }
        }
        
        return moves;
    }
    
}

