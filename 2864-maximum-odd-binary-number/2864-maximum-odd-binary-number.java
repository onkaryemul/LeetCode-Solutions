class Solution {
    
    // TC : O(n) , n = length of input string
    // SC : O(n)
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        
        int one = 0, zero = 0;
        
        for(int i=0; i < n; i++) {
            if(s.charAt(i) == '1') {
                one++;
            }
        }
        
        zero = n - one;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i < one-1; i++) {
            sb.append("1");
        }
        
        for(int i=0; i < zero; i++) {
            sb.append("0");
        }
        
        sb.append("1");
        
        return sb.toString();
    }
    
}

