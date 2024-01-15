// Recursion + Memoization
class Solution {
    
    int n;
    int[] t;
    
    // helper function -> recursion & dp (memoization)
    private int solve(int idx, String s, Set<String> set) {
        // Base case
        if(idx >= n) {
            return 0;
        }
        
        // Memoization
        if(t[idx] != -1) {
            return t[idx];
        }
        
        
        int minChars = n;
        
        
        for(int i=idx; i<n; i++) {
            String temp = s.substring(idx, i+1);
            
            if(set.contains(temp)) {
                minChars = Math.min(minChars, solve(i+1, s, set));
            } else {
                minChars = Math.min(minChars, temp.length() + solve(i+1, s, set));
            }
        }
        
        
        return t[idx] = minChars;
    }
    
    
    // Main algorithm code
    public int minExtraChar(String s, String[] dictionary) {
        n = s.length();
        
        t = new int[n];
        Arrays.fill(t, -1);
        
        Set<String> set = new HashSet<String>();
        
        for(String str : dictionary) {
            set.add(str);
        }
        
        
        return solve(0, s, set);
    }
    
}


