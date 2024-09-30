/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */


class CustomStack {

    // Approach : Using array + Lazy Propagation  --> Better approach
    // TC : push -> O(1),  pop -> O(1), increment -> O(1)
    // SC : O(maxSize)
    
    private List<Integer> st;  // stack to hold the elements
    private List<Integer> increments; // to hold the increment values
    private int maxSize; // maximum size of the stack
    
    
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        st = new ArrayList<>();
        increments = new ArrayList<>();
    }
    
    // O(1)
    public void push(int x) {
        if(st.size() < maxSize) {
            st.add(x);
            increments.add(0); // initialize increment for the new element
        }
    }
    
    // O(1)
    public int pop() {
        if(st.size() == 0) {
            return -1; // Stack is empty
        }
        
        int idx = st.size() - 1; // top element idx
        
        // Carray over the increment to the previous element
        if(idx > 0) {
            increments.set(idx-1, increments.get(idx-1) +  increments.get(idx)); // lazy propagation
        }
        
        int topVal = st.get(idx) + increments.get(idx); // get the value of the top element 
        
        st.remove(idx); // pop the top element
        increments.remove(idx); // remove the corresponding increment
        
        return topVal; // return the topped value
    }
    
    // O(1)
    public void increment(int k, int val) {
        int idx = Math.min(k, st.size()) - 1; // get the correct  index
        
        if(idx >= 0) {
            increments.set(idx, increments.get(idx) + val); // Increment the bottom k elements
        }
    }
}

