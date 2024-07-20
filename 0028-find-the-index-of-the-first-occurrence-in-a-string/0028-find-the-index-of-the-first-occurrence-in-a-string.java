class Solution {
    
    // TC : O(m*n)
    // SC : O(1)
    
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        for(int i=0; i <= (m-n); i++) { // haystack
            for(int j=0; j < n; j++) { // needle
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                
                if(j == n-1) {
                    return i;
                }
            }
        }
        
        return -1;
    }
    
}

