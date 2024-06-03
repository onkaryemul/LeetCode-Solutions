class Solution {
    
    //T.C : O(n)
    //S.C : O(1)
    
    public int appendCharacters(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        int i = 0; // for s
        int j = 0; // for t
        
        while(i<m && j<n) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        
        return n - j;
    }
    
}

