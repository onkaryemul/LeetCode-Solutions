class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        
        // Check if first character & last character of sentence match
        if(sentence.charAt(0) != sentence.charAt(n-1)) { // if they do not match, then return false ==> indicating not a circular sentence
            return false;
        }
        
        // Iterate from index 1 to n-2 (since we don't need to check first and last characters again)
        for(int i=1; i < n-1; i++) {
            // Check if current character is space ie. ' '
            if(sentence.charAt(i) == ' ') {
                // before space => sentence.charAt(i-1) ==> last character of current word
                // after space => sentence.charAt(i+1) ==> first character of next word
                if(sentence.charAt(i-1) != sentence.charAt(i+1)) {
                    return false; // if last char of curr word does not match with first char of next word, then it means it cannot be a circular sentence
                }
            }          
        }
        
        return true;
    }
    
}

