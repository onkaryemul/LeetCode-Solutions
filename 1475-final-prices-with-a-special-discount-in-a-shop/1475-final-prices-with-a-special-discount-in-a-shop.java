class Solution {
    
    // TC : O(2*n) ~ O(n)
    // SC : O(n) => due to stack
    
    // Using Monotonic Stack
    // using the approach of next smaller element(nse) on right 
    
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        
        int[] result = prices.clone(); // clone the prices array for result
        
        Stack<Integer> st = new Stack<>(); // Stack to keep track of indices
        
        for(int i=0; i < n; i++) {
            // Process stack while the current price(prices[i]) <= price at the index stores in the stack
            while(!st.isEmpty() && prices[i] <= prices[st.peek()]) {
                int index = st.pop(); // get the top index
                result[index] -= prices[i]; // apply the discount
            }
            
            st.push(i); // push the current index into the stack
        }
        
        return result;
    }
    
}

