class Solution {
    
    // TC : O(n)
    // SC : O(n), using stringbuilder
    
    public String makeFancyString(String s) {
        int n = s.length();
        
        // Base case / Edge case
        if(n < 3) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        
        for(int i=2; i < n; i++) {
            char ch = s.charAt(i);
            
            if(ch == s.charAt(i-1) && ch == s.charAt(i-2)) {
                continue;
            }
            
            sb.append(ch);
        }
        
        return sb.toString();
    }
    
}

