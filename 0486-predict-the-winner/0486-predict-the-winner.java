class Solution {
    
    // TC : O(n^2)
    // SC : O(n^2)
    
    // Dynamic Programming : Recursion + Memoization
    // Optimal game strategy
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        
        int[][] memo = new int[23][23]; // Constraints: 1 <= nums.length <= 20
        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        
        int totalScore = 0;
        for(int i=0; i < n; i++) {
            totalScore += nums[i];
        }
        
        int player1 = solve(nums, 0, n-1, memo); // recursive function call to get score of player
        int player2 = totalScore - player1;
        
        return player1 >= player2;
    }
    
    
    private int solve(int[] nums, int i, int j, int[][] memo) {
        // Base case
        if(i > j) {
            return 0;
        }
        
        if(i == j) {
            return nums[i]; // or nums[j]
        }
        
        // Check if already computed
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        
        // follow optimal game strategy
        int takeLeft = nums[i] + Math.min(solve(nums, i+2, j, memo), solve(nums, i+1, j-1, memo));
        
        int takeRight = nums[j] + Math.min(solve(nums, i, j-2, memo), solve(nums, i+1, j-1, memo)); 
        
        return memo[i][j] = Math.max(takeLeft, takeRight);
    }
    
}

