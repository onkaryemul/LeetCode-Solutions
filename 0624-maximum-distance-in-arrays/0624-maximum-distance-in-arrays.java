class Solution {
    
    // TC : O(m)
    // SC : O(1)
    
    // Greedy Approach
    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        
        int maxDist = 0;
        
        int prevSmall = arrays.get(0).get(0);
        int prevBig = arrays.get(0).get(arrays.get(0).size() - 1);
        
        for(int i=1; i < m; i++) {
            int currSmall = arrays.get(i).get(0);
            int currBig = arrays.get(i).get(arrays.get(i).size() - 1);
            
            maxDist = Math.max(maxDist, currBig - prevSmall);
            maxDist = Math.max(maxDist, prevBig - currSmall);
            
            prevSmall = Math.min(prevSmall, currSmall);
            prevBig = Math.max(prevBig, currBig);
        }
        
        return maxDist;
    }
    
}

