class Solution {
    
    // TC : O(n) -> One pass solution
    // SC : O(n) 
    public int findMaxLength(int[] nums) {
        // key: Prefix Sum
        // Value: Position where Prefix sum was occured
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int maxLength = 0;
        
        int sum = 0;
        
        for(int i=0; i < nums.length; i++) {
            if(nums[i] == 0) {
                sum--;
            }
            else {
                sum++;
            }
            
            if(map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }
        
        return maxLength;
    }
    
}

