class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Two pointer & Sliding Window technique
    public int lengthOfLongestSubstring(String s) {
        // key : element
        // Value : index of element
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int n = s.length();
        int len = 0; // keep track of length of longest substring without repeating characters
        
        int left = 0, right = 0;
        
        while(right < n) {
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            
            map.put(s.charAt(right), right);
            
            len = Math.max(len, right - left + 1);
            
            right++;
        }
        
        
        return len;
    }
    
}

