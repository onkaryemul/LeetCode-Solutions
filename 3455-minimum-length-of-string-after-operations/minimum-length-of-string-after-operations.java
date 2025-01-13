class Solution {

    // TC : O(n)
    // SC : O(26) ~ O(1)

    // Single pass solution ==> Optimal approach

    // if frequency of any character is three, then we can choose middle index and remove first and third character
    // hence, 2 characters are deleted => only one character remained

    // Observations:
    // 1. frequency of any character is ODD, then after deletion, only ONE character remains
    // 2. frequency of any character is EVEN, then after deletion, only TWO character remain

    public int minimumLength(String s) {
        int n = s.length();

        int[] freq = new int[26];
        int deleted = 0; // keeps the count of deleted characters from string s

        for(int i=0; i < n; i++) {
            char ch = s.charAt(i);
            
            freq[ch - 'a']++;

            if(freq[ch - 'a'] == 3) {
                freq[ch - 'a'] -= 2; // TWO characters are deleted, by chosing middle (second) index
                deleted += 2;
            }
        }
        
        return n - deleted; // minimum length of string => after operations
    }

}

