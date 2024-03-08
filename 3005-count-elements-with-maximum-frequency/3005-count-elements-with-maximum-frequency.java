class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int max = 0;
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }
        
        int count = 0;
        
        List<Integer> list = new ArrayList<>(map.values());
        
        for(int freq : list) {
            if(freq == max) {
                count += freq;
            }
        }
        
        return count;
    }
    
}

