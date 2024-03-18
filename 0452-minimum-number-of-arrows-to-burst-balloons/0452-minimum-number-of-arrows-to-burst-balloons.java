class Solution {
    
    // TC : O(n*logn)
    // SC : O(1)
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        int minArrows = 1;
        
        int prevStart = points[0][0];
        int prevEnd = points[0][1];
        
        for(int i=1; i < points.length; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];
            
            if(currStart > prevEnd) {
                minArrows++; // increase arrows
                prevStart = currStart;
                prevEnd = currEnd;
            }
            else {
                prevStart = Math.max(prevStart, currStart);
                prevEnd = Math.min(prevEnd, currEnd);
            }
        }
        
        return minArrows;
    }
    
}

