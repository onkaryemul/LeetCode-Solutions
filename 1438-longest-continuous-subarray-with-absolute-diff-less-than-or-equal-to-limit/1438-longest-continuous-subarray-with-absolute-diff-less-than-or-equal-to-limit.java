class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Dequeue Approach - Most optimal solution
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> increase = new LinkedList<>();
        LinkedList<Integer> decrease = new LinkedList<>();

        int max = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];

            while (increase.size() > 0 && currNum < increase.getLast()) {
                increase.removeLast();
            }
            
            increase.add(currNum);

            while (decrease.size() > 0 && currNum > decrease.getLast()) {
                decrease.removeLast();
            }

            decrease.add(currNum);

            while (decrease.getFirst() - increase.getFirst() > limit) {
                if (nums[left] == decrease.getFirst()) {
                    decrease.removeFirst();
                }
                if (nums[left] == increase.getFirst()) {
                    increase.removeFirst();
                }
                left++;
            }

            int size = i - left + 1;
            max = Math.max(max, size);
        }

        return max;
    }
    
}

