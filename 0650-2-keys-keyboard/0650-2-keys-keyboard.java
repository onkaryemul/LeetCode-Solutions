class Solution {
    
    // TC : O(sqrt(n)) --> worst case: O(n) when n is large prime number
    //      O(sqrt(n) * log(sqrt(n)))
    // It can be more accurately approximated as O(√n) due to the fact that the number of prime factors of n is generally proportional to the logarithm of n
    
    // SC : O(1)
    
    // Maths & Dynamic Programming
    public int minSteps(int n) {
        // Minimum no. of operations to get the character 'A' exactly n times on the screen
        int minOpr = 0;
        
        int primeFactor = 2;
        
        while(primeFactor <= n) {
            // Check if n is divisible by current prime factor
            // divide it until it is not divisible
            while(n % primeFactor == 0) {
                minOpr += primeFactor;
                n = n/primeFactor;
            }
            
            primeFactor++;
        }
        
        return n > 1 ? minOpr + n : minOpr;
    }
    
}

