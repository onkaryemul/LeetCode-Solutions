class Solution {
    
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch : order.toCharArray()) {
            if(!map.containsKey(ch)) {
                continue;
            }
            
            int count = map.get(ch);
            
            for(int i=0; i < count; i++) {
                sb.append(ch);
                map.remove(ch);
            }
        }
        
        for(Character key : map.keySet()) {
            int count = map.get(key);
            
            for(int i=0; i < count; i++) {
                sb.append(key);
            }
        }
        
        return sb.toString();
    }
    
}

