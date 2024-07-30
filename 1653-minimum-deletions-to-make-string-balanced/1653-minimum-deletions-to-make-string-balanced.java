class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using stack
    public int minimumDeletions(String s) {
        int n = s.length();
        
        int cnt = 0; // keeps track of minimum number of deletions needed to make string s balanced
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i < n; i++) {
            if(!st.isEmpty() && s.charAt(i) == 'a' && st.peek() == 'b') { // 'ba'
                st.pop();
                cnt++;
            }
            else {
                st.push(s.charAt(i));
            }
        }
        
        return cnt;
    }
    
}


/* 
// Approach-4 (Constant space)
// T.C : O(2*n)
// S.C : O(1)

class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int counta = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a')
                counta++;
        }

        int count = Integer.MAX_VALUE;
        int countb = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a')
                counta--;
            count = Math.min(count, countb + counta);

            if (s.charAt(i) == 'b')
                countb++;
        }

        return count;
    }
}
*/

