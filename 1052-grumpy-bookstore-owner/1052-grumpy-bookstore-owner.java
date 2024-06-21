class Solution {
    
    //T.C : O(n)
    //S.C : O(1)

    
    // Sliding Window technique
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length; // n = grumpy.length
        
        int initialSatisfied = 0; // tracks initial number of statisifed customers
        
        // Calculate initial satisfied customers
        for(int i=0; i < n; i++) {
            if(grumpy[i] == 0) {
                initialSatisfied += customers[i];
            }
        }
        
        // Use sliding window to calculate the maximum additional satisfied customers
        int maxAdditionalSatisfied = 0;
        int currentAdditionalSatisfied = 0;
        
        // Initialize the first window
        for(int i=0; i < minutes; i++) {
            if(grumpy[i] == 1) {
                currentAdditionalSatisfied += customers[i];
            }
        }
        
        maxAdditionalSatisfied = currentAdditionalSatisfied;
        
        // Slide the window from start to end
        for(int i=minutes; i < n; i++) {
            if(grumpy[i-minutes] == 1) {
                currentAdditionalSatisfied -= customers[i-minutes];
            }
            
            if(grumpy[i] == 1) {
                currentAdditionalSatisfied += customers[i];
            }
            
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, currentAdditionalSatisfied);
        }
        
        // Total satisfied customers is the initial satisfied plus the maximum additional statisfied
        return initialSatisfied + maxAdditionalSatisfied;
    }
    
}

