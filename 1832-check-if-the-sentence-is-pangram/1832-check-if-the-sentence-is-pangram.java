class Solution {
    
    // TC : O(n), in 1 traversal
    // SC : O(26) ~ O(1)
    
    // Single Pass solution
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        int cnt = 0; // keeps track of no. of unique characters
        
        int n = sentence.length();
        for(int i=0; i < n; i++) {
            char ch = sentence.charAt(i);
            
            if(arr[ch - 'a'] == 0) {
                arr[ch-'a']++;
                cnt++;
            }
        }
        
        return cnt == 26;
    }
    
}

