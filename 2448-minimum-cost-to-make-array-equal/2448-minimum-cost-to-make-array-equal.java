class Solution {
    
    // TC : O(n + logn)
    // SC : O(1)
    
    // Using Binary Search technique
    public long minCost(int[] nums, int[] cost) {
        long minTotalCost = Long.MAX_VALUE; // minimum total cost such that all elements of the array nums become equal
        
        int left = Integer.MAX_VALUE; 
        int right = Integer.MIN_VALUE; 
        
        // Find the minimum and maximum in the array nums
        for(int num : nums) {
            if(num < left) {
                left = num;
            }
            if(num > right) {
                right = num;
            }
        }
        
        // Applying binary search
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid+1);
            
            minTotalCost = Math.min(cost1, cost2);
            
            if(cost1 > cost2) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return minTotalCost == Long.MAX_VALUE ? 0 : minTotalCost;
    }
    

    private long getCost(int[] nums, int[] cost, int target) {
        long totalCost = 0;
        
        int n = nums.length;
        for(int i=0; i < n; i++) {
            totalCost += (long)Math.abs(nums[i] - target) * cost[i];    
        }
        
        return totalCost;
    }
    
}

