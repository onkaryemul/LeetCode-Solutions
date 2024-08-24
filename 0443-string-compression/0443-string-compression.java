class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using two-pointers 
    // Run Length Encoding
    public int compress(char[] chars) {
        int n = chars.length;
        
        int i = 0;
        int index = 0;
        
        while(i < n) {
            char currChar = chars[i];
            int count = 0;
            
            // Find count of duplicates
            while(i < n && chars[i] == currChar) {
                count++;
                i++;
            }
            
            // Assign it to chars & move index ahead to add the count
            chars[index] = currChar;
            index++;
            
            // Add the count
            if(count > 1) {
                String countStr = Integer.toString(count);
                for(char ch : countStr.toCharArray()) {
                    chars[index] = ch;
                    index++;
                }
            }
        }
        
        return index;
    }
    
}

