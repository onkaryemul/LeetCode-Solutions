class Solution {
    
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        
        while(start < end) {
            // Swap characters at start and end indices
            char ch = s[start];
            s[start] = s[end];
            s[end] = ch;
            
            start++;
            end--;
        }
    }
    
}

