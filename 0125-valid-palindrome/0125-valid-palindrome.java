class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        
        int i = 0, j = s.length()-1;
        
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
}

