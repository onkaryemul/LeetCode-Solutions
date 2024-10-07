class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using Stack approach
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        
        int n = s.length();
        
        for(int i=0; i < n; i++) {
            char currChar = s.charAt(i);
            
            if(st.isEmpty()) {
                st.push(currChar);
                continue;
            }
            
            if(currChar == 'B' && st.peek() == 'A') {
                st.pop();
            }
            else if(currChar == 'D' && st.peek() == 'C') {
                st.pop();
            }
            else {
                st.push(currChar);
            }   
        }
        
        return st.size();
    }
    
}

