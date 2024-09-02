class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Making use of remainder
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        
        // Calculate the total sum of chalk required in one iteration
        long totalChalkSum = 0;
        for(int chalkReq : chalk) {
            totalChalkSum += chalkReq;
        }
        
        // Calculate the remaining chalk after full iterationss
        int remainingChalk = (int)(k % totalChalkSum);
        
        // Find the first student who cannot complete their required chalk usage
        for(int i=0; i < n; i++) {
            if(remainingChalk < chalk[i]) {
                return i;
            }
            remainingChalk -= chalk[i];
        }
        
        return -1; // In theory, this line should never be reached
    }
    
}

