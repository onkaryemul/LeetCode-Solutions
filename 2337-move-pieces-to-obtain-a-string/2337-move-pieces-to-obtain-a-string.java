class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using Observations
    
    public boolean canChange(String start, String target) {
        int n = start.length();
        
        int first = 0, second = 0;
        int limitIdx = -1;

        int[] firstPos = {first};
        int[] secondPos = {second};

        while (firstPos[0] < n) {
            // Skip all spaces
            skipSpaces(start, n, firstPos);
            skipSpaces(target, n, secondPos);

            first = firstPos[0];
            second = secondPos[0];

            if (first == n && second == n) 
                 return true;
                 
            if (first == n || second == n || start.charAt(first) != target.charAt(second)) 
                 return false;

            if (start.charAt(first) == 'L' && (second <= limitIdx || second > first)) {
                return false;
            } 
            else if (start.charAt(first) == 'R' && first > second) {
                return false;
            }

            limitIdx = second;
            
            firstPos[0]++;
            secondPos[0]++;
        }

        // Skip leftover spaces (if any)
        skipSpaces(start, n, firstPos);
        
        skipSpaces(target, n, secondPos);

        return firstPos[0] == n && secondPos[0] == n;
    }
    
    
    private void skipSpaces(String s, int n, int[] pos) {
        while (pos[0] < n && s.charAt(pos[0]) == '_') {
            pos[0]++;
        }
    }
    
}

