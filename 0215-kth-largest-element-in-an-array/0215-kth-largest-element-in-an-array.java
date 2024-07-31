class Solution {

    // TC : n*logk
    // SC : O(k)
    
    // Using Min-Heap technique
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        
        for(int num : nums) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
    
    
}


/*  
    //TC: O(nlogn) Sorting technique
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];
    }
    
    
    // TC : O(n) -> Best case    O(n^2) -> for worst case
    // SC : O(1)
    
    // Quick Select technique
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
         
        int start = 0;
        int end = nums.length - 1;
    
        while(start <= end) {
            int partitionIndex = partition(nums, start, end);
            
            if(partitionIndex == index) {
                return nums[index];
            }
            else if(partitionIndex > index) {
                end = partitionIndex - 1;
            }
            else { // (partitionIndex < index)
                start = partitionIndex + 1;
            }
        }
        
        return nums[start];
    }
    
    
    private int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        
        int pivot = high;
        
        while(i < j) {
            while(i < j && nums[i] <= nums[pivot]) {
                i++;
            }
            while(i < j && nums[j] >= nums[pivot]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        swap(nums, i, pivot);
        
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
*/

