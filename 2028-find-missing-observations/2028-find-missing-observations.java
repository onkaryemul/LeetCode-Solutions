class Solution {
    
    // TC : O(rolls + n)
    // SC : O(1), ignoring the res[] which is used to return the result
    
    // Using Simple Math
    
    // knownRolls + unknownRolls = mean * numberOfRolls
    // sum(rolls) + x = mean * (rolls.length + n)
    // x = (mean * (rolls.length + n)) - sum(rolls)
    
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int knownRollTotal = 0;
        for(int roll : rolls) {
            knownRollTotal += roll;
        }
        
        int meanRollTotal = mean * (rolls.length + n);
        
        // unknownRollTotal = (mean * (rolls.length + n)) - sum(rolls)
        int nRollTotal = meanRollTotal - knownRollTotal;  // unknownRollTotal
        
        // Check if it is not possible
        if(nRollTotal < n || nRollTotal > 6*n) {
            return new int[]{};
        }
        
        int[] res = new int[n]; // missing observations of n rolls
        
        int val = nRollTotal / n; // base value -> assign to each element of res
        int extra = nRollTotal % n; // to be given 1 to each
        
        for(int i=0; i < n; i++) {
            res[i] = val + (i < extra ? 1 : 0);
        }
        
        return res;
    }
    
}

