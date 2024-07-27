class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using stack
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        
        int number = 0;
        int result = 0;
        int sign = 1;
        
        int n = s.length();
        for(int i=0; i < n; i++) {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)) {
                number = 10 * number + (ch - '0');
            }
            else if (ch == '+') {
                result += (number * sign);
                number = 0;
                sign = 1;
            }
            else if (ch == '-') {
                result += (number * sign);
                number = 0;
                sign = -1;
            }
            else if (ch == '(') {
                st.push(result);
                st.push(sign);
                
                result = 0;
                number = 0;
                sign = 1;
            }
            else if (ch == ')') {
                result += (number * sign);
                number = 0;
                result *= st.pop(); // result = result * st.pop(), st.pop() is last_sign
                result += st.pop(); // result = result + st.pop(), st.pop() is last_result
            }
        }
        
        result += (number * sign);
        
        return result;
    }
    
}

