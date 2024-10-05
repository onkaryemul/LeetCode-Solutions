class Solution {
    
    // TC : O(n), where n = length of string s2
    // SC : O(26)
    
    // Sliding window & two pointers approach
    
    // function to return "true" if string s2 contains an anagram(permutation) of string s1, otherwise return "false" if it doesn't contains an anagram(permutation) of string s1
    public boolean checkInclusion(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();
        
        if(s1len > s2len) {
            return false;
        }
        
        // total no. of unmatching char count => length of string s1
        int unmatchingCharCount = s1len;
        
        int[] freqCount = new int[26];
        // traverse string s1 => update frequency of each character in string s1
        for(int i=0; i < s1len; i++) {
            int idx = s1.charAt(i) - 'a';
            freqCount[idx]++;
        }
        
        // Apply sliding window using two pointers
        int start = 0, end = 0;
        
        // Iterate over string s2 --> 1st window of size = length of string s1(s1len)
        while(end < s1len) {
            int idx = s2.charAt(end) - 'a';
            
            if(freqCount[idx] > 0) {
                unmatchingCharCount--;
            }
            
            freqCount[idx]--;
            
            end++;
        }
        
        // Check if 1st window of string s2 => is an anagram(permutation) of string s1
        if(unmatchingCharCount == 0) {
            return true; // found an anagram(permutation) of string s1 in string s2
        }
        
        // Iterate over remaining string of string s2 --> to get any other anagram(permutation) of string s1
        while(end < s2len) {
            // removing starting index
            int idxStart = s2.charAt(start) - 'a';
            
            if(freqCount[idxStart] >= 0) {
                // char is present in string s1
                unmatchingCharCount++;
            }
            
            freqCount[idxStart]++;
            
            start++; // movind start pointer
            
            int idxEnd = s2.charAt(end) - 'a';
            
            if(freqCount[idxEnd] > 0) {
                unmatchingCharCount--;
            }
            
            freqCount[idxEnd]--;
            
            if(unmatchingCharCount == 0) { // found an anagram(permutation) of string s1 in string s2
                return true; 
            }
            
            end++; // moving end pointer
        }
        
        return false;
    }
    
}

