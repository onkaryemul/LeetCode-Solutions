class Solution {
    
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        
        int ans = -1;
        int window = 0;
        int left = 0;
        
        
        for(int right=0; right<n; right++) {
            window +=  Math.abs(s.charAt(right) - t.charAt(right));
            
            if(window > maxCost) {
                window -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            
            ans = Math.max(ans, right - left + 1);
        }
        
        
        return ans;
    }
    
}

