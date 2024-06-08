class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using HashMap 
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        // <remainder, index>
        HashMap<Integer, Integer> map = new HashMap<>();
        // remainder=0 at index=-1
        map.put(0, -1);
        
        int sum = 0;
        
        for(int i=0; i < n; i++) {
            sum += nums[i];
            
            int remainder = sum % k;
            
            if(map.containsKey(remainder)) {
                if(i - map.get(remainder) >= 2) {
                    return true;
                }
            }
            else {
                map.put(remainder, i);
            }
            
        }
        
        return false;
    }
    
}

