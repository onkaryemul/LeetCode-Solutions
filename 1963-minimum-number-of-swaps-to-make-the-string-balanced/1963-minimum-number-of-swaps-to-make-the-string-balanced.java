class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using Stack
    
    public int minSwaps(String s) {
        int n = s.length();
        
        Stack<Character> st = new Stack<>();
        
        int unbalanced = 0;
        
        // remove the balanced part from the given string
        for(int i=0; i < n; i++) {
            char ch = s.charAt(i);
            
            if(ch == '[') {
                st.push(ch);
            }
            else { // ch == ']'
                if(!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                }
                else {
                    unbalanced++;
                }
            }
        }
        
        if(unbalanced % 2 == 0) {
            return unbalanced / 2;
        }
        
        return (unbalanced + 1) / 2;
    }
    
}

