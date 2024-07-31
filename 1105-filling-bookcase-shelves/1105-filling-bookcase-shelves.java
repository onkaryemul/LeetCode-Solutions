class Solution {
    
    // TC : O(n*shelfWidth)
    // SC : O(n*shelfWidth)
    
    private int n;
    private int WIDTH;
    private int[][] memo;
    
    // Using Recursion + Memoization
    public int minHeightShelves(int[][] books, int shelfWidth) {
        n = books.length;
        
        WIDTH = shelfWidth;
        
        memo = new int[1001][1001];
        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        
        int remainW = shelfWidth;
        
        return solve(books, 0, remainW, 0);
    }
    
    
    private int solve(int[][] books, int i, int remainW, int maxHt) {
        // Base case
        if(i >= n) {
            return maxHt;
        }
        
        if(memo[i][remainW] != -1) {
            return memo[i][remainW];
        }
        
        int bookW = books[i][0];
        int bookH = books[i][1];
        
        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;
        
        // keep 
        if(bookW <= remainW) { // let's keep it here
            keep = solve(books, i+1, remainW - bookW, Math.max(maxHt, bookH));
        }
        
        // skip and put in next shelf
        skip = maxHt + solve(books, i+1, WIDTH - bookW, bookH);
        
        return memo[i][remainW] = Math.min(keep, skip);
    }
    
}

