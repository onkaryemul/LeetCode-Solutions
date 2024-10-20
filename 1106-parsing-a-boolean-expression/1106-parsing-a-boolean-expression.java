class Solution {
    
    // TC : O(n)
    // SC : O(n), using stack
    
    // Using Optimal approach
    // ie. "not using any other data structures than stack" => e.g list to store all 't', 'f' & then evaluating this list for the given operator(&, |, !)
    
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i < n; i++) {
            char ch = expression.charAt(i);
            
            // Ignore ',' and '('
            if(ch == ',' || ch == '(') {
                continue;
            }
            
            if(ch == '&' || ch == '|' || ch == '!' || ch == 't' || ch == 'f') {
                st.push(ch);
            }
            else if (ch == ')') { 
                boolean hasTrue = false, hasFalse = false;
                
                while(st.peek() != '&' && st.peek() != '|' && st.peek() != '!') {
                    char currCh = st.pop();
                    if(currCh == 't') {
                        hasTrue = true;
                    }
                    else if(currCh == 'f') {
                        hasFalse = true;
                    }
                }
                
                char opr = st.pop();
                
                if(opr == '&') {
                    if(hasFalse) {
                        st.push('f');
                    }
                    else {
                        st.push('t');
                    }
                }
                else if(opr == '|') {
                    if(hasTrue) {
                        st.push('t');
                    }
                    else {
                        st.push('f');
                    }
                }
                else if(opr == '!') {
                    st.push(hasTrue ? 'f' : 't');
                }
            }
        }
        
        // return true if stack peek is 't', otherwise false
        return st.peek() == 't' ? true : false;
    }
    
}

