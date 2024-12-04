class Solution {
    
    // TC : O(m + n)
    // SC : O(1)
    
    // Greedy approach
    // Try to find match so early as possible
    
    //Approach (Simple traversal using two pointers)
    
    public boolean canMakeSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        if (n > m) {
            return false;
        }
        
        int i = 0;
        int j = 0;
        
        while (i < m && j < n) {
            if ((str1.charAt(i) == str2.charAt(j)) || (str1.charAt(i) + 1 == str2.charAt(j)) || (str1.charAt(i) - 25 == str2.charAt(j))) {
                j++;
            }
            
            i++;
        }
        
        return j == n;
    }
    
}

