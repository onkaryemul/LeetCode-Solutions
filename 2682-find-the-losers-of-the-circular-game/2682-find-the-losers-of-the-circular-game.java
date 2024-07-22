class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    public int[] circularGameLosers(int n, int k) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        int curr = 0;
        int round = 1;
        
        while(true) {
            curr = (curr + round * k) % n;
            if(visited.contains(curr)) {
                break;
            }
            visited.add(curr);
            round++;
        }
        
        int[] ans = new int[n - visited.size()];
        int index = 0;
        
        for(int i=0; i < n; i++) {
           if(!visited.contains(i)) {
               ans[index] = i+1;
               index++;
           }
        }
        
        return ans;
    }
    
}

