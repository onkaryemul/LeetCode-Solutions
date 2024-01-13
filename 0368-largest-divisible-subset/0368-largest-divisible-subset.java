class Solution {
    
    // helper function -> longest increasing subsequence
    // returns the maximum possible largest divisible subset size
    private int getLDSSize(int[] nums, int[] dp) {
        int ldsSize = 1;
        int n = nums.length;
        
        // Longest Increasing Subsequence(LIS) -> O(n^2)
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ldsSize = Math.max(ldsSize, dp[i]);
                }
            }
        }
        
        return ldsSize;
    }
    
    
    // helper function -> return a list or subset of longest increasing subset
    private List<Integer> constructLDS(int[] nums, int[] dp, int ldsSize) {
        LinkedList<Integer> lds = new LinkedList<>();
        
        int prev = -1;
        int dpLength = dp.length;
        
        for(int i=dpLength-1; i>=0; i--) {
            if(dp[i] == ldsSize && (prev == -1 || prev % nums[i] == 0)) {
                lds.addFirst(nums[i]);
                ldsSize--;
                prev = nums[i];
            }
        }
        
        
        return lds;
    }
    
    
    // Main algorithm code
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        Arrays.sort(nums);
        
        int ldsSize = getLDSSize(nums, dp); // maximum possible largest Divisible Subset size
        
        return constructLDS(nums, dp, ldsSize);
    }
    
}


