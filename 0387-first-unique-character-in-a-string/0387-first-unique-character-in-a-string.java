class Solution {
    
    // TC : O(1)
    // SC : O(1)
    public int firstUniqChar(String s) {
        int ans = 1000000;
        
        for(char ch = 'a'; ch <= 'z'; ch++) {
            int first = s.indexOf(ch); // return -1 if not present
            
            if(first != -1 && first == s.lastIndexOf(ch)) {
                ans = Math.min(ans, first);
            }
        }
        
        if(ans == 1000000) {
            return -1;
        }
        
        return ans;
    }
    
}


