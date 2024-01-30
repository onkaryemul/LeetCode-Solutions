class Solution {
    
    // Evaluation of Postfix Notation
    public int evalRPN(String[] tokens) {
        // SC : O(n)
        Stack<String> stack = new Stack<>();
        
        // TC : O(n)
        for(String token : tokens) {
            // Check if current token is an operator 
            if(isOperator(token)) {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                
                int result = 0;
                
                if(token.equals("+")) {
                    result = num1 + num2;
                } 
                else if (token.equals("-")) {
                    result = num1 - num2;
                }
                else if (token.equals("*")) {
                    result = num1 * num2;
                }
                else if (token.equals("/")) {
                    result = num1 / num2;
                }
                
                stack.push(Integer.toString(result));
            }
            else {
                stack.push(token);
            }
        }
        
        
        return Integer.parseInt(stack.peek());
    }
    
    
    // helper function
    private boolean isOperator(String str) {
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        }
        
        return false;
    }
    
}

