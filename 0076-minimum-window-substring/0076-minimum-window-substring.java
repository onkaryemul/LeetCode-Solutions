class Solution {
    
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        
        String resultString = "";
        
        // Handle the edge case
        if(tlen > slen) {
            return resultString;
        }
        
        int[] tCount = new int[128];
        for(char ch : t.toCharArray()) {
            tCount[ch]++;
        }
        
        char[] sChars = s.toCharArray();
        
        int left = 0, right = 0;
        int toFind = tlen;
        int found = 0;
        
        int minWindowLength = Integer.MAX_VALUE;
        
        
        while(right < slen) {
            char ch = sChars[right];
            
            tCount[ch]--;
            
            if(tCount[ch] >= 0) {
                found++;
            }
            
            while(found == toFind) {
                if((right - left + 1) < minWindowLength) {
                    minWindowLength = right - left + 1;
                    resultString = s.substring(left, right + 1);
                }
                
                tCount[sChars[left]]++;
                
                if(tCount[sChars[left]] > 0) {
                    found--;
                }
                
                left++;
            }
            
            right++;
        }
        
        
        return resultString;
    }
    
}

