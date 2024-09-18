class Solution {
    
    // TC : O(log(num) to the base 16)
    // SC : O(16) ~ O(1)
    
    private static final String[] hexCode = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    
    // Decimal(base 10) to Hexadecimal(base 16) conversion
    public String toHex(int num) {
        // Base case
        if(num >= 0 && num <= 15) {
            return hexCode[num];
        }
        
        String hex = "";
        
        long val = (long)num;
        
        if(num < 0) { // For negative integers, two's complement method is used
            val = (long)Math.pow(2, 32) + num;
        }
        
        while(val > 0) {
            long rem = val % 16;
            hex = hexCode[(int)rem] + hex;
            val = val / 16;
        }
        
        return hex;
    }
    
}

