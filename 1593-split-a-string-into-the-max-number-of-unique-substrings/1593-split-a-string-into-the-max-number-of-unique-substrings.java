class Solution {
    
    // TC : (n * 2^n)
    // SC : O(n)
    
    // Using Recursion + Backtracking
    
    private int n;
    
    public int maxUniqueSplit(String s) {
        int[] maxCount = new int[1]; // Using array to allow updated by references
        
        HashSet<String> set = new HashSet<>();
        
        n = s.length();
        
        solve(0, s, set, 0, maxCount);
        
        return maxCount[0];
    }
    
    
    // Helper function ==> Using Simple Backtracking 
    private void solve(int i, String s, HashSet<String> set, int currCnt, int[] maxCount) {
        // Pruning for slight improvement
        if(currCnt + (n - i) <= maxCount[0]) {
            return;
        }
        
        // Base case
        if(i == s.length()) {
            maxCount[0] = Math.max(maxCount[0], currCnt);
            return;
        }
        
        // Start making substring from i to n
        for(int j=i; j < n; j++) {
            String subStr = s.substring(i, j+1);
            
            if(!set.contains(subStr)) {
                set.add(subStr); // DO
                solve(j+1, s, set, currCnt + 1, maxCount); // EXPLORE
                set.remove(subStr);
            }
        }   
    }
    
}

