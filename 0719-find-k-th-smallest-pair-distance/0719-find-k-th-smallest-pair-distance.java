class Solution {
    
    // TC : O(n*logn + n*logM), where n*logn is for sorting nums array & n*logM is because of binary search and sliding window
    
    // SC : O(1)
    
    
    // Sorting + Binary Search + Sliding Window
    public int smallestDistancePair(int[] nums, int k) {
        // 1. Sort the nums array
        Arrays.sort(nums);
        
        // 2. Apply binary search on sorted array & count pair having distance <= mid at each iteration using sliding window technique
        int n = nums.length;
        
        int low = 0; // lowest distance
        int high = nums[n-1] - nums[0]; // highest distance
        
        int result = 0;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            int cntPairs = slidingWindowCount(nums, mid); // return no. of pairs with distance <= mid
            if(cntPairs < k) {
                low = mid + 1;
            }
            else {
               result = mid; // store the mid as a potential result
               high = mid - 1;
            }
        }
        
        return result;
    }
    
    
    // Function to find the count of pairs havind distance <= D
    private int slidingWindowCount(int[] nums, int D) {
        int cnt = 0;
        
        int n = nums.length;
        int i = 0;
        int j = 1;
        
        while(j < n) {
            while(i < n && nums[j] - nums[i] > D) {
                i++;
            }
            
            cnt += (j-i);
            
            j++;
        }
        
        return cnt;
    }
    
    
}

