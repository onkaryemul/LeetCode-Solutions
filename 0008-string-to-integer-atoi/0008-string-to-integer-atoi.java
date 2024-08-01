class Solution {
    
    // TC : O(len(s))
    // SC : O(1)
    
    public int myAtoi(String s) {
        int no = 0;
        
        boolean isNegative = false;
        
        int i = 0;
        int len = s.length();
        
        // triming white spaces
        while(i<len && s.charAt(i) == ' ') {
            i++;
        }
        
        if(i<len && s.charAt(i) == '-') {
            isNegative = true;
            i++;
        }
        else if(i<len && s.charAt(i) == '+') {
            i++;
        }
        
        // now everything has to be number
        while(i<len && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            if(no > (Integer.MAX_VALUE - digit)/10) {
                if(isNegative) {
                    return Integer.MIN_VALUE;
                }
                else {
                    return Integer.MAX_VALUE;
                }
            }
            
            no = no * 10 + digit;
            
            i++;
        }
        
        
        if(no == 0) {
            return 0;
        }
        
        return isNegative ? -no : no;
    }
    
}

