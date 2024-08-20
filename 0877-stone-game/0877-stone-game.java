class Solution {

    // TC : O(n^2)
    // SC : O(n^2)
    
    // Dynamic Programming + Game strategy
    public boolean stoneGame(int[] piles) {
        int n = piles.length; // piles.length is even
        // sum(piles[i]) is odd
        
        int[][] dp = new int[n][n];
        
        gameHelper(0, n-1, true, piles, dp); // true -> Alice turn, false -> Bob turn
        
        return dp[0][n-1] > 0; // return true if Alice wins the game, otherwise false
    }
    
    
    private int gameHelper(int left, int right, boolean isAliceTurn, int[] piles, int[][] dp) {
        // Base case
        if(left >= right) {
            return 0;
        }
        
        if(dp[left][right] > 0) {
            return dp[left][right];
        }
        
        // Check if it is a Alice turn
        if(isAliceTurn) { // if it is Alice's turn
            int pickedLeft = piles[left] + gameHelper(left+1, right, false, piles, dp);
            int pickedRight = piles[right] + gameHelper(left, right-1, false, piles, dp);
            
            dp[left][right] = Math.max(pickedLeft, pickedRight); // Storing the max ans at particular indices
            return dp[left][right];
        }
        else { // If it is Bob's turn
            int pickedLeft = piles[left] + gameHelper(left+1, right, true, piles, dp);
            int pickedRight = piles[right] + gameHelper(left, right-1, true, piles, dp);
            
            dp[left][right] = Math.min(pickedLeft, pickedRight); // storing the min ans at particular indices
            return dp[left][right];
        }
    }
    
}


