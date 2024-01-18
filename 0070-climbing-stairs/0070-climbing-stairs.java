// Same as Fibonacci Series
class Solution {
    
    // TC : O(n) & SC : O(1)
    public int climbStairs(int n) {
        // Base case
        if(n==0 || n==1) {
            return 1;
        }
        
        int one = 1;
        int two = 1;
        int ans = 0;
        
        for(int i=2; i<=n; i++) {
            ans = one + two;
            two = one;
            one = ans;
        }
        
        return ans;
    }
    
}

