class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        int n = s.length();
        
        for(int i=0; i < n; i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                left.push(i); // push index of left parenthesis in left stack
            }
            else if (ch == '*') {
                star.push(i); // push index of star in star stack
            }
            else { // when current character is right parenthesis ')'
                if(!left.isEmpty()) {
                    // if left stack is not empty, then pop from left stack to balance with right parenthesis ')'
                    left.pop();
                }
                else if (!star.isEmpty()) {
                    // if star stack is not empty, then pop from star stack to balance with right parenthesis ')', considering * as left parenthesis
                    star.pop();
                }
                else {
                    return false;
                }
            }
        }
        
        while(left.size() != 0) {
            if(star.size() == 0) {
                return false; 
            }
            
            if(star.peek() > left.peek()) {
                star.pop();
                left.pop();
            } else {
                return false;
            }
        }
        
        return true;
    }
    
}

