class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Simple HashMap solution
    public boolean containsDuplicate(int[] nums) {
        // element, index
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], i);
        }
        
        return false;
    }
    
}

