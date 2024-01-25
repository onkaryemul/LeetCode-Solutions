class Solution {
    
    public int longestString(int x, int y, int z) {
        int ans = 0;
        
        int AAStart = 0;
        int BBStart = 0;
        
        int x1=x, y1=y;
        
        while(x1>0 && y1>0) {
            AAStart += 2;
            BBStart += 2;
            x1--;
            y1--;
        }
        
        if(x1 > 0) {
            AAStart++;
        }
        
        if(y1 > 0) {
            BBStart++;
        }
        
        ans = z + Math.max(AAStart, BBStart);
        
        return 2*ans;
    }
    
}

