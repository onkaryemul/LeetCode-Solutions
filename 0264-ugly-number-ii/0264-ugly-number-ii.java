class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
/*  
We have an array k of first n ugly number. We only know, at the beginning, the first one, which is 1. 
    
Then, k[1] = min( k[0]x2, k[0]x3, k[0]x5). The answer is k[0]x2. 
So we move 2's pointer to 1. 

Then we test: k[2] = min( k[1]x2, k[0]x3, k[0]x5). And so on. 

Be careful about the cases such as 6, in which we need to forward both pointers of 2 and 3.
*/
    
    // Bottom up DP
    public int nthUglyNumber(int n) {
        // An ugly number is a 'positive integer' whose prime factors are limited to 2, 3, and 5
        int[] uglyNums = new int[n+1];
        // uglyNums[i] --> ith ugly number
        // hence, we will return uglyNums[n] --> nth ugly number
        
        uglyNums[1] = 1; // 1st ugly number
        
        int i2 = 1; // i2th ugly number
        int i3 = 1; // i3rd ugly number
        int i5 = 1; // i5th ugly number
        
        for(int i=2; i <= n; i++) {
            int i2thUgly = uglyNums[i2] * 2;
            int i3rdUgly = uglyNums[i3] * 3;
            int i5thUgly = uglyNums[i5] * 5;
            
            uglyNums[i] = Math.min(Math.min(i2thUgly, i3rdUgly), i5thUgly);
            
            if(uglyNums[i] == i2thUgly) {
                i2++;
            }
            
            if(uglyNums[i] == i3rdUgly) {
                i3++;
            }
            
            if(uglyNums[i] == i5thUgly) {
                i5++;
            }
        }
        
        return uglyNums[n];
    }
    
}

