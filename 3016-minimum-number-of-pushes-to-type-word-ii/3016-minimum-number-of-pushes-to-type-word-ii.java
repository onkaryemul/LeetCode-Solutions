class Solution {
    
    // TC : O(n) + O(26 * log26)
    // SC : O(26) ~ O(1)
    
    // Greedy approach - using sorting
    // Generic Solution
    public int minimumPushes(String word) {
        // String word containing lowercase english letters (not distinct --> means can repeat)
        Integer[] freq = new Integer[26]; // store frequency of a-z letters
        Arrays.fill(freq, 0); // Initialize the array with 0
        
        int n = word.length();
        for(int i=0; i < n; i++) {
            char ch = word.charAt(i);
            freq[ch-'a']++;
        }
        
        // Sort the freq array in the descending order of frequency
        Arrays.sort(freq, Collections.reverseOrder());
        
        int minPushes = 0;
        // highes frequency characters are placed on the lower indices of freq array
        for(int i=0; i < 26; i++) {
            int freqTimes = freq[i];
            int noOfPresses = (i/8) + 1;
            
            minPushes += (freqTimes * noOfPresses);
        }
        
        return minPushes;
    }
    
}

