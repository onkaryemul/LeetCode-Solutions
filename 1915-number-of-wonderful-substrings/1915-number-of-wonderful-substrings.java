class Solution {
    
    // TC : O(n)
    // SC : O(1)
    public long wonderfulSubstrings(String word) {
        long result = 0;
        
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        
        int cum_xor = 0;
        
        for(char ch : word.toCharArray()) {
            int shift = ch - 'a';
            
            cum_xor ^= (1 << shift);
            
            result += map.getOrDefault((long)cum_xor, 0L);
            
            for(char ch1='a'; ch1 <= 'j'; ch1++) {
                shift = ch1 - 'a';
                
                long check_xor = (cum_xor ^ (1 << shift));
                
                result += map.getOrDefault(check_xor, 0L);
            } 
            
            map.put((long)cum_xor, map.getOrDefault((long)cum_xor, 0L) + 1);
        }
        
        
        return result;
    }
    
}

