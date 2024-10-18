class Solution {
    
    // TC : O(n * maxOR)
    // SC : O(n * maxOR)
    
    // Using Dynamic Programming (Recursion + Memoization)
    // Memoizing to store subproblems result
    
    public int countMaxOrSubsets(int[] nums) {
        // 1. Calculate maxOR (maximum possible bitwise OR of a subset of nums)
        int maxOR = 0;
        
        for(int num : nums) {
            maxOR = maxOR | num;
        }
        
        // 2. Create a 2D dp array of size (n+1)*(maxOR+1)
        int n = nums.length;
        
        int[][] dp = new int[n+1][maxOR+1];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        int currOR = 0;
        
        return countSubsets(0, currOR, nums, maxOR, dp);
    }
    
    
    // Helper function
    // Recursion + Memoization
    private int countSubsets(int idx, int currOR, int[] nums, int maxOR, int[][] dp) {
        // Base case
        if(idx >= nums.length) {
            if(currOR == maxOR) {
                return dp[idx][currOR] = 1; // found one subset
            }
            return dp[idx][currOR] = 0;
        }
        
        // Check if it is already computed
        if(dp[idx][currOR] != -1) {
            return dp[idx][currOR];
        }
        
        // Take nums[idx]
        int takeCount = countSubsets(idx+1, currOR | nums[idx], nums, maxOR, dp);
        
        // Not taken nums[idx]
        int notTakeCount = countSubsets(idx+1, currOR, nums, maxOR, dp);
        
        return dp[idx][currOR] = takeCount + notTakeCount;
    }
    
}

