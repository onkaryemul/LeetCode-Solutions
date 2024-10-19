class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Optimized approach
    
    // function to find kth bit in Nth binary string
    public char findKthBit(int n, int k) {
        // Base case
        if(n == 1) {
            return '0';
        }
        
        int len = (1 << n); // 2^n
        
        if(k < len/2) { // kth bit is in the "left part"
            return findKthBit(n-1, k);
        }
        else if(k == len/2) { 
            return '1';
        }
        else { // kth bit is in the "right part"
            // kth bit in the left part ==> (len-k)th bit in the right part
            char invertBit = findKthBit(n-1, len-k);
            return invertBit == '0' ? '1' : '0';   
        }
    }
    
}


/*
// Brute Force approach
// Using a StringBuilder to construct the string iteratively by reversing & inverting the previous string

    // function to find kth bit in Nth binary string
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder("0"); // Initially, s1 = "0"
        StringBuilder temp;
        
        while(n-- > 0) {
            temp = new StringBuilder(s);
            
            reverseInvert(temp);
            
            // Si-1 + "1" + reverse(inverse(Si-1))
            s.append("1").append(temp);
        }
        
        return s.charAt(k-1);
    }
    
    
    // Helper function => to calculate reverse of invert of binary string s
    private void reverseInvert(StringBuilder temp) {
        int n = temp.length();
        
        // inverse the given binary string
        for(int i=0; i < n; i++) {
            if(temp.charAt(i) == '0') {
               temp.setCharAt(i, '1');
            }
            else { // temp.charAt(i) == '1'
               temp.setCharAt(i, '0');
            }
        }
        
        // reverse the inverted binary string
        temp.reverse();
    }
*/

