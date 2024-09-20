class Solution {
    
    // TC : O(n)
    // SC : O(n) -> for result string 
    
    // String ->  Rolling Hash
    // Hash function :  (ASCII(ch) * prime ^ index) % MOD
    
    private final int MOD = 1_000_000_007;
    
    public String shortestPalindrome(String s) {
        int n = s.length();
        
        long pow = 1;
        int prime = 7;
        
        long forwardHash = 0;
        long reverseHash = 0;
        
        int palindromeEndIndex = -1;
        
        // Calculate rolling hashes & find the longest palindromic prefix
        for(int i=0; i < n; i++) {
            int currentCharValue = s.charAt(i); // ASCII of s.charAt(i)
            
            forwardHash = (forwardHash + currentCharValue * pow) % MOD;
            
            // Update reverse hash using pow for base powers
            reverseHash = (reverseHash * prime + currentCharValue) % MOD;
            
            // If forward & reverse hashes match, update palindrome end index
            if(forwardHash == reverseHash) {
                palindromeEndIndex = i;
            }
            
            pow = (pow * prime) % MOD;
        }
        
        // Find the remaining suffix after the longest palindromic prefix
        String suffix = s.substring(palindromeEndIndex + 1);
        
        // Reverse the remaining suffix and prepend it to the original string
        String reversedSuffix = new StringBuilder(suffix).reverse().toString();
        
        return reversedSuffix + s;
    }
    
}

