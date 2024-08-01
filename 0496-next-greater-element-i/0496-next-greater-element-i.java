class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Monotonic Stack
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // key: Element, Value: Next greater element
        HashMap<Integer, Integer> map = new HashMap<>();
        // Element
        Stack<Integer> st = new Stack<>();
        
        for(int num : nums2) {
            while(!st.isEmpty() && st.peek() < num) {
                map.put(st.pop(), num);
            }
            st.push(num);
        }
        
        int n = nums1.length;
        int[] ans = new int[n];
        
        for(int i=0; i < n; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return ans;
    }
    
}

