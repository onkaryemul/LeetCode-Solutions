class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    public int countSeniors(String[] details) {
        int cnt = 0; // no. of passengers who are strictly greater than 60 years old
        
        for(String passenger : details) {
            int age = Integer.parseInt(passenger.substring(11, 13));
            if(age > 60) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
}

