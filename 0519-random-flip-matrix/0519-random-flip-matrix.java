class Solution {

    HashMap<Integer, Integer> map;
    int zeros;
    int n, m;
    Random rand;
    
    public Solution(int m, int n) {
        map = new HashMap<Integer, Integer>();
        zeros = m*n;
        this.n = n;
        this.m = m;
        rand = new Random();
    }
    
    public int[] flip() {
        int r = rand.nextInt(zeros);
        int actual = map.getOrDefault(r, r);
        
        int[] ret = new int[]{actual/n, actual%n};
        
        map.put(r, map.getOrDefault(zeros-1, zeros-1));
        
        zeros--;
        
        return ret;
    }
    
    public void reset() {
        map.clear();
        zeros = m*n;
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */