class Solution {
    
    // TC : O(N)
    // SC : O(N)
    
    // Math + String
    public String nearestPalindromic(String n) {
        int N = n.length();
        
        // Handle the edge cases for single-digit numbers
        if(N == 1) {
            return Integer.toString(Integer.parseInt(n) - 1);
        }
        
        long original = Long.parseLong(n);
        long lessDigits = (long)Math.pow(10, N-1) - 1;
        long moreDigits = (long)Math.pow(10, N) + 1;
        
        // Generate the first half
        long halfVal = Long.parseLong(n.substring(0, (N+1)/2));
        
        long same = buildPalindrome(halfVal, N%2 == 0);
        long smaller = buildPalindrome(halfVal - 1, N%2 == 0);
        long bigger = buildPalindrome(halfVal + 1, N%2 == 0);
        
        // Collect all candidates
        long[] candidates = { lessDigits, moreDigits, smaller, same, bigger };
        
        Arrays.sort(candidates);
        
        // Find the closest palindrome
        long closest = Long.MAX_VALUE;
        
        for(long candidate : candidates) {
            if(candidate == original) {
                continue;
            }
            
            if(Math.abs(candidate - original) < Math.abs(closest - original)) {
                closest = candidate;
            }
        }
        
        return Long.toString(closest);
    }
    
    
    // helper function 
    // build the palindrome from first half of string
    private long buildPalindrome(long half, boolean isEven) {
        String halfStr = Long.toString(half);
        String palindromeStr;
        
        if(isEven) {
            palindromeStr = halfStr + new StringBuilder(halfStr).reverse().toString();
        }
        else {
            palindromeStr = halfStr + new StringBuilder(halfStr.substring(0, halfStr.length()-1)).reverse().toString();
        }
        
        return Long.parseLong(palindromeStr);
    }
    
}

