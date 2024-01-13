class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k<0) {
            return 0;
        }
        
        int count = 0;
        
        // create the frequency map
        Map<Integer, Integer> map = new HashMap<>(); // store the frequency of numbers 
        
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(k == 0) {
                if(entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if(map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        
        return count;
    }
    
}

