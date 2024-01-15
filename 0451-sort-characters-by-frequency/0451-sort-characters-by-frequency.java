// Solution using Bucket sort
class Solution {
    
    // helper function -> function to return bucket array
    private List<Character>[] buildBucketArray(Map<Character, Integer> map, int maxCount) {
        List<Character>[] array = new List[maxCount+1];
        
        for(Character ch : map.keySet()) {
            int count = map.get(ch);
            if(array[count] == null) {
                array[count] = new ArrayList<>();
            }
            array[count].add(ch);
        }
        
        return array;
    }
    
    
    // helper function -> function to build output string from bucket array
    private String buildOutputString(List<Character>[] array) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=array.length-1; i>0; i--) {
            List<Character> list = array[i];
            
            if(list != null) {
                
                for(Character ch : list) {
                    for(int j=0; j<i; j++) {
                        sb.append(ch);
                    }
                }
                
            }
        }
        
        return sb.toString();
    }
    
    
    // Main algorithm code
    public String frequencySort(String s) {
        // Corner case
        if(s == null) {
            return null;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        char[] charArray = s.toCharArray();
        int max = 0;
        
        for(Character ch : charArray) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            max = Math.max(max, map.get(ch));
        }
        
        
        List<Character>[] array = buildBucketArray(map, max);
        
        
        return buildOutputString(array);
    }
    
}

