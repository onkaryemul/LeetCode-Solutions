class Solution {
    
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        String lastWord = words[words.length - 1];
        int length = lastWord.length();
        return length;
    }
    
}

