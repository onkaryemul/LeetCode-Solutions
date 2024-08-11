class StockSpanner {

    // N = no. of calls made to next
    
    // TC : O(2N), using "previous greater element" technique by stack approach
    // SC : O(N), for stack
    
    class Pair {
        int price;
        int index;
        
        public Pair(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }
    
    // Create a stack to store a pair of stock price with its index
    Stack<Pair> st;
    // Create a variable to track index of current price in list
    int index;
    
    
    // Monotonic Stack --> PGE(previous greater element)
    public StockSpanner() {
        st = new Stack<Pair>();
        index = -1;
    }
    
    public int next(int price) {
        index++; // keep track of current price's index in the list
        
        int result = 1;
        
        // Remove all pair of price & its index from stack whose value is <= price
        while(!st.isEmpty() && st.peek().price <= price) {
            st.pop();
        }
        
        // Check if stack is empty, if yes, it means that "no" greater element found on left side
        if(st.isEmpty()) {
            result = index + 1;
        }
        else { // else, return difference between current index & greater index on left
            result = index - st.peek().index;
        }
        
        // Push the current price with its index on top of stack
        st.push(new Pair(price, index));
        
        return result;
    }
    
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

