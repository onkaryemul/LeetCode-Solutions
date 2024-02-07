// Solution using Bucket sort
class Solution {
    
    // Main algorithm code
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
        }
        
        List<List<Character>> buckets = new ArrayList<>();
        
        for(int i=0; i <= maxFreq; i++) {
            buckets.add(new ArrayList<Character>());
        }
        
        for(Character key : map.keySet()) {
            int freq = map.get(key);
            buckets.get(freq).add(key);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int bucketVal = buckets.size() - 1; bucketVal >= 1; bucketVal--) {
            for(Character ch : buckets.get(bucketVal)) {
                for(int i=0; i < bucketVal; i++) {
                    sb.append(ch);
                }
            }
        }
        
        return sb.toString();
    }
    
}


