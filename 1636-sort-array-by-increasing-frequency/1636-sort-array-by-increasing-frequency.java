class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Simple solution using hashmap and custom sorting
    public int[] frequencySort(int[] nums) {
        // element, frequency
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        List<Integer> list = new ArrayList<Integer>(map.keySet());
        
        // custom sorting using comparator
        Collections.sort(list, (a, b) -> {
            if(map.get(a) == map.get(b)) {
                return b - a;
            }
            else {
                return map.get(a) - map.get(b);
            }
        });
        
        int[] ans = new int[nums.length];
        int index = 0;
        
        for(int num : list) {
            int n = map.get(num);
            for(int i=0; i < n; i++) {
                ans[index] = num;
                index++;
            }
        }
        
        return ans;
    }
    
}

