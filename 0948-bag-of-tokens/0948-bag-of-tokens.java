class Solution {
    
    // Greedy Approach:
    // TC : O(n*logn) & SC : O(1)
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        
        int maxScore = 0; // initially
        int score = 0;
        
        Arrays.sort(tokens); // sorting the tokens in increasing order for applying greedy technique
        
        int i = 0, j = n - 1;
        
        while(i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score += 1;
                i++;
                maxScore = Math.max(maxScore, score);
            }
            else if (score >= 1) {
                power += tokens[j];
                j--;
                score -= 1;
            }
            else {
                return maxScore;
            }
        }
        
        return maxScore;
    }
    
}

