class Solution {
    
    // TC : O(n * amount)
    // SC : O(n * amount) + O(height of recursive stack)
    
    private final int max = 1000000000; // 1e9
    
    // Recursion + Memoization
    public int coinChange(int[] coins, int amount) {
        // We need to return minimum no. of coins needed to achieve the target amount
        int n = coins.length;
        
        // Creating a 2D array to store results of subproblems
        int[][] dp = new int[n][amount + 1];
        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        // Calculate the minimum no. of coins needed to achieve the target amount
        int minCoins = minimumCoinsHelper(n-1, amount, coins, dp);
        
        // Check if it is not possible to achieve the target amount, then return -1
        if(minCoins >= max) {
            return -1;
        }
        
        return minCoins;
    }
    
    
    private int minimumCoinsHelper(int idx, int target, int[] arr, int[][] dp) {
        // Base case: If the current index is 0
        if(idx == 0) {
            // If target amount is divisible by the first element of the array, return the quotient 
            if(target % arr[0] == 0) {
                return target / arr[0];
            }
            else { // if not, return a large value to indicate,it's not possible
                return max;
            }
        }
        
        // If the result for this subproblem has already been calculated, return it
        if(dp[idx][target] != -1) {
            return dp[idx][target];
        }
        
        // Not take: Without taking current element
        int notTake = 0 + minimumCoinsHelper(idx-1, target, arr, dp); 
        
        // Take
        int take = max;
        // If the current element <= target amount, then calculate the minimum no. of coins after taking it
        if(arr[idx] <= target) {
            take = 1 + minimumCoinsHelper(idx, target - arr[idx], arr, dp);
        }
        
        return dp[idx][target] = Math.min(notTake, take); // store the minimum result in the dp array and return it
    }
    
}

