class Solution {
    
    // TC : O(n^2)
    // SC : O(n)
    
    // Using the concept of "Longest Increasing Subsequence(LIS)"
    // in both direction => (Left to right) & (right to left)
    
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        
        // Traverse from left to right => perform LIS (Longest Increasing Subsequence)
        for(int i=0; i < n; i++) {
            for(int j=0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
        
        //  Traverse from right to left => perform LDS (Longest Decreasing Subsequence)
        for(int i=n-1; i >= 0; i--) {
            for(int j=n-1; j > i; j--) {
                if(nums[i] > nums[j]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        
        // Minimum no. of removals to make mountain array
        //    = len(nums) - len(larget mountain)
        
        // for a mountain : => LIS endint at that element > 1 & LDS starting at the element > 1
        
        // len(mountain) = Left[i] + right[i] - 1; // -1 because , current element is added twice
     
        int res = Integer.MAX_VALUE;
        
        for(int i=0; i < n; i++) {
            if (left[i] > 1 && right[i] > 1) {
                res = Math.min(res, n - (left[i] + right[i] - 1));
            }
        }
        
        return res;
    }
    
}

