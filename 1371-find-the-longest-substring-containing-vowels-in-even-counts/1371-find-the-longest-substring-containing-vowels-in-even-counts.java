class Solution {
    
    // TC : O(n)
    // SC : O(26 + 32) ~ O(1)
    
    // Using the concept of "Bit Mask"
    public int findTheLongestSubstring(String s) {
        int res = 0; // length of longest substring containing each vowel an even number of times
        
        int[] vowelToBit = new int[26];
        vowelToBit['a' - 'a'] = 1 << 0; // 2^0 = 1
        vowelToBit['e' - 'a'] = 1 << 1; // 2^1 = 2
        vowelToBit['i' - 'a'] = 1 << 2; // 2^2 = 4
        vowelToBit['o' - 'a'] = 1 << 3; // 2^3 = 8
        vowelToBit['u' - 'a'] = 1 << 4; // 2^4 = 16
       
        int[] locs = new int[1 << 5]; // 2^5 = 32
        for(int i=0; i < locs.length; i++) {
            locs[i] = -2; // not seen it before
        }
        
        locs[0] = -1; // 00000 -> -1, empty subarray with all vowels zero at index -1
        
        int mask = 0;
        int n = s.length();
        
        for(int i=0; i < n; i++) {
            char ch = s.charAt(i);
            
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                mask ^= vowelToBit[ch - 'a'];
            }
            
            if(locs[mask] != -2) {
                res = Math.max(res, i - locs[mask]);
            }
            else {
                locs[mask] = i;
            }
        }
        
        return res;
    }
    
}

