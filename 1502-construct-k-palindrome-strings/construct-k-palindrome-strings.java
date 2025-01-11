class Solution {
    
    // TC : O(n)
    // SC : O(26) ~ O(1)
    
    // Based on greedy approach

    // Using the fact that
    // Odd frequency characters count control the palindromes count

    public boolean canConstruct(String s, int k) {
        int n = s.length();
        // if string has n characters, then at max we can 'n' palindromic string 

        if(n < k) {
            return false;
        }
        
        if(n == k) {
            return true;
        }

        int[] freq = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int oddFreqCharCount = 0;
       
        for(int i=0; i < 26; i++) {
            if(freq[i] % 2 != 0) {
                oddFreqCharCount++;
            }
        }

        return oddFreqCharCount <= k;
    }

}

