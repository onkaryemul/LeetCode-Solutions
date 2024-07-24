class Solution {
    
    // TC : O(number of digits)
    // SC : O(1)
    
    public boolean isPalindrome(int x) {
        // Base case: All negative no's are not palindrome
        if(x < 0) {
            return false;
        }
        
        long reversed = 0;
        long temp = x;
        
        while(temp != 0) {
            int digit = (int)(temp % 10);
            reversed = reversed * 10 + digit;
            temp = temp/10;
        }
        
        return reversed == x;
    }
    
}

