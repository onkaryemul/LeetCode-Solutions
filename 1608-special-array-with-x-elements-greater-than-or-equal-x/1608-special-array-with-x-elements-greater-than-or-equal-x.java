class Solution {
    
    // TC : O(n*logn)
    // SC : O(1)
    
    public int specialArray(int[] nums) {
        // 1. Sort the given array
        Arrays.sort(nums);
        
        int n = nums.length;
        
        int min = Math.min(nums[0], n);
        int max = Math.min(nums[n-1], n);
        
        int x = min;
        int idx = 0; // index point
        
        while(x <= max) {
            if(x == n-idx) {
                return x;
            }
            
            while(idx < n && nums[idx] <= x) {
                idx++;
            }
            
            x++;
        }
        
        return -1;
    }
    
}

