class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public String makeGood(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i < n; i++) {
            if(!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) == 32) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
    
}

