class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        
        for(int i=0; i < arr.length; i++) {
            if(arr[i]%2 == 1) {
                count++; // count it
            }
            else {
                count = 0; // reset it
            }
            
            if(count == 3) {
                return true;
            }
        }
        
        return false;
    }
    
}

