class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Concatenation of a string with itself contains all possible rotations
    
    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        
        // Check if the lengths match & if goal is a substring of (s+s)
        if(m == n && (s+s).contains(goal)) {
            return true;
        }
        
        return false;
    }
    
}

