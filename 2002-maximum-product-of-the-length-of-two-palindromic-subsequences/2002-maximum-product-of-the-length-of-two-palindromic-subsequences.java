class Solution {
    
    private int ans = 0;
    
    
    // Function to check if string is palindrome or not
    private boolean isPalindrome(StringBuilder sb) {
        int i = 0;
        int j = sb.length() - 1;
        
        while(i < j) {
            if(sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    // helper function -> dfs function
    private void dfs(final String s, int i, StringBuilder sb1, StringBuilder sb2) {
        // Base case
        if(i == s.length()) {
            if(isPalindrome(sb1) && isPalindrome(sb2)) {
                ans = Math.max(ans, sb1.length() * sb2.length());
            }
            return;
        }
        
        
        final int sb1Length = sb1.length();
        dfs(s, i+1, sb1.append(s.charAt(i)), sb2);
        sb1.setLength(sb1Length);
        
        
        final int sb2Length = sb2.length();
        dfs(s, i+1, sb1, sb2.append(s.charAt(i)));
        sb2.setLength(sb2Length);
        
        
        dfs(s, i+1, sb1, sb2);
    }
    
    
    // TC : O(n * 3^n)
    // SC : O(n)
    public int maxProduct(String s) {
        dfs(s, 0, new StringBuilder(), new StringBuilder());
        return ans;
    }
    
}

