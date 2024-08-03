class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using HashMap
    public boolean canBeEqual(int[] target, int[] arr) {
        // key: num, Value: frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : target) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int num : arr) {
            if(!map.containsKey(num)) {
                return false;
            }
            
            map.put(num, map.get(num) - 1);
            
            if(map.get(num) == 0) {
                map.remove(num);
            }
        }
        
        return map.isEmpty();
    }
    
}

