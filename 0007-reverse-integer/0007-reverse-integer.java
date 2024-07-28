class Solution {
    
    // TC : O(no. of digits in x) 
    // SC : O(1)
    
    public int reverse(int x) {
        int temp = Math.abs(x);
        int rev = 0;
        
        while(temp != 0) {
            int digit = temp % 10;
            
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE && digit > 7)) {
                return 0;
            }
            
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE && digit < -8)) {
                return 0;
            }
            
            rev = (rev * 10) + digit;
            
            temp = temp / 10;
        }
        
        return x < 0 ? -rev : rev;
    }
        
}

