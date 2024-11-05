class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using Simple iteration and simulation
    
    // Here, we need to return the "minimum no. of changes required" to make the string s beautiful.
    
    // Hence, we can say that No. of substrings/partitions (of even length) => containing only 1's or only 0's ===> does not matter 
    // Therefore, we will try to make substrings/partitions of minimum length 2 (even) & check if characters in this substring/partitions match, if not match, then we need to make a change
    
    public int minChanges(String s) {
        int n = s.length();
        
        int changes = 0;
        
        for(int i=0; i < n-1; i += 2) { // check in substring/partition of size 2
            if(s.charAt(i) != s.charAt(i+1)) { 
                // If characters in substring of size 2 (even) does not match, then we need to make a change
                changes++; 
            }
        }
        
        return changes;
    }
    
}


/*
// Approach-1 (Simple iterate and count and keep track)
// T.C : O(n)
// S.C : O(1)

    public int minChanges(String s) {
        int n = s.length();

        int changes = 0;
        
        char curr = s.charAt(0);
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == curr) {
                count++;
                continue;
            }

            if (count % 2 == 0) {
                count = 1;
            } else {
                count = 0;
                changes++;
            }
            
            curr = s.charAt(i);
        }

        return changes;
    }
*/

