class Solution {
    
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        
        if(idx == -1) {
            return word;
        }
        
        StringBuilder sb = new StringBuilder(word.substring(0, idx+1)).reverse();
        
        if(idx+1 < word.length()) {
            sb.append(word.substring(idx+1));
        }
        
        return sb.toString();
    }

}

