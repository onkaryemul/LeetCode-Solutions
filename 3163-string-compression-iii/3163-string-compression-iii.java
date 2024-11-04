class Solution {
    
    // TC : O(n)
    // SC : O(n), for taking stringbuilder
    
    // Using Simulation
    
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        
        int n = word.length();
        
        int i = 0;
        while(i < n) {
            int cnt = 0;
            char ch = word.charAt(i);
            
            while(i < n && cnt < 9 && word.charAt(i) == ch) {
                cnt++;
                i++;
            }
            
            comp.append(cnt).append(ch);
        }
        
        return comp.toString();
    }
    
}

