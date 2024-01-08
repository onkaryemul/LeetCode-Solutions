class Solution {
    
    public int[][] imageSmoother(int[][] img) {
        int n = img.length; // no. of rows
        int m = img[0].length; // no. of columns
        
        int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        
        
        int[][] ans = new int[n][m];
        
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int sum = img[i][j];
                int count = 1;
                
                for(int p=0; p<8; p++) {
                    int newX = i + dx[p];
                    int newY = j + dy[p];
                    
                    if(newX>=0 && newX<n && newY>=0 && newY<m) {
                        sum += img[newX][newY];
                        count++;
                    }
                }
                
                ans[i][j] = sum/count;
            }
        }
        
        
        return ans;
    }
    
}

