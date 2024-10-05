class Solution {
        
    // TC : O(n), where n = length of string s
    // SC : O(n) + O(26)
    
    // Sliding window & two pointers approach
    
    // function to "return an array" of "all the start indices of p's anagrams in s"
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        int slen = s.length();
        int plen = p.length();
        
        if(plen > slen) {
            return ans;
        }
        
        // total no. of unmatched char count => length of string p
        int unmatchingCharCount = plen;
        
        int[] freqCount = new int[26];
        // traverse string p => update frequency of each character in string p 
        for(int i=0; i < plen; i++) {
            int idx = p.charAt(i) - 'a';
            freqCount[idx]++;
        }
        
        // Apply sliding window using two pointers
        int start = 0, end = 0;
        
        // iterate over string s --> 1st window of size = length of string p(plen)
        while(end < plen) {
            int idx = s.charAt(end) - 'a';
            
            if(freqCount[idx] > 0) {
                unmatchingCharCount--;
            }
            
            freqCount[idx]--;
            
            end++;
        }
        
        // Check if 1st window of string s => is an anagram of string p
        if(unmatchingCharCount == 0) {
            ans.add(start);
        }
        
        
        // Iterate over remaining string of string s -> to get any other anagram of string p
        while(end < slen) {
            // remove starting index
            int idxStart = s.charAt(start) - 'a';
            
            if(freqCount[idxStart] >= 0) {
                // char was present is p
                unmatchingCharCount++;
            }
            
            freqCount[idxStart]++;
            
            start++; // moving start pointer
            
            int idxEnd = s.charAt(end) - 'a';
            
            if(freqCount[idxEnd] > 0) {
                unmatchingCharCount--;
            }
            
            freqCount[idxEnd]--;
            
            if(unmatchingCharCount == 0) {
                ans.add(start);
            }
            
            end++; //moving end pointer
        }
        
        return ans;
    }
    
}

