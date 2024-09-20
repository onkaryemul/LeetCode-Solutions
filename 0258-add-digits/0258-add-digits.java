class Solution {
    
    // Using Brute Force
    
    private int sum;
    
    public int addDigits(int num) {
        sum = 0;
        
        while(getCountDigits(num) > 1) {
            num = sum;
        }
        
        return sum;
    }
    
    
    // Helper function -> to calculate no. of digits in num & their sum (updating globally)
    // Return no. of digits in num 
    private int getCountDigits(int num) {
        sum = 0; // starting sum = 0 for each iteration
        
        int cnt = 0; 
        
        while(num > 0) {
            sum += num % 10;
            cnt++;
            num /= 10;
        }
        
        return cnt;
    }
    
}


/*
    // Using Maths 
 
    // TC : O(1)
    // SC : O(1)
    
    public int addDigits(int num) {
       // Base case
       if(num == 0) {
           return 0;
       }
       
       if(num % 9 == 0) {
           return 9;
       }
       
       return num % 9;
    }
*/

