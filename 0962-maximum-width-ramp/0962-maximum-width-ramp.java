class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using Monotonic Stack
    // pushing "index of elements" on to the stack => such that "elements" in "strictly decreasing order"
    
    public int maxWidthRamp(int[] nums) {
        int maxRampWidth = 0;
        
        // Monotonic stack 
        // elements in "strictly decreasing order"
        Stack<Integer> st = new Stack<>();
        
        int n = nums.length;
        
        // traverse from left to right
        for(int i=0; i < n; i++) {
            if(st.isEmpty() || nums[st.getLast()] > nums[i]) {
                st.push(i);
            }
        }
        
        // traverse from right to left
        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.getLast()] <= nums[i]) {
                int diff = i - st.getLast();
                st.pop();
                maxRampWidth = Math.max(maxRampWidth, diff);
            }
            
            if(st.isEmpty()) {
                return maxRampWidth;
            }
        }
        
        return maxRampWidth;
    }
    
}

