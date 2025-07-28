class Solution {

    // TC : O(n * maxOR)
    // SC : O(n * maxOR)
 
    // Using Dynamic Programming (Recursion + Memoization)
    
    public int countMaxOrSubsets(int[] nums) {
        // 1. Calculate maximum Bitwise OR of a subset of nums
        int maxOr = 0;

        for(int num : nums) {
            maxOr |= num;
        }

        // 2. Create a 2D dp array of size (n+1)*(maxOr+1)
        int n = nums.length;
        
        int[][] dp = new int[n+1][maxOr+1];

        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int currOr = 0;

        return countSubsets(0, currOr, nums, maxOr, dp);
    }

    // Helper function
    // Recursion + Memoization 
    // Using take & not-take approach
    private int countSubsets(int idx, int currOr, int[] nums, int maxOr, int[][] dp) {
        // Base case
        if(idx == nums.length) {
            if(currOr == maxOr) {
                return dp[idx][currOr] = 1; // found one subset
            }
            return dp[idx][currOr] = 0;
        }

        // Check if it is already computed
        if(dp[idx][currOr] != -1) {
            return dp[idx][currOr];
        }

        // Take nums[idx]
        int take = countSubsets(idx+1, currOr | nums[idx], nums, maxOr, dp);

        // Not take nums[idx]
        int notTake = countSubsets(idx+1, currOr, nums, maxOr, dp);

        return dp[idx][currOr] = take + notTake;
    }

}