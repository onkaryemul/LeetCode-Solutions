class Solution {
    
    //T.C : O(2*n) ~ O(n)
    //S.C : O(1)
    
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length(); // t.length()
        
        int maxLen = 0;
        int currCost = 0;
        
        int i=0, j=0;
        
        for(j=0; j < n; j++) {
            currCost += Math.abs(s.charAt(j) - t.charAt(j)); // increasing the window size using j
            
            while(currCost > maxCost) {
                currCost -= Math.abs(s.charAt(i) - t.charAt(i)); // shrinking the window size using i
                i++;
            }
            
            maxLen = Math.max(maxLen, j-i+1);
        }
        
        return maxLen;
    }
    
}

