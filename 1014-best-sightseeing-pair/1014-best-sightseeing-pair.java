class Solution {
    
    // TC : O(n), single pass solution
    // SC : O(1)
    
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        
        // sum(i, j) = values[i] + values[j] + (i - j)
        // after rearranging, we get
        // sum(i, j) = (values[i] + i) + (values[j] - j)
        // sum(i, j) = first + second
        
        // first = values[i] + i
        // second = values[j] - j
        
        int first = values[0]; // ie. values[0] + 0
        int second;
        
        int maxPairSum = 0;
        
        for(int j=1; j < n; j++) {
            second = values[j] - j;
            
            maxPairSum = Math.max(maxPairSum, first + second);
            
            first = Math.max(first, values[j] + j);
        }
        
        return maxPairSum;
    }
    
}

