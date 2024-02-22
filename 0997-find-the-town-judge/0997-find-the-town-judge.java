class Solution {
    
    // TC : O(E), E in the number of entries in trust
    // SC : O(N), number of people 
    public int findJudge(int n, int[][] trust) {
        // Base case
        if(trust.length < n-1) {
            return -1;
        }
        
        int[] inDegrees = new int[n+1];
        int[] outDegrees = new int[n+1];
        
        for(int[] arr : trust) {
            outDegrees[arr[0]]++;
            inDegrees[arr[1]]++;
        }
        
        for(int i=1; i<=n; i++) {
            if(inDegrees[i] == n-1 && outDegrees[i] == 0) {
                return i;
            }
        }
        
        return -1;
    }
    
}

