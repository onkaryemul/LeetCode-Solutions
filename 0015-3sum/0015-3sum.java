class Solution {
    
    // TC : O(N*logN) + O(N^2)
    // SC : O(no. of quadruplets) ~ O(1)
    
    // Using sorting + two pointers approach
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the nums[]
        Arrays.sort(nums);
        
        int n = nums.length;
        
        List<List<Integer>> triplets = new ArrayList<>();
               
        for(int i=0; i < n; i++) {
            // remove duplicates
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            } 
            
            // Moving 2 pointers
            int j = i+1;
            int k = n-1;
            
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {
                    List<Integer> tempTriplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    triplets.add(tempTriplet);
                    
                    j++;
                    k--;
                    
                    // skip the duplicates
                    while(j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    
                    while(j < k && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
            }
        }
        
        return triplets;
    }
    
}

