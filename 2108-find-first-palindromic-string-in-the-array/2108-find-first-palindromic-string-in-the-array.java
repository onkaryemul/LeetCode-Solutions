class Solution {
    
    public String firstPalindrome(String[] words) {
        
        for(String word : words) {
            boolean ok = true;
            
            int size = word.length();
            
            for(int i=0; i < size/2; i++) {
                if(word.charAt(i) != word.charAt(size - i - 1)) {
                    ok = false;
                    break;
                }
            }
            
            if(ok) {
                return word;
            }
        }
        
        return "";
    }
    
}

