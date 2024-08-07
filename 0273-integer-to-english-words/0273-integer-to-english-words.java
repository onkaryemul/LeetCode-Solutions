class Solution {
    
    // TC : O(log10 (num)) --> no. of digits
    // SC : O(log10 (num)) --> recursive stack space (no. of digits)
    
    
    private static final String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    
    private static final String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private static final String[] belowHundred = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    
    // Using Recursion
    public String numberToWords(int num) {
        // Edge case / Corner case
        if(num == 0) {
            return "Zero";
        }
        
        return solve(num);
    }
     
    
    private String solve(int num) {
        if(num < 10) {
            return belowTen[num];
        }
        
        if(num < 20) {
            return belowTwenty[num-10];
        }
        
        if(num < 100) { // 89 = "Eighty Nine"
            return belowHundred[num/10] + ((num%10 != 0) ? " " + belowTen[num%10] : ""); 
        }
        
        if(num < 1000) { // 879 
            return solve(num/100) + " Hundred" + ((num%100 != 0) ? " " + solve(num%100) : "");
        }
        
        if(num < 1000000) {
            return solve(num/1000) + " Thousand" + ((num%1000 != 0) ? " " + solve(num%1000) : "");
        }
        
        if(num < 1000000000) {
            return solve(num/1000000) + " Million" + ((num%1000000 != 0) ? " " + solve(num%1000000) : "");
        }
        
        return solve(num/1000000000) + " Billion" + ((num%1000000000 != 0) ? " " + solve(num%1000000000) : "");
    }
    
}

