class Solution {
    
    // TC : O(logn)
    // SC : O(1)
    
    public boolean isUgly(int n) {
        // An ugly number is a 'positive integer' whose prime factors are limited to 2, 3, and 5
        // Base cases
        if(n <= 0) {
            return false;
        }
        
        if(n == 1) {
            return true;
        }
        
        while(n > 1) {
            if(n%2 == 0) {
                n = n/2;
            }
            else if (n%3 == 0) {
                n = n/3;
            }
            else if (n%5 == 0) {
                n = n/5;
            }
            else {
                return false;
            }
        }
        
        return n == 1;
    }
    
}

