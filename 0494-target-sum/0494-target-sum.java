class Solution {
    
    // TC : O(N * K), at max N*K new problems will be solved
    // SC : O(N * K) + O(N), recursion stack space (O(N)) and a 2D array (O(N*K))
    
    // Using Dynamic Programming (DP)
    // Using Recursion + Memoization
    
    // Using the concept of "Count Number of partitions of arr such that S1 - S2 = D, where S1 = sum of subset 1,  S2 = sum of subset 2"
    
    // TotalSum = S1 + S2
    // therefore, S1 = TotalSum - S2
    
    // S1 - S2 = D
    // TargetSum - S2 - S2 = D
    // therefore, S2 = (TargetSum - D) / 2, where (TargetSum - D) >= 0 & even
    
    // function to find the number of ways to achieve the target sum
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        
        int totalSum = 0;
        // Calculate the total sum of elements in the array
        for(int i=0; i < n; i++) {
            totalSum += nums[i];
        }
        
        // Checking for edge cases
        // (totalSum - target) >= 0 ==> then only it is possible
        if(totalSum - target < 0) {
            return 0; // 0 ways to form target sum
        } 
        
        // (totalSum - target) % 2 == 0 ==> even ==> then only it is possible
        if((totalSum - target) % 2 == 1) {
            return 0; // 0 ways to form target sum
        }
        
        // Calculate the second subset sum based on the totalSum and the target
        int s2 = (totalSum - target) / 2;
        
        // Create a 2D array to store the results of subproblems
        int[][] dp = new int[n + 1][s2 + 1];
    
        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        // call the countPartitionUtil function to calculate the number of ways
        return countPartitionsUtil(n-1, s2, nums, dp);
    }
    
    
    // Helper function => to count partitions using dynamic programming
    private int countPartitionsUtil(int idx, int target, int[] arr, int[][] dp) {
        // Base case : If we have reached the first element
        if(idx == 0) {
            // Check if the target is 0 and the first element is also 0
            if(target == 0 && arr[0] == 0) {
                return 2;
            }
            // Check if the target is 0 or it is equal to the first element
            if(target == 0 || target == arr[0]) {
                return 1;
            }
            return 0;
        }
        
        // If the result for this subproblem has already been calculated, return it
        if(dp[idx][target] != -1) {
            return dp[idx][target];
        }
        
        // Calculate the number of ways without taking the current element
        int notTaken = countPartitionsUtil(idx-1, target, arr, dp);
        
        // Initialize the number of ways taking the current element as 0
        int taken = 0;
        
        // If the current element is <= target, calculate taken
        if(arr[idx] <= target) {
            taken = countPartitionsUtil(idx-1, target-arr[idx], arr, dp);
        }
        
        // Store the result in the dp array and return it
        return dp[idx][target] = (notTaken + taken);
    }
    
}




