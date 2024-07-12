class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Greedy Approach - Using stack
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        
        int ans = 0;
        
        boolean flag;
        if(x > y) {
            flag = true;
        }
        else {
            flag = false;
        }
        
        // 1. Traversing on given string, and greedily removing substring 
        // Pushing contents on stack1
        for(char ch : s.toCharArray()) {
            if(!stack1.isEmpty()) {
                if(flag) { // when x > y, then remove "ab"
                    if(stack1.peek() == 'a' && ch == 'b') {
                        ans += x;
                        stack1.pop();
                    }
                    else {
                        stack1.push(ch);
                    }
                }
                else { // when y > x, then remove "ba"
                    if(stack1.peek() == 'b' && ch == 'a') {
                        ans += y;
                        stack1.pop();
                    }
                    else {
                        stack1.push(ch);
                    }
                }
            }
            else {
                stack1.push(ch);
            }
        }
        
        
        // 2. Iterate over stack1 and remove other substring which is not removed in above step
        // Pushing contents stack2 using stack1
        for(char ch : stack1) {
            if(!stack2.isEmpty()) {
                if(!flag) { // when y > x, then we removed "ba" above, hence here remove "ab"
                    if(stack2.peek() == 'a' && ch == 'b') {
                        ans += x;
                        stack2.pop();
                    }
                    else {
                        stack2.push(ch);
                    }
                }
                else { // when x > y, then we removed greadily "ab", hence here remove "ba" substring
                    if(stack2.peek() == 'b' && ch == 'a') {
                        ans += y;
                        stack2.pop();
                    }
                    else {
                        stack2.push(ch);
                    }
                }
            }   
            else {
                stack2.push(ch);
            }
        }
        
        return ans;
    }
    
}

