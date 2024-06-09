class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using HashMap 
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        
        // <remainder, freq>
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case input     
        
        int runningSum = 0;
        int n = nums.length;
        
        for(int i=0; i < n; i++) {
            runningSum += nums[i];
            
            int remainder = runningSum % k;
            
            // Edge case when remainder is negative, convert it into positive using k
            if(remainder < 0) {
                remainder = remainder + k;
            }
            
            // If remainder is present in map, then increase count with frequency of remainder
            if(map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            
            // for both when remainder is present in map or not present
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
    
}

