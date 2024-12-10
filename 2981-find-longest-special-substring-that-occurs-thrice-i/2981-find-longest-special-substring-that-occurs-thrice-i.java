class Solution {
    
    // TC : O(n^2), where n = length of string s
    // SC : O(n) => due to extra space taken by HashMap
    
    // Using HashMap to store substring and their frequency
    
    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int n = s.length();
        
        for(int i = 0; i < n; i++) { // i < n
            for(int j = i + 1; j <= n; j++) { // j <= n
                String str = s.substring(i, j);
                
                if(map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                }
                else {
                    map.put(str, 1);
                }
            }
        }
        
        int len = 0;
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            
            int stringCount = entry.getValue();
            
            if(stringCount >= 3) {
                Set<Character> set = new HashSet<>();
                
                for(int j=0; j < str.length(); j++) {
                    set.add(str.charAt(j));
                }
                
                if(set.size() == 1) {
                    len = Math.max(len, str.length());
                }
            }
        }
        
        return len == 0 ? -1 : len;
    }
    
}


