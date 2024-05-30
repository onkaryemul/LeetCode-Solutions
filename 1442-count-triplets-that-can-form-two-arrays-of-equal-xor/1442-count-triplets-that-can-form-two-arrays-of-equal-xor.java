class Solution {
    
    // TC : O(n^2)
    // SC : O(n)
    
    public int countTriplets(int[] arr) {
        int[] prefixXor = new int[arr.length + 1];
        
        // Initializing the first element to 0
        prefixXor[0] = 0;
        
        // Compute prefix XOR
        for(int i=1; i < prefixXor.length; i++) {
            prefixXor[i] = prefixXor[i-1] ^ arr[i-1];
        }
        
        int tripletsCnt = 0;
        
        // Count the triplets
        for(int i=0; i < prefixXor.length; i++) {
            for(int k=i+1; k < prefixXor.length; k++) {
                if(prefixXor[k] == prefixXor[i]) {
                    tripletsCnt += (k-i-1);
                }
            }
        }
        
        return tripletsCnt;
    }
    
}

