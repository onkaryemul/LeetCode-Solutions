class Solution {
    
    // TC : O(n * k)
    // SC : O(1)
        
    // Using the concept of "get sum of digits of a number"
    public int getLucky(String s, int k) {
        int n = s.length();
        
        int total = 0;
        for(int i=0; i < n; i++) {
            int num = s.charAt(i) - 'a' + 1;
            
            while(num > 0) {
                total += num%10;
                num /= 10;
            }
        }
        
        k--;
        
        while(k > 0) {
            int newTotal = 0;
            
            while(total > 0) {
                newTotal += total%10;
                total /= 10;
            }
            
            total = newTotal;
            
            k--;
        }
        
        return total;
    }
    
}


