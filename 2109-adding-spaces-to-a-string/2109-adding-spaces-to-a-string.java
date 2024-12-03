class Solution {
    
    // T.C : O(m+n)
    // S.C : O(1)
    
    // Approach (Simple traversal using two pointers)
    
    public String addSpaces(String s, int[] spaces) {
        int m = s.length();
        int n = spaces.length;

        StringBuilder result = new StringBuilder(); // Using StringBuilder for efficiency
        
        int j = 0; // Pointer to traverse the spaces array

        for (int i = 0; i < m; i++) {
            if (j < n && i == spaces[j]) {
                result.append(" ");
                j++;
            }
            
            result.append(s.charAt(i));
        }

        return result.toString();
    }
    
}

