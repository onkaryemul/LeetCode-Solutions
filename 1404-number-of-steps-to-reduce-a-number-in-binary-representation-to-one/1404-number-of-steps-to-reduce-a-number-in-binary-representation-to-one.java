class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Approach 2 (Simply calculating for odd and even)
    public int numSteps(String s) {
        int n = s.length();
        
        int op = 0;
        int carry = 0;
        
        for(int i=n-1; i >= 1; i--) {
            if(((s.charAt(i) - '0') + carry) % 2 == 1) { // odd
                op += 2;
                carry = 1;
            }
            else {
                op += 1;
            }
        }
        
        return op + carry;
    }
 
}


/*  

// Approach 1 (Simple simulation - Do what is being asked)
// TC : O(N^2)
// SC : O(1)

class Solution {
    
    private void addOne(StringBuilder s) {
        int i = s.length() - 1;
        
        while (i >= 0 && s.charAt(i) != '0') {
            s.setCharAt(i, '0');
            i--;
        }
        
        if (i < 0) {
            s.insert(0, '1');
        } else {
            s.setCharAt(i, '1');
        }
    }

    public int numSteps(String s) {
        int op = 0;
        StringBuilder sb = new StringBuilder(s);
        
        while (sb.length() > 1) {
            int n = sb.length();
            
            if (sb.charAt(n - 1) == '0') {
                sb.deleteCharAt(n - 1);
            } else {
                addOne(sb);
            }
            
            op++;
        }
        
        return op;
    }
}

*/

