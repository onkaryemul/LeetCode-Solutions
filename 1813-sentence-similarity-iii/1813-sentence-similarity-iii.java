class Solution {
    
    // n = length of String[] w1 => after splitting string sentence1
    // m = length of String[] w2 => after splitting string sentence2
    
    // TC : O(n + m)
    // SC : O(n + m)
    
    // Using the concept of "Longest Common Prefix" & "Longest Common Suffix"
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Base case/Edge case
        if(sentence1.equals(sentence2)) {
            return true;
        }
        
        String[] w1 = sentence1.split(" ");
        String[] w2 = sentence2.split(" ");
        
        // Check if first string (sentence1) has more words than second string(sentence2)
        if(w1.length > w2.length) { // if yes, then call itself by swapping two strings ==> in order to get first string(sentence1) with less words than second string (sentence2)
            return areSentencesSimilar(sentence2, sentence1);
        }
        
        int pre = 0;
        while(pre < w1.length && w1[pre].equals(w2[pre])) {
            pre++;
        }
        
        int post = w1.length - 1;
        int j = w2.length - 1;
        
        while(post >= 0 && w1[post].equals(w2[j])) {
            post--;
            j--;
        }
        
        return pre > post;
    }
    
}

