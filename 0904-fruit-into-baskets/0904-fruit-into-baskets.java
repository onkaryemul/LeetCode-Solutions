class Solution {
    
    // TC : O(n)
    // SC : O(3) ~ O(1), for storing at max 3 elements
    
    // Sliding Window & two-pointers approach
    // Maximum length of subarray with at most 2 unique elements
    public int totalFruit(int[] fruits) {
        int maxLen = 0;
        
        // key: element, value : frequency
        Map<Integer, Integer> map = new HashMap<>();
        
        int i = 0;
        for(int j=0; j < fruits.length; j++) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            
            while(map.size() > 2) {
                map.put(fruits[i], map.get(fruits[i]) - 1);
                
                if(map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                }
                
                i++;
            }
            
            maxLen = Math.max(maxLen, j-i+1);
        }
        
        return maxLen;
    }
    
}

