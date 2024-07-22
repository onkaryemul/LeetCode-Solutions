class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Single Pass Solution -> by keeping track of minimum stock price left to ith day
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        
        int minPrice = Integer.MAX_VALUE;
        for(int i=0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            else if (prices[i] - minPrice > maxprofit) {
                maxprofit = prices[i] - minPrice;
            }
        }
        
        return maxprofit;
    }
    
}

