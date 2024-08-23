class Solution {
    
    // TC : O(n), n = length of string expression
    // SC : O(1)
    
    // Using Simple Simulation + Math
    public String fractionAddition(String expression) {
        int nume = 0; // Numerator
        int deno = 1; // Denominator
        
        int n = expression.length();
        int i = 0;
        
        while(i < n) {
            int currNume = 0; // Current fraction numerator
            int currDeno = 0; // Current fraction denominator
            
            boolean isNegative = (expression.charAt(i) == '-');
            
            // Skip '+' or '-'
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                i++;
            }
            
            // Build the current numerator
            while(i < n && Character.isDigit(expression.charAt(i))) {
                int val = expression.charAt(i) - '0';
                currNume = (currNume * 10) + val;
                i++;
            }
            
            i++; // Skip the division character '/'
            
            if(isNegative) {
                currNume *= -1; // Apply negative sign if needed
            }
            
            // Build the current denominator
            while(i < n && Character.isDigit(expression.charAt(i))) {
                int val = expression.charAt(i) - '0';
                currDeno = (currDeno * 10) + val;
                i++;
            }
            
            // Update the accumulated numerator and denominator
            nume = nume * currDeno + currNume * deno;
            deno = deno * currDeno;
        }
        
        // Simplify the fraction using the greater common divisor(GCD)
        int gcd = gcd(Math.abs(nume), deno);
        
        nume /= gcd;
        deno /= gcd;
        
        // return the result in the form of "numerator/denominator"
        return nume + "/" + deno;
    }
    
    
    // Helper method to calculate the greatest common divisor(GCD) using Euclidean algorithm
    private int gcd(int a, int b) {
        // Base case
        if(b == 0) {
            return a;
        }
        
        return gcd(b, a%b);
    }
    
}

