class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Simple recursion approach
    public String countAndSay(int n) {
        // Base case
        if(n == 1) {
            return "1";
        }
        
        String say = countAndSay(n-1);
        
        StringBuilder result = new StringBuilder();
        int len = say.length();
        
        // Just count and store in result and return
        for(int i=0; i < len; i++) {
            int cnt = 1;
            char ch = say.charAt(i);
            
            while(i < len-1 && say.charAt(i) == say.charAt(i+1)) {
                cnt++;
                i++;
            }
            
            result.append(cnt).append(ch);
        }
        
        return result.toString();
    }
    
}


