class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    public int scoreOfParentheses(String s) {
        Stack<String> st = new Stack<>();
        
        int n = s.length();
        for(int i=0; i < n; i++) {
            char ch = s.charAt(i);
            
            if(st.empty()) {
                st.push(ch + "");
            }
            else {
                if(ch == ')') {
                    int innerScore = 0;
                    
                    while(!st.empty() && !st.peek().equals("(")) {
                        innerScore += Integer.valueOf(st.pop());
                    }
                    
                    st.pop();
                    
                    if(innerScore == 0) { // ()
                        st.push("1");
                    }
                    else {
                        st.push(2*innerScore + "");
                    }
                }
                else {
                    st.push(ch + "");
                }
            }
        }
        
        int score = 0;
        while(!st.empty()) { // ()()()
            score += Integer.valueOf(st.pop());
        }
        
        return score;
    }
    
}


