class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using stack and queue
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(ch == ')') {
                Queue<Character> queue = new LinkedList<>();
                
                while(!st.empty() && st.peek() != '(') {
                    queue.add(st.pop());
                }
                
                st.pop();
                
                while(queue.size() > 0) {
                    st.push(queue.remove());
                }
            }
            else { // ( abc
                st.push(ch);
            }
        }
        
        char[] charArray = new char[st.size()];
        
        int i = charArray.length - 1;
        while(i >= 0) {
            charArray[i] = st.pop();
            i--;
        }
        
        return new String(charArray);
    }
    
}

