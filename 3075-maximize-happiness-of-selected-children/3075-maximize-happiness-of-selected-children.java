class Solution {
    
    // Greedy Approach
    // Stack 
    public long maximumHappinessSum(int[] happiness, int k) {
        // 1. Sort the happiness array in increasing
        Arrays.sort(happiness);
        
        // 2. Store all sorted happiness in stack so that we can get highest happiness on top of stack
        Stack<Integer> stack = new Stack<>();
        for(int num : happiness) {
            stack.push(num);
        }
        
        long happinessSum = 0;
        
        int i = 0; // tracks how much we have to substract from the current element
        
        while(k-- != 0 && !stack.isEmpty()) {
            int curr = stack.pop();
            
            if((curr - i) > 0) {
                happinessSum += (curr - i);
            }
            
            i++; // increment substraction value for next elements from stack
        }
        
        return happinessSum;
    }
    
}

