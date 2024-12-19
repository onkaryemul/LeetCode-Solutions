class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Greedy approach
    
    // Greedy partitioning
    
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        
        int count = 0;
        
        int maxSeen = 0;
        
        for(int i=0; i < n; i++) {
            maxSeen = Math.max(maxSeen, arr[i]);
            
            if(maxSeen == i) {
                count++;
            }
        }
        
        return count;
    }
    
}

