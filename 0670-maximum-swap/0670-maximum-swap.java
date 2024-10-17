class Solution {
    
    // Constraints : 0 <= num <= 10^8
    // max no. of digits in given num => 9
    
    // TC : O(no.of digits * 10) ~ O(no. of digits) ~ O(1)
    // SC : O(no.of digits + 10) ~ O(1)
    
    // Using simple simulation (Math + Greedy)
    public int maximumSwap(int num) {
        // Base case / Edge case 
        // If num < 10, then return num as it is, since there is only one digit
        if(num < 10) {
            return num;
        }
        
        String numStr = String.valueOf(num);
        
        char[] digits = numStr.toCharArray();
        
        // last index => right most index 
        int[] last = new int[10]; // ho hold the last index of each digit
        
        int n = digits.length;
        for(int i=0; i < n; i++) {
            last[digits[i] - '0'] = i; // digits[i] - '0' => converts char to num
        }
        
        for(int i=0; i < n; i++) { // index of present digit we are looking at
            // max digit could be 9 & min be greater than the present digit we are looking at
            for(int d=9; d > digits[i]-'0'; d--) {
                // if index of 'd' (start with 9) is greater than present index (basically, is the bigger digit at RIGHT of present digit)
                if(last[d] > i) {
                    // swap & return the answer
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    
                    return Integer.parseInt(new String(digits));
                }
            }   
        }
        
        // If we reach till here, that means no swapping is required in the input number
        return num;
    }
    
}

