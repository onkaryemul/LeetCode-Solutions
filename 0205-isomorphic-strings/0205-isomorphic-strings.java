class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public boolean isIsomorphic(String s, String t) {
        return helper(s).equals(helper(t));
    }
    
    
    private String helper(String str) {
        // key - Character
        // Value - Index of first occurrence of that character in string str
        Map<Character, Integer> map = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        int len = str.length();    
    
        for(int i=0; i < len; i++) {
            char ch = str.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch, i);
            }
            sb.append(Integer.toString(map.get(ch)));
            sb.append("-");
        }
        
        return sb.toString();
    }
    
}

