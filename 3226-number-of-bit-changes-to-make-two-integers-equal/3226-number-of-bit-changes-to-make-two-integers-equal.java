class Solution {
    
    // TC : O(32) ~ O(1)
    // SC : O(1)
    
    // Bit Comparison
    public int minChanges(int n, int k) {
        int changeCnt = 0;
        
        for(int i=0; i <= 31; i++) {
            if((k & (1 << i)) != 0) { // ith bit set in k
                if((n & (1 << i)) != 0) { // ith bit set in n
                    continue;
                }
                else {
                    return -1; // we cannot convert 0 to 1
                }
            }
            else if ((n & (1 << i)) != 0) {  // ith bit set in n
                changeCnt++;
            }
        }
        
        return changeCnt;
    }
    
}


/* 
Since we can only change 1's to 0,
n must have 1 at places where k has 1's.

1. Loop for all bit i.e. 0 to 31
    1.1 if ith bit 1 in k
        1.1.1 if ith bit not 1 in n, return -1
    1.2 else if ith bit 1 in n, we need to convert it to 0.
        increment ans by 1.
*/

