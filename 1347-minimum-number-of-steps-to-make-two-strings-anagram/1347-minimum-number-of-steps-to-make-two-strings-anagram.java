class Solution {
    
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        int res = 0; // store the minimum number of steps to make 't' an anagram of 's'
        
        int len = s.length();
        
        for(int i=0; i<len; i++) {
            count[s.charAt(i) - 'a'] ++;
            count[t.charAt(i) - 'a'] --;
        }
        
        
        for(int i : count) {
            if(i > 0) {
                res += i;
            }
        }
        
        return res;
    }
    
}

