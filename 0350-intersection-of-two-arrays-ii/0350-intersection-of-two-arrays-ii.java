class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using map
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int num : nums2) {
            if(map.getOrDefault(num, 0) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        int n = result.size();
        int[] intersection = new int[n];
        
        for(int i=0; i < n; i++) {
            intersection[i] = result.get(i);
        }
        
        return intersection;
    }
    
}
