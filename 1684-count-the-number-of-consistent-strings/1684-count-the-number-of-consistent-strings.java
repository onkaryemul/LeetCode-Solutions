class Solution {
    
    // TC : O(m + n*k)
    // SC : O(26) ~ O(1)
    
    // Using HashSet and simple iteration
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>(); 
        
        for(char ch : allowed.toCharArray()) { // TC : O(m) -> m = no. of distinct characters in string "allowed"
            set.add(ch);
        }
        
        int cnt = 0; // no. of consistent strings
        for(String word : words) {
            boolean isConsistent = true;
            int n = word.length();
            
            for(int i=0; i < n; i++) {
                char currChar = word.charAt(i);
                if(!set.contains(currChar)) {
                    isConsistent = false;
                    break;
                }
            }
            
            if(isConsistent) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
}

