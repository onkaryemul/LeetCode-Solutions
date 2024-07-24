class Solution {
    
    // TC : O(logn)
    // SC : O(1)
    
    // Binary search technique
    public int[] searchRange(int[] nums, int target) {
        int first = getFirstOccurrence(nums, nums.length, target);
        
        if(first == -1) {
            return new int[]{-1, -1};
        }
        
        int last = getLastOccurrence(nums, nums.length, target);
        
        return new int[] {first, last};
    }
     
    
    // function to get first occurrence of element k in an array
    private int getFirstOccurrence(int[] nums, int n, int k) {
        int first = -1;
        
        int low = 0, high = n-1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == k) { // may be an answer
                first = mid;
                high = mid - 1; // look for smaller index on the left 
            }
            else if(nums[mid] < k) {
                low = mid + 1; // look on the right
            }
            else {
                high = mid - 1; // look on the left
            }
        }
        
        return first;
    }
    
    
    // function to get last occurrence of an element k in an array 
    private int getLastOccurrence(int[] nums, int n, int k) {
        int last = -1;
        
        int low = 0, high = n - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == k) { // may be an answer
                last = mid;
                low = mid + 1; // look for larger index on the right
            }
            else if(nums[mid] < k) {
                low = mid + 1; // look on the right
            }
            else {
                high = mid - 1; // look on the left
            }
        }
        
        return last;
    }
    
    
    /* 
        public static int count(int arr[], int n, int x) {
            int[] ans = firstAndLastPosition(arr, n, x);
            if (ans[0] == -1) return 0;
            return (ans[1] - ans[0] + 1);
        }
    */
    
}

