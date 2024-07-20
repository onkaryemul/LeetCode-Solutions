class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Greedy approach 
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length; // n = cost.length
        
        int sumGas = 0, sumCost = 0;
        for(int i=0; i < n; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }
        
        // check for base case
        if(sumGas < sumCost) {
            return -1;
        }
        
        int total = 0;
        int resultIndex = 0;
        
        for(int i=0; i < n; i++) {
            total += gas[i] - cost[i];
            
            if(total < 0) {
                total = 0;
                resultIndex = i+1;
            }
        }
        
        return resultIndex;
    }
    
}

