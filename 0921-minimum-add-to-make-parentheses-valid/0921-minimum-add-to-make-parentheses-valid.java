class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using stack
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        
        int open = 0; // to track how many open brackets we need
        
        int n = s.length();
        for(int i=0; i < n; i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                st.push(ch);
            }
            else { // ch == ')'
                if(!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }
                else {
                    open++; // add opening bracket for this closing bracket
                }
            }
        }
        
        // stack => will have open brackets if any
        // so, we need that many closing brackets for them
        // hence, st.size() => indicate no. of closing brackets we need to add make parenthesis valid
        
        return st.size() + open;
    }
    
}


/*
//Approach-2 (without using stack)
//T.C : O(n)
//S.C : O(1)

    public int minAddToMakeValid(String s) {
        int size = 0; // Tracks unmatched opening parentheses '('
        int open = 0; // Tracks unmatched closing parentheses ')'

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                size++; // Increment for each unmatched opening parenthesis
            } else if (size > 0) {
                size--; // Match an opening parenthesis if available
            } else {
                open++; // Unmatched closing parenthesis
            }
        }

        return open + size; // Sum of unmatched opening and closing parentheses
    }
*/

