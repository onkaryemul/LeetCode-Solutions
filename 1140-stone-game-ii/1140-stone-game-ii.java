class Solution {
    
    // TC : O(n^3)
    // SC : O(n^3)
    
    // Dynamic Programming + Game Strategy
    
    private int n;
    private int[][][] dp;
    
    
    // Function to return the maximum no. of stones Alice can get
    public int stoneGameII(int[] piles) {
        n = piles.length;
        
        dp = new int[2][n+1][n+1]; // SC : O(n^3)
        
        // TC : O(n^3)
        for(int[][] arr2D : dp) {
            for(int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        
        // solveForAlice(int person, int i, int M, int[] piles) 
        return solveForAlice(1, 0, 1, piles); 
    }
    
    
    // Function to calculate the maximum no. of stones that Alice can get
    // considering, that both Alice and Bob play optimally
    private int solveForAlice(int person, int i, int M, int[] piles) {
        // Base case
        if(i >= n) {
            return 0;
        }
        
        if(dp[person][i][M] != -1) {
            return dp[person][i][M];
        }
        
        // Assign the value to the result based on person
        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;
        
        for(int x=1; x <= Math.min(2*M, n-i); x++) {
            stones += piles[i + x - 1];
            
            if(person == 1) { // Alice turn
                result = Math.max(result, stones + solveForAlice(0, i+x, Math.max(M, x), piles));
            }
            else {
                result = Math.min(result, solveForAlice(1, i+x, Math.max(M, x), piles));
            }
        }
        
        return dp[person][i][M] = result;
    }
    
    
}

