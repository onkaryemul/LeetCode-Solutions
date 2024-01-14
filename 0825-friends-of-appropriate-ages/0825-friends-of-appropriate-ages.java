class Solution {
    
    public int numFriendRequests(int[] ages) {
        int[] ageCount = new int[121]; // age can be from 1 to 120
        
        for(int age : ages) {
            ageCount[age]++;
        }
        
        int ans = 0; // stores total number of friend requests made
        
        for(int ageX=1; ageX <= 120; ageX++) {
            // ageY starts from ageX/2 + 8  --> ensures that ageY > ageX/2 + 7 --> case 1 fails
            // and also --> ensures that ageY <= ageX --> case 2 fails
            // case 3 --> subset of case 2 , hence it also fails
            for(int ageY=(ageX/2 + 8); ageY <= ageX; ageY++) {
                // for ageX == ageY  --> no. of requests = freq(ageX) * (freq(ageY)-1)
                // for ageX != ageY  --> no. of requests = freq(ageX) * freq(ageY) 
                ans += ageCount[ageX] * (ageCount[ageY] - (ageX==ageY ? 1 : 0));
            }
        }
        
        return ans;
    }
    
}

