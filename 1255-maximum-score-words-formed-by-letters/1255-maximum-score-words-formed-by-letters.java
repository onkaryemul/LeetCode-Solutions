class Solution {
    
    //T.C : O(2^n) where n is the total number of words
    //S.C : O(n)
    
    private int n;
    private int maxScore;
    
    //Using simple backtracking
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        
        for(char ch : letters) {
            freq[ch-'a']++;
        }
        
        maxScore = Integer.MIN_VALUE;
        
        n = words.length;
        
        solve(0, 0, freq, score, words);
        
        return maxScore;
    }
    
    
    private void solve(int i, int currScore, int[] freq, int[] score, String[] words) {
        maxScore = Math.max(maxScore, currScore);
        
        // Base case
        if(i >= n) {
            return;
        }
        
        int[] tempFreq = Arrays.copyOf(freq, freq.length);
        
        int j = 0;
        int len = words[i].length();
        int tempScore = 0;
        
        while(j < len) {
            char ch = words[i].charAt(j);
            
            tempFreq[ch-'a']--;
            tempScore += score[ch-'a'];
            
            if(tempFreq[ch-'a'] < 0) {
                break;
            }
            
            j++;
        } 
        
        // Take words[i]
        if(j == len) { // It means we could form the word words[i]
            solve(i+1, currScore + tempScore, tempFreq, score, words);
        }
        
        // Not take words[i]
        solve(i+1, currScore, freq, score, words);
    }
    
}


