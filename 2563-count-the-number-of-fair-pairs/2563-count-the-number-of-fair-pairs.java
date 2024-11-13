class Solution {
    
    // TC : O(n*logn + n*logn) ~ O(n*logn)
    // SC : O(1)
    
    // Using Sorting + Binary search
    
    // function to return the no. of fair pairs (i, j) => such that 0 <= i < j < n and lower <= nums[i] + nums[j] <= upper
    public long countFairPairs(int[] nums, int lower, int upper) {
        // Here, in question, the condition 0 <= i < j < n 
        // means that (i != j) => ie. element at ith index is choosen as any element of nums[] & element jth index is choosen as any other element of nums[] 
        // such that lower <= nums[i] + nums[j] <= upper
        
        // Hence, here we can sort the nums[] => without needing to maintain index of any elements of nums[]
        long cnt = 0;
        
        int n = nums.length;
        
        // Step 1 : Sort the array
        Arrays.sort(nums);
        
        // Step 2 : Iterate over element of nums[] & select lowerbound and upperbound of that element to the right side of it => & doing (ub - lb) gives no. of elements with which current element can form a fair pair such that the given condition holds
        for(int i=0; i < n-1; i++) {
            int lb = lowerBound(nums, i+1, n, lower - nums[i]);
            int ub = upperBound(nums, i+1, n, upper - nums[i]);
            cnt += (ub - lb);
        }
        
        return cnt;
    }
    
    
    // Helper function => to calculate the lower bound of element
    // ie. first occurrence of element in nums[] or an first occurrence of element > current element
    private int lowerBound(int[] nums, int start, int end, int target) {
        while(start < end) {
            int mid = start + (end - start)/2;
            
            if(nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        
        return start;
    }
    
    // Helper function => to calculate the upper bound of element
    // ie. first occurrence of an element > target element
    private int upperBound(int[] nums, int start, int end, int target) {
        while(start < end) {
            int mid = start + (end - start) / 2;
            
            if(nums[mid] <= target) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        
        return start;
    }
    
}


