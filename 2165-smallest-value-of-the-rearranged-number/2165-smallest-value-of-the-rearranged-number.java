class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    public long smallestNumber(long num) {
        boolean isNegative = (num < 0);
    
        num = Math.abs(num);
        
        char[] charArray = ("" + num).toCharArray();
        
        Arrays.sort(charArray);
        
        int n = charArray.length;
        long ans = 0;
        
        if(isNegative) {
            String ansStr = "";
            for(int i=n-1; i >= 0; i--) {
                ansStr += charArray[i];
            }
            ans = - Long.parseLong(ansStr);
        }
        else {
            int i = 0;
            
            for(i=0; i < n; i++) {
                if(charArray[i] != '0') {
                    break;
                }
            }
            
            // Swap 0 with one zero char
            if(i <= (n-1)) {
                char temp = charArray[i];
                charArray[i] = charArray[0];
                charArray[0] = temp;
            }
            
            String res = String.valueOf(charArray);
            ans = Long.parseLong(res);
        }
        
        return ans;
    }
    
}

