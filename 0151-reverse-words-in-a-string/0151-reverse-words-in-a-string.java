class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Two-pointers approach
    public String reverseWords(String s) {
        int n = s.length();
        
        // 1. Reverse the entire string
        s = new StringBuilder(s).reverse().toString();
        
        char[] charArray = s.toCharArray();
        
        int i = 0;
        int l = 0, r = 0;
        
        while(i < n) {
            // Move i and r to the next non-space character
            while(i<n && charArray[i] != ' ') {
                charArray[r] = charArray[i];
                i++;
                r++;
            }
            
            // check if there are characters between l and r, reverse them
            if(l < r) {
                reverse(charArray, l, r-1);
                
                if(r < n) {
                    charArray[r] = ' ';
                    r++;
                }
                
                l = r;
            }
            
            i++; // Move to the next character
        }
        
        // convert the charArray back to string and trim the trailing space
        return new String(charArray, 0, r > 0 && charArray[r-1] == ' ' ? r-1 : r);
    }
    
    
    private void reverse(char[] array, int left, int right) {
        while(left < right) {
            char temp = array[left];
            
            array[left] = array[right];
            array[right] = temp;
            
            left++;
            right--;
        }
    }
    
}

