class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    public String convert(String s, int numRows) {
        // Special case where zigzag conversion is not needed
        if (numRows == 1) {
            return s; 
        }

        StringBuilder[] strs = new StringBuilder[numRows];
        for (int index = 0; index < numRows; index++) {
            strs[index] = new StringBuilder(); // Initialize each StringBuilder
        }
        
        int i = 0;
        int n = s.length();
        
        while(i < n) {
            for(int index=0; index < numRows && i < n; index++) {
                strs[index].append(s.charAt(i));
                i++;
            }
            
            for(int index=numRows-2; index > 0 && i < n; index--) {
                strs[index].append(s.charAt(i));
                i++;
            } 
        }
        
        StringBuilder result = new StringBuilder();
        for(StringBuilder str : strs) {
            result.append(str);
        }
        
        return result.toString();
    }
    
}

