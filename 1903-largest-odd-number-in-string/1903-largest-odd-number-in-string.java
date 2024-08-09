class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Simple Greedy approach 
    public String largestOddNumber(String num) {
        int n = num.length();
        
        for(int i=n-1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            
            // Check if the digit is odd
            if(digit%2 != 0) { // if yes, then greedy take substring from 0 to i
                return num.substring(0, i+1);
            }
        }
        
        return "";
    }
    
}

