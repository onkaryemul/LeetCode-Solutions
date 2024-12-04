class Solution {
    
    // TC : O(m + n)
    // SC : O(1)
    
    // Greedy approach
    // Try to find match so early as possible
    
    public boolean canMakeSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        if (n > m) 
           return false;

        int first = -1, second = -1;
        
        while (first < m && second < n) {
            first++;
            second++;
            
            // Find matching char with diff <= 1
            while (first < m) {
                char nextChar = (char) (((str1.charAt(first) - 'a' + 1) % 26) + 'a');
                
                if (second < n && (str2.charAt(second) == str1.charAt(first) || str2.charAt(second) == nextChar)) {
                    break;
                }
                
                first++;
            }
        }
        
        if (first == m && second < n)
            return false;
        
        return true;
    }
    
}

