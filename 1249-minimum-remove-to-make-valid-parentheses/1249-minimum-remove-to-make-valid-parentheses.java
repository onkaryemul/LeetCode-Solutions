class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Pair<Character, Integer>> st = new Stack<>();
        
        for(int i=0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == ')') {
                if(st.empty()) {
                    st.push(new Pair<>(ch, i));
                } 
                else {
                    if(ch == ')' && st.peek().getKey() == '(') {
                        st.pop();
                    } 
                    else {
                        st.push(new Pair<>(ch, i));
                    }
                }
            }
        }
        
        Set<Integer> indexesToBeRemoved = new HashSet<>();
        
        while(!st.empty()) {
            indexesToBeRemoved.add(st.peek().getValue());
            st.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i < n; i++) {
            if(!indexesToBeRemoved.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
}

