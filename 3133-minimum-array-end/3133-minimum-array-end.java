class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using Bit-Manipulation
    // Using the properties of AND and OR
    
    public long minEnd(int n, int x) {
        long num = x;
        
        for(int i=1; i < n; i++) {
            // Increment num & perform bitwise OR with x => in order to get the next smaller element which is greater than curren num & its bitwise AND with num gives x
            num = (num + 1) | x;
        }
        
        return num;
    }
    
}

