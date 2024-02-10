class Solution {
    
    // TC : O(n^2) & SC : O(1)
    public int countSubstrings(String s) {
        int totalCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            totalCount += countPalindromes(s, i, i);  // odd length palindrome
            totalCount += countPalindromes(s, i, i + 1); // even length palindrome
        }
        
        return totalCount;
    }
    
    private int countPalindromes(String str, int start, int end) {
        int count = 0;
        
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            count++;
            
            start--;
            end++;
        }
        
        return count;
    }

}


