class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Cumulative Sum  --> Prefix Sum
    
    // Using prefix sum modulo & storing in hashmap
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        
        int sum = 0;
        // Calculate the sum of all elements & take % p
        for(int num : nums) {
            sum = (sum + num) % p;
        }
        
        int target = sum % p;
        
        // If sum is already divisible by p, no need to remove any subarray
        if(target == 0) {
            return 0;
        }
        
        // key : prefix sum remainder
        // Value : index where it occured
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize with remainder 0 at index -1
        // ie. prefix sum 0 at index -1
        
        int curr = 0;
        int result = n; // length of smallest subarray that is to be removed
        
        // Traverse through the array
        for(int j=0; j < n; j++) {
            curr = (curr + nums[j]) % p;
            
            // Calculate the remainder needed to achieve the target
            int remain = (curr - target + p) % p; // handling negative remainders
            
            // If the required remainder exists in the map, then update the result
            if(map.containsKey(remain)) {
                result = Math.min(result, j - map.get(remain));
            }
            
            // Store the current remainder(prefix sum remainder) with its index
            map.put(curr, j);
        }
        
        return result == n ? -1 : result;
    }
    
}

