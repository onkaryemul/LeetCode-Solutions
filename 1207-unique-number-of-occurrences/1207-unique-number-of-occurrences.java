class Solution {
    
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        HashSet<Integer> set = new HashSet<Integer>(map.values());
        
        return map.size() == set.size();
    }
    
}

