class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using LinkedHashMap --> for storing in the order in which they appear
    public String kthDistinct(String[] arr, int k) {
        String result = "";
        
        // Key: String
        // Value: frequency
        Map<String, Integer> map = new LinkedHashMap<>(); 
        for(String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        List<String> uniqueStrings = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                uniqueStrings.add(entry.getKey());
            }
        }
        
        int size = uniqueStrings.size();
        
        if(size < k) {
            return result;
        }
        
        return uniqueStrings.get(k-1); // since 0 indexed
    }
    
}

