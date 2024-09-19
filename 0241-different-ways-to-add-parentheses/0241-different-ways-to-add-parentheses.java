class Solution {
    
    // TC : O(n^2 * 2^n)
    // SC : O(n^2 * 2^n)
    
    // Recursion + Dynamic Programming(DP)  --> to explore all possible ways 
    
    private List<Integer> numbers;
    private List<Character> operators;
    
    private List<Integer>[][] dp;
    
    
    public List<Integer> diffWaysToCompute(String expression) {
        parseExpression(expression);
        
        int n = numbers.size();
        dp = new ArrayList[n][n];
        
        return compute(0, n-1); // calling recursive function
    }
    
    
    // Recursive function -> Using Memoization
    private List<Integer> compute(int left, int right) {
        // Check if we have previously calculated
        if(dp[left][right] != null) {
            return dp[left][right];
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Base case
        if(left == right) {
            result.add(numbers.get(left));
        }
        else {
            for(int i = left; i < right; i++) {
                List<Integer> leftPart = compute(left, i);
                List<Integer> rightPart = compute(i+1, right);
                
                char op = operators.get(i);
                
                for(int l : leftPart) {
                    for(int r : rightPart) {
                        result.add(calculate(l, r, op));
                    }
                }
            }
        }
        
        dp[left][right] = result;
        
        return result;
    }


    // Helper function -> to calculate (a op b) where op can be '+', '-' or '*'
    private int calculate(int a, int b, char op) {
        if(op == '+') {
            return a + b;
        }
        
        if(op == '-') {
            return a - b;
        }
        
        return a * b;
    }
    
    
    // Helper function -> to parse the given expression & separate the numbers and operators in two different list
    private void parseExpression(String expression) {
        numbers = new ArrayList<>();
        operators = new ArrayList<>();
        
        int n = expression.length();
        int num = 0;
        
        for(int i=0; i < n; i++) {
            char ch = expression.charAt(i);
            
            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            else { // ch --> operator (op) (+, -, *)
                numbers.add(num);
                operators.add(ch);
                num = 0;
            }
        }
        
        numbers.add(num);
    }
    
}

