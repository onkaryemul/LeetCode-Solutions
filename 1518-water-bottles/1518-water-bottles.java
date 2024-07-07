class Solution {
    
    //T.C : O(numBottles)
    //S.C : O(1)
    
    // Simple simulation
    public int numWaterBottles(int numBottles, int numExchange) {
        int consumed = 0;

        while (numBottles >= numExchange) {
            consumed += numExchange;
            numBottles -= numExchange;

            numBottles += 1;
        }
  
        return consumed + numBottles;
    }
    
}

