class Solution {
    
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++) {
            
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            
            stack.push(i);
        }
        
        return answer;
    }
    
}


