class Solution {
    
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};
    
    private List<int[]> ans;
    private int count;
    
    
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        
        ans = new ArrayList<>();
        count = 0;
        
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(land[i][j] == 1) {
                    solve(i, j, m, n, land);
                    validate(i, j, m, n, land);
                }
            }
        }
 
        int[][] result = new int[ans.size()][4];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
    
    
    private void solve(int x, int y, int m, int n, int[][] land) {
        // Base case
        if(x<0 || y < 0 || x >= m || y >= n || land[x][y] == 0 || land[x][y] == 2) {
            return;
        }
        
        land[x][y] = 2;
        count++;
        
        for(int i=0; i < 4; i++) {
            solve(x + dx[i], y + dy[i], m, n, land);
        }
    }
    
    
    private void validate(int x, int y, int m, int n, int[][] land) {
        int r = x;
        int c = y;
        
        for(int i=x; i < m; i++) {
            if(land[i][y] == 2) {
                r = i;
            }
            else {
                break;
            }
        }
        
        for(int i=y; i < n; i++) {
            if(land[x][i] == 2) {
                c = i;
            }
            else {
                break;
            }
        }
        
        for(int i=x; i <= r; i++) {
            for(int j=y; j <= c; j++) {
                if(land[i][j] == 0) {
                    return;
                }
                
                if(i == x && i-1 >= 0 && land[i-1][j] == 2) {
                    return;
                }
                
                if(i == r && i+1 < m && land[i+1][j] == 2) {
                    return;
                }
                
                if(j == y && j-1 >= 0 && land[i][j-1] == 2) {
                    return;
                }
                
                if(j == c && j+1 < n && land[i][j+1] == 2) {
                    return;
                }
            }
        }
        
        ans.add(new int[]{x, y, r, c});
    }
    
}

