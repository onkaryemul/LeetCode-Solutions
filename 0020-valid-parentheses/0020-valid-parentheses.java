class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Simple and basic approach using stack
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(stack.isEmpty() || ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }
            
            if(ch == ')') {
                if(stack.peek() == '(') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else if (ch == '}') {
                if(stack.peek() == '{') {
                    stack.pop();
                }
                else {
                    return false;
                }
            } 
            else if (ch == ']') {
                if(stack.peek() == '[') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
}

