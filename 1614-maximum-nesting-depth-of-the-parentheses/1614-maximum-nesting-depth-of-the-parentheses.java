class Solution {
    
    // TC : O(n)
    // SC : O(1)
    public int maxDepth(String s) {
        int n = s.length();
        
        int depth = 0;
        int ans = 0; // tracks the maximum nesting depth of the Parentheses
        
        for(int i=0; i < n; i++) {
            if(s.charAt(i) == '(') {
                depth++;
                ans = Math.max(ans, depth);
            }
            
            if(s.charAt(i) == ')') {
                depth--;
            }
        }
        
        return ans;
    }
    
}

